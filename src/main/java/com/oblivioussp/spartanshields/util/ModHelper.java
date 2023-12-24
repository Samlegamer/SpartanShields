package com.oblivioussp.spartanshields.util;

import java.util.List;

import javax.tools.Tool;

import com.oblivioussp.spartanshields.init.ItemRegistrySS;
import com.oblivioussp.spartanshields.item.ItemShieldExtraMaterial;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;

public class ModHelper 
{
	//protected static boolean installedEnderIO = false;
	
	// Tool Materials
	public static ToolMaterial materialBronze = EnumHelper.addToolMaterial("ssBronze", 2, 320, 5.75f, 2.0f, 12);
	public static ToolMaterial materialSteel = EnumHelper.addToolMaterial("ssSteel", 2, 480, 6.5f, 2.5f, 14);
	public static ToolMaterial materialCopper = EnumHelper.addToolMaterial("ssCopper", 1, 200, 5.0f, 1.5f, 8);
	public static ToolMaterial materialTin = EnumHelper.addToolMaterial("ssTin", 1, 180, 5.25f, 1.75f, 6);
	public static ToolMaterial materialSilver = EnumHelper.addToolMaterial("ssSilver", 1, 48, 5.0f, 1.5f, 16);
	public static ToolMaterial materialObsidian = EnumHelper.addToolMaterial("ssObsidian", 3, 1024, 5.0f, 1.5f, 5);
	
	public static ToolMaterial materialEnderium = EnumHelper.addToolMaterial("ssEnderium", 4, 2048, 7.5f, 8.0f, 18);
	public static ToolMaterial materialInvar = EnumHelper.addToolMaterial("ssInvar", 2, 440, 6.0f, 2.2f, 12);
	public static ToolMaterial materialPlatinum = EnumHelper.addToolMaterial("ssPlatinum", 3, 1024, 4.0f, 4.0f, 18);
	public static ToolMaterial materialElectrum = EnumHelper.addToolMaterial("ssElectrum", 1, 180, 3.5f, 6.0f, 8);
	public static ToolMaterial materialNickel = EnumHelper.addToolMaterial("ssNickel", 1, 200, 4.5f, 2.0f, 6);
	public static ToolMaterial materialLead = EnumHelper.addToolMaterial("ssLead", 1, 240, 4.5f, 2.0f, 5);
	public static ToolMaterial materialSignalum = EnumHelper.addToolMaterial("ssSignalum", 3, 1536, 6.0f, 5.0f, 14);
	public static ToolMaterial materialLumium = EnumHelper.addToolMaterial("ssLumium", 1, 840, 5.0f, 4.0f, 16);
	
	public static ToolMaterial materialManasteel = EnumHelper.addToolMaterial("ssManasteel", 3, 300, 6.0f, 2.0f, 20);
	public static ToolMaterial materialTerrasteel = EnumHelper.addToolMaterial("ssTerrasteel", 3, 2300, 8.0f, 3.0f, 26);
	public static ToolMaterial materialElementium = EnumHelper.addToolMaterial("ssElementium", 3, 720, 6.0f, 2.0f, 20);
	
	public static ToolMaterial materialConstantan = EnumHelper.addToolMaterial("ssConstantan", 2, 640, 5.5f, 3.0f, 7);
	
	public static ToolMaterial materialDarkstone = EnumHelper.addToolMaterial("ssDarkstone", 1, 160, 4.0f, 1.0f, 5);
	public static ToolMaterial materialAbyssalnite = EnumHelper.addToolMaterial("ssAbyssalnite", 2, 384, 6.0f, 2.0f, 8);
	public static ToolMaterial materialCoralium = EnumHelper.addToolMaterial("ssCoralium", 3, 512, 7.0f, 2.5f, 10);
	public static ToolMaterial materialDreadium = EnumHelper.addToolMaterial("ssDreadium", 3, 1024, 8.0f, 3.0f, 14);
	public static ToolMaterial materialEthaxium = EnumHelper.addToolMaterial("ssEthaxium", 4, 2048, 12.0f, 4.0f, 22);
	
	public static ToolMaterial materialSoulforgedSteel = EnumHelper.addToolMaterial("ssSoulforgedSteel", 3, 1024, 6.5f, 3.0f, 16);
	
