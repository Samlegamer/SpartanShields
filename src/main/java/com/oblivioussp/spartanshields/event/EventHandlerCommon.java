package com.oblivioussp.spartanshields.event;

import com.oblivioussp.spartanshields.enchantment.EnchantmentSS;
import com.oblivioussp.spartanshields.init.ItemRegistrySS;
import com.oblivioussp.spartanshields.item.IDamageShield;
import com.oblivioussp.spartanshields.item.ItemShieldBase;
import com.oblivioussp.spartanshields.util.LogHelper;
import com.oblivioussp.spartanshields.util.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;

@EventBusSubscriber
public class EventHandlerCommon 
{
	protected static int tickCounter = 0;
	
	// Attack Event - Handles damage and enchantment triggering for shields.
	@SubscribeEvent
	public static void attackEvent(LivingAttackEvent ev)
	{
		float damage = ev.getAmount();
		
		if(ev.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)ev.getEntityLiving();
			
			// Fix for taking durability damage with Spikes on non-entity damage sources; only accepts entity-based damage sources
			if(!player.getActiveItemStack().isEmpty() && player.getActiveItemStack().getItem() instanceof ItemShieldBase && ev.getSource().getImmediateSource() != null)
			{
				ItemStack activeStack = player.getActiveItemStack();
				
				// Apply Spikes enchant if possible.
				NBTTagList enchList = activeStack.getEnchantmentTagList();
				
				if(enchList != null)
				{
					for (int i = 0; i < enchList.tagCount(); ++i)
	                {
	                    int j = enchList.getCompoundTagAt(i).getShort("id");
	                    int k = enchList.getCompoundTagAt(i).getShort("lvl");

	                    EnchantmentSS ench;
	                    try
	                    {
	                    	ench = (EnchantmentSS)Enchantment.getEnchantmentByID(j);
	                    }
	                    catch(ClassCastException ex)
	                    {
	                    	ench = null;
	                    }
	                    
	                    if(ench != null)
	                    {
		                    ench.onUserAttacked(player, ev.getSource().getTrueSource(), k);
	                    }
	                }
				}
				
				// Copy of EntityPlayer.damageShield() (Allowing for custom shields to take damage)
				if (damage >= 3.0F && !activeStack.isEmpty() && activeStack.getItem() instanceof IDamageShield)
		        {
					((IDamageShield)activeStack.getItem()).damageShield(activeStack, player, ev.getSource().getImmediateSource(), damage);
		        }
			}
		}
		
		//LogHelper.info("Attack Event Triggered!");
	}
	
	// Event to regenerate the Void Plated Shield
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent ev)
	{
		if(ev.side == Side.SERVER && ev.phase == Phase.END)
		{
			tickCounter++;
			if(tickCounter == 20)
			{
				tickCounter = 0;
				
				for(int i = 0; i < ev.player.inventory.getSizeInventory(); i++)
				{
					ItemStack stack = ev.player.inventory.getStackInSlot(i);
					
					if(!stack.isEmpty() && stack.getItem() == ItemRegistrySS.shieldVoid)
					{
						if(stack.getItemDamage() > 0)
						{
							stack.setItemDamage(stack.getItemDamage() - 1);
						}
					}
				}
			}
		}
	}
}
