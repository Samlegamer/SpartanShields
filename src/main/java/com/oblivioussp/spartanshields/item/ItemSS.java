package com.oblivioussp.spartanshields.item;

import com.oblivioussp.spartanshields.client.gui.CreativeTabsSS;
import com.oblivioussp.spartanshields.util.StringHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSS extends Item
{
	public ItemSS(String unlocName)
	{
		super();
		this.setCreativeTab(CreativeTabsSS.TAB_SS);
		this.setRegistryName(unlocName);
		this.setUnlocalizedName(unlocName);
	}
	
	/*@Override
	public String getUnlocalizedName()
	{
		return StringHelper.getItemUnlocalizedName(super.getUnlocalizedName());
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return StringHelper.getItemUnlocalizedName(super.getUnlocalizedName());
	}*/
}
