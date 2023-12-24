package com.oblivioussp.spartanshields.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Optional;
import thaumcraft.api.items.IWarpingGear;

@Optional.Interface(iface = "thaumcraft.api.items.IWarpingGear", modid = "thaumcraft")
public class ItemShieldVoid extends ItemShieldExtraMod implements IWarpingGear
{

	public ItemShieldVoid(String unlocName, int maxDamage, ToolMaterial toolMaterial, String materialOreDictName,
			String externalModName) 
	{
		super(unlocName, maxDamage, toolMaterial, materialOreDictName, externalModName);
	}

	@Override
	public int getWarp(ItemStack itemstack, EntityPlayer player) 
	{
		return 2;
	}

}