	public static ToolMaterial materialThaumium = EnumHelper.addToolMaterial("ssThaumium", 3, 500, 7F, 2.5f, 22);
	public static ToolMaterial materialVoid = EnumHelper.addToolMaterial("ssVoidmetal", 4, 150, 8F, 3, 10);
	
	
	public static void postInit()
	{
		/*if(Loader.isModLoaded(Reference.EnderIO_ModID))
		{
			installedEnderIO = true;
		}*/

		/*String oreDictBronze = "ingotBronze";
		String oreDictSteel = "ingotSteel";
		
		ItemStack ingotBronze = getMaterial(oreDictBronze);
		ItemStack ingotSteel = getMaterial(oreDictSteel);*/
		
		// TODO: Change these if statements to the method "registerShieldMaterial" as shown below.
		/*if(ingotBronze != null)
		{
			materialBronze = materialBronze.setRepairItem(ingotBronze);
			ItemRegistrySS.shieldBronze.setMaterialValid();
		}
		if(ingotSteel != null)
		{
			materialSteel = materialSteel.setRepairItem(ingotSteel);
			ItemRegistrySS.shieldSteel.setMaterialValid();
		}*/
		
		/*
		registerShieldMaterial("ingotBronze", materialBronze, ItemRegistrySS.shieldBronze);
		registerShieldMaterial("ingotSteel", materialSteel, ItemRegistrySS.shieldSteel);
		
		registerShieldMaterial("ingotCopper", materialCopper, ItemRegistrySS.shieldCopper);
		registerShieldMaterial("ingotTin", materialTin, ItemRegistrySS.shieldTin);
		registerShieldMaterial("ingotSilver", materialSilver, ItemRegistrySS.shieldSilver);
		
		registerShieldMaterial("ingotEnderium", materialEnderium, ItemRegistrySS.shieldEnderium);
		registerShieldMaterial("ingotInvar", materialInvar, ItemRegistrySS.shieldInvar);
		registerShieldMaterial("ingotPlatinum", materialPlatinum, ItemRegistrySS.shieldPlatinum);
		registerShieldMaterial("ingotElectrum", materialElectrum, ItemRegistrySS.shieldElectrum);
		registerShieldMaterial("ingotLead", materialLead, ItemRegistrySS.shieldLead);
		registerShieldMaterial("ingotNickel", materialNickel, ItemRegistrySS.shieldNickel);
		registerShieldMaterial("ingotSignalum", materialSignalum, ItemRegistrySS.shieldSignalum);
		registerShieldMaterial("ingotLumium", materialLumium, ItemRegistrySS.shieldLumium);
		
		registerShieldMaterial("ingotConstantan", materialConstantan, ItemRegistrySS.shieldConstantan);
		*/
		
		// Soulforged Steel
		ItemStack soulSteelStack = getMaterial("ingotSoulforgedSteel");
		if(!soulSteelStack.isEmpty())
			materialSoulforgedSteel.setRepairItem(soulSteelStack);
		
		ItemStack thaumiumStack = getMaterial("ingotThaumium");
		if(!thaumiumStack.isEmpty())
			materialThaumium.setRepairItem(thaumiumStack);
		
		ItemStack voidStack = getMaterial("ingotVoid");
		if(!voidStack.isEmpty())
			materialVoid.setRepairItem(voidStack);
	}
	
	/*public static boolean isEnderIOInstalled()
	{
		return installedEnderIO;
	}*/
	
	/**
	 * Registers the shield as craftable/repairable if the modded material exists in the game
	 * @param oreDict The OreDictionary string to check if the material exists
	 * @param material The internal ToolMaterial that will be used for the shield
	 * @param shield The shield Item instance itself
	 * @return The tool material put in and adjusted to ensure it can repair the shield properly
	 */
	/*private static ToolMaterial registerShieldMaterial(String oreDict, ToolMaterial material, ItemShieldExtraMaterial shield)
	{
		ItemStack oreDictStack = getMaterial(oreDict);
		ToolMaterial toolMat = material;
		
		if(oreDictStack != Reference.STACK_NULL)
		{
			toolMat = material.setRepairItem(oreDictStack);
			shield.setMaterialValid();
		}
		
		return toolMat;
	}*/
	
	public static boolean isMaterialValid(String oreDict)
	{
		if(OreDictionary.doesOreNameExist(oreDict))
		{
			List<ItemStack> stacks = OreDictionary.getOres(oreDict);
			if(!stacks.isEmpty())
				if(!stacks.get(0).isEmpty())
					return true;
		}
		return false;
	}
	
	public static ItemStack getMaterial(String oreDict)
	{
		if(OreDictionary.doesOreNameExist(oreDict))
		{
			List<ItemStack> stacks = OreDictionary.getOres(oreDict);
			if(stacks.size() != 0)
				return stacks.get(0);
		}
		return ItemStack.EMPTY;
	}
}
