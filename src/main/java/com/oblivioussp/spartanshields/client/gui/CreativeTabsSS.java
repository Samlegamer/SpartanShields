package com.oblivioussp.spartanshields.client.gui;

import com.oblivioussp.spartanshields.init.ItemRegistrySS;
import com.oblivioussp.spartanshields.util.ConfigHandler;
import com.oblivioussp.spartanshields.util.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabsSS 
{
	public static final CreativeTabs TAB_SS = new CreativeTabs(Reference.ModID + ":tabBasic.name")
		{
			@Override
			public ItemStack getIconItemStack()
			{
				// FIX: Change creative tab icon if user has disabled the Stone Shield
				//if(!ConfigHandler.enableStoneShield)
				//	return new ItemStack(ItemRegistrySS.shieldWood);
				if(!ConfigHandler.disableStandardShields)
					return new ItemStack(ItemRegistrySS.shieldStone);
				else if(!ConfigHandler.disableTowerShields)
					return new ItemStack(ItemRegistrySS.shieldTowerStone);
				else
					return new ItemStack(Items.SHIELD);
			}

			@Override
			public ItemStack getTabIconItem() 
			{
				// FIX: Change creative tab icon if user has disabled the Stone Shield
				//if(!ConfigHandler.enableStoneShield)
				//	return ItemRegistrySS.shieldWood;
				
				return getIconItemStack();
			}
		};
}
