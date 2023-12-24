package com.oblivioussp.spartanshields.item;

import java.util.List;

import javax.annotation.Nullable;

import com.oblivioussp.spartanshields.util.ConfigHandler;
import com.oblivioussp.spartanshields.util.StringHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemShieldExtraMod extends ItemShieldExtraMaterial 
{
	protected String modName;

	public ItemShieldExtraMod(String unlocName, int maxDamage, ToolMaterial toolMaterial, String materialOreDictName, String externalModName) 
	{
		super(unlocName, maxDamage, toolMaterial, materialOreDictName);
		modName = externalModName;
	}

	/**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
    	//tooltip.add(TextFormatting.RED + StringHelper.getLocalizedString("wip", "tooltip"));
    	
    	if(!Loader.isModLoaded(modName) && !ConfigHandler.forceDisableUncraftableTooltips)
    	{
    		tooltip.add(TextFormatting.RED + StringHelper.translateString("cantCraftMissingMods", "tooltip"));
    		tooltip.add(TextFormatting.RED + StringHelper.translateString(modName, "mod"));
    	}
    	
    	tooltip.add(StringHelper.translateFormattedString("protection", "tooltip", this.getMaxDamage()));
    	tooltip.add("");
    	this.addShieldBashTooltip(stack, worldIn, tooltip, flagIn);
    }
}
