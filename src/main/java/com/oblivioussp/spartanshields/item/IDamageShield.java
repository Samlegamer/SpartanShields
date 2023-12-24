package com.oblivioussp.spartanshields.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface IDamageShield 
{
	public void damageShield(ItemStack shieldStack, EntityPlayer player, Entity attacker, float damage);
}
