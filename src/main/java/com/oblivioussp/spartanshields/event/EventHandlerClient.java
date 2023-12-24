package com.oblivioussp.spartanshields.event;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.oblivioussp.spartanshields.item.ItemShieldBase;
import com.oblivioussp.spartanshields.network.NetworkHandler;
import com.oblivioussp.spartanshields.network.PacketShieldBash;
import com.oblivioussp.spartanshields.util.ConfigHandler;
import com.oblivioussp.spartanshields.util.LogHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.MouseEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class EventHandlerClient 
{

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onInputEvent(InputEvent ev)
	{
		//boolean activateShieldBash = false;
		Minecraft mc = Minecraft.getMinecraft();
		
		EntityPlayer player = mc.player;
		ItemStack mainHand = player.getHeldItemMainhand(),
				offHand = player.getHeldItemOffhand(),
				shieldStack = ItemStack.EMPTY;
		
		//if(offHand)
		//if(!activateShieldBash)
		//{
		if(!ConfigHandler.disableShieldBash && player.isActiveItemStackBlocking() && mc.gameSettings.keyBindAttack.isPressed())
		{
			//activateShieldBash = true;
			EnumHand shieldHand = null;
			if(mainHand.getItem() instanceof ItemShieldBase)
			{
				shieldStack = mainHand;
				shieldHand = EnumHand.MAIN_HAND;
			}
			else if(offHand.getItem() instanceof ItemShieldBase)
			{
				shieldStack = offHand;
				shieldHand = EnumHand.OFF_HAND;
			}
			if(shieldStack.isEmpty() || shieldHand == null)
				return;
			
			if(player.getCooldownTracker().hasCooldown(shieldStack.getItem()))
				return;
			
			RayTraceResult result = getMouseOverExtended(4.0f);
			
			if(result != null)
			{
				int entId = -1;
				boolean attackEntity = true;
				
				//LogHelper.info("SHIELD BASH!!! >|< ");
				if(result.entityHit != null && result.entityHit != player)
				{
					LogHelper.debug("Hit Entity with Shield Bash! - " + result.entityHit.toString());
					entId = result.entityHit.getEntityId();
				}
				
				if(entId == -1)
				{
					entId = 0;
					attackEntity = false;
				}
				
				player.swingArm(shieldHand);
				
				NetworkHandler.sendPacketToServer(new PacketShieldBash(shieldHand, entId, attackEntity));
				//ev.setCanceled(true);
			}
		}
		//}
		//else
		//	activateShieldBash = false;
		
		/*if(mc.gameSettings.isKeyDown(mc.gameSettings.keyBindAttack))
		{
			LogHelper.info("Attack keybind pressed!");
		}*/
	}
	
	/*@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onMouseEvent(MouseEvent ev)
	{
		EntityPlayer player = Minecraft.getMinecraft().player;
		ItemStack mainHand = player.getHeldItemMainhand(),
				offHand = player.getHeldItemOffhand(),
				shieldStack = ItemStack.EMPTY;
		
		//if(offHand)
		if(player.isActiveItemStackBlocking() && ev.getButton() == 0 && ev.isButtonstate())
		{
			EnumHand shieldHand = null;
			if(mainHand.getItem() instanceof ItemShieldBase)
			{
				shieldStack = mainHand;
				shieldHand = EnumHand.MAIN_HAND;
			}
			else if(offHand.getItem() instanceof ItemShieldBase)
			{
				shieldStack = offHand;
				shieldHand = EnumHand.OFF_HAND;
			}
			if(shieldStack.isEmpty() || shieldHand == null)
				return;
			
			if(player.getCooldownTracker().hasCooldown(shieldStack.getItem()))
				return;
			
			RayTraceResult result = getMouseOverExtended(4.0f);
			
			if(result != null)
			{
				int entId = -1;
				boolean attackEntity = true;
				
				//LogHelper.info("SHIELD BASH!!! >|< ");
				if(result.entityHit != null && result.entityHit != player)
				{
					LogHelper.debug("Hit Entity with Shield Bash! - " + result.entityHit.toString());
					entId = result.entityHit.getEntityId();
				}
				
				if(entId == -1)
				{
					entId = 0;
					attackEntity = false;
				}
				
				player.swingArm(shieldHand);
				
				NetworkHandler.sendPacketToServer(new PacketShieldBash(shieldHand, entId, attackEntity));
				ev.setCanceled(true);
			}
		}
		//LogHelper.info("Mouse event! - " + ev.getButton());
	}*/
	
	protected static RayTraceResult getMouseOverExtended(float distance)
	{
		RayTraceResult result = null;
		Minecraft mc = Minecraft.getMinecraft();
		Entity renderViewEntity = mc.getRenderViewEntity();

        if (renderViewEntity != null)
        {
            if (mc.world != null)
            {
//                mc.pointedEntity = null;
                double d0 = distance;
                result = renderViewEntity.rayTrace(d0, 0);
                Vec3d eyePos = renderViewEntity.getPositionEyes(0);
                boolean flag = false;
//                int i = 3;
                double d1 = d0;

                if (mc.playerController.extendedReach() && d1 < 6.0D)
                {
                    d1 = 6.0D;
                    d0 = d1;
                }
                else
                {
                    if (d0 > distance)
                    {
                        flag = true;
                    }
                }

                if (result != null)
                {
                    d1 = result.hitVec.distanceTo(eyePos);
                }

                Vec3d lookVec = renderViewEntity.getLook(0);
                Vec3d vec3d2 = eyePos.addVector(lookVec.x * d0, lookVec.y * d0, lookVec.z * d0);
                Entity pointedEntity = null;
                Vec3d vec3d3 = null;
//                float f = 1.0F;
                List<Entity> list = mc.world.getEntitiesInAABBexcluding(renderViewEntity, renderViewEntity.getEntityBoundingBox().expand(lookVec.x * d0, lookVec.y * d0, lookVec.z * d0).expand(1.0D, 1.0D, 1.0D), Predicates.and(EntitySelectors.NOT_SPECTATING, new Predicate<Entity>()
                {
                    public boolean apply(@Nullable Entity p_apply_1_)
                    {
                        return p_apply_1_ != null && p_apply_1_.canBeCollidedWith();
                    }
                }));
                double d2 = d1;

                for (int j = 0; j < list.size(); ++j)
                {
                    Entity entity1 = list.get(j);
                    AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().grow(entity1.getCollisionBorderSize());
                    RayTraceResult result0 = axisalignedbb.calculateIntercept(eyePos, vec3d2);

                    if (axisalignedbb.contains(eyePos))
                    {
                        if (d2 >= 0.0D)
                        {
                            pointedEntity = entity1;
                            vec3d3 = result0 == null ? eyePos : result0.hitVec;
                            d2 = 0.0D;
                        }
                    }
                    else if (result0 != null)
                    {
                        double d3 = eyePos.distanceTo(result0.hitVec);

                        if (d3 < d2 || d2 == 0.0D)
                        {
                            if (entity1.getLowestRidingEntity() == renderViewEntity.getLowestRidingEntity() && !renderViewEntity.canRiderInteract())
                            {
                                if (d2 == 0.0D)
                                {
                                    pointedEntity = entity1;
                                    vec3d3 = result0.hitVec;
                                }
                            }
                            else
                            {
                                pointedEntity = entity1;
                                vec3d3 = result0.hitVec;
                                d2 = d3;
                            }
                        }
                    }
                }

                if (pointedEntity != null && flag && eyePos.distanceTo(vec3d3) > distance)
                {
                    pointedEntity = null;
                    result = new RayTraceResult(RayTraceResult.Type.MISS, vec3d3, (EnumFacing)null, new BlockPos(vec3d3));
                    LogHelper.debug("Ray Trace for extended reach has missed!");
                }

                if (pointedEntity != null && (d2 < d1 || result == null))
                {
                    result = new RayTraceResult(pointedEntity, vec3d3);
                    LogHelper.debug("Ray Trace for extended reach has hit a " + pointedEntity.toString() + " d1 = " + d1 + " - d2 = " + d2);
                    
                    if (pointedEntity instanceof EntityLivingBase || pointedEntity instanceof EntityItemFrame)
                    {
//                        mc.pointedEntity = pointedEntity;
                    }
                }
            }
        }
        
        return result;
	}
}
