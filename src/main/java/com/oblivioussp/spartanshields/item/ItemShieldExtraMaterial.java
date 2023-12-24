package com.oblivioussp.spartanshields.item;

import java.util.List;

import javax.annotation.Nullable;

import com.oblivioussp.spartanshields.util.ConfigHandler;
import com.oblivioussp.spartanshields.util.ModHelper;
import com.oblivioussp.spartanshields.util.Reference;
import com.oblivioussp.spartanshields.util.StringHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ItemShieldExtraMaterial extends ItemShieldBasic
{
	protected String matOreDict;
	protected boolean doCraftCheck = true;
	protected boolean canBeCrafted = true;
	
	public ItemShieldExtraMaterial(String unlocName, int maxDamage, ToolMaterial toolMaterial, String materialOreDictName) 
	{
		super(unlocName, maxDamage, toolMaterial);
		matOreDict = materialOreDictName;
	}
	
	/*public void setMaterialValid()
	{
		materialValid = true;
	}*/

	// Need to call this function during the post-init phase
	// Calling it pre-init will cause any oreDictionary entries created after
	// this mod's pre-init phase to not be taken into account.
	/*public void checkMaterialValid()
	{
		materialValid = ModHelper.isMaterialValid(matOreDict);
	}*/
	
	/**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
    	//tooltip.add(TextFormatting.RED + StringHelper.getLocalizedString("wip", "tooltip"));
    	if(doCraftCheck && worldIn != null)
    	{
		    List<ItemStack> ores = OreDictionary.getOres(this.matOreDict, false);
		    if(ores == null || ores.isEmpty())
		    	canBeCrafted = false;
    	}
    	
    	if(!ConfigHandler.forceDisableUncraftableTooltips && !canBeCrafted)
    	{
    		tooltip.add(TextFormatting.RED + StringHelper.translateFormattedString("cantCraftMissingMaterial", "tooltip", Reference.ModID, StringHelper.translateString(matOreDict, "item")));
        }
    	
    	//if(!materialValid && worldIn != null && !ConfigHandler.forceDisableUncraftableTooltips)
    	//	tooltip.add(TextFormatting.RED + StringHelper.translateFormattedString("cantCraftMissingMaterial", "tooltip", StringHelper.translateString(matOreDict, "item")));
    	
    	//tooltip.add(StringHelper.translateFormattedString("protection", "tooltip", this.getMaxDamage()));
    	super.addInformation(stack, worldIn, tooltip, flagIn);
    }
    
    /**
     * Return whether this item is repairable in an anvil.
     */
    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
    	return OreDictionary.containsMatch(false, OreDictionary.getOres(matOreDict), repair);
    }
	
}
