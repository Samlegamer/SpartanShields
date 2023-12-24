package com.oblivioussp.spartanshields.network;

import com.oblivioussp.spartanshields.item.ItemShieldBase;
import com.oblivioussp.spartanshields.util.ConfigHandler;
import com.oblivioussp.spartanshields.util.LogHelper;

import io.netty.buffer.ByteBuf;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Enchantments;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class PacketShieldBash extends PacketBase<PacketShieldBash> 
{
	protected int entityId;
	protected boolean attackEntity = false;
	protected EnumHand hand;
	
	public PacketShieldBash() {}
	
	public PacketShieldBash(EnumHand enumHand, int entId, boolean atkEntity)
	{
		hand = enumHand;
		entityId = entId;
		attackEntity = atkEntity;
	}

	@Override
	public void fromBytes(ByteBuf buf) 
	{
		hand = EnumHand.values()[ByteBufUtils.readVarInt(buf, 1)];
		entityId = ByteBufUtils.readVarInt(buf, 4);
		attackEntity = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
		ByteBufUtils.writeVarInt(buf, hand.ordinal(), 1);
		ByteBufUtils.writeVarInt(buf, entityId, 4);
		buf.writeBoolean(attackEntity);
	}

	@Override
	public void handleClientSide(PacketShieldBash message, EntityPlayer player) 
	{
	}

	@Override
	public void handleServerSide(PacketShieldBash message, EntityPlayerMP player) 
	{
		EnumHand shieldHand;
		int entId;
		boolean attackEntity = false;
		Entity victim;
		
		if(message == null || player == null)
			return;
		
		shieldHand = message.hand;
		entId = message.entityId;
		attackEntity = message.attackEntity;
		victim = player.world.getEntityByID(entId);
		
		if(/*player.isSneaking()*/ player.isActiveItemStackBlocking())
		{
			ItemStack shield = player.getHeldItem(shieldHand);
			
			if(!shield.isEmpty() && !player.getCooldownTracker().hasCooldown(shield.getItem()) && shield.getItem() instanceof ItemShieldBase)
			{
				if(attackEntity && victim != null && victim instanceof EntityLivingBase)
				{
					//player.attackTargetEntityWithCurrentItem(victim);
					int knockLvl = EnchantmentHelper.getEnchantmentLevel(Enchantments.KNOCKBACK, shield);
					victim.hurtResistantTime = 0;
					((EntityLivingBase)victim).knockBack(player, 1.0f + (knockLvl), (double)MathHelper.sin(player.rotationYaw * 0.017453292F), (double)(-MathHelper.cos(player.rotationYaw * 0.017453292F)));
					victim.attackEntityFrom(DamageSource.causePlayerDamage(player), 1.0f);									// Do marginal damage
					shield.damageItem(5, player);
					player.world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ITEM_SHIELD_BLOCK, player.getSoundCategory(), 1.0F, 1.0F);
					player.onCriticalHit(victim);
				}
				else
				{
					player.world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_PLAYER_ATTACK_SWEEP, player.getSoundCategory(), 0.5f, 0.01f);
				}
				player.stopActiveHand();
				player.swingArm(shieldHand);
				player.getCooldownTracker().setCooldown(shield.getItem(), ConfigHandler.cooldownShieldBash);
			}
		}
	}

}
