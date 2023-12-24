package com.oblivioussp.spartanshields.util;

import java.util.Collections;
import java.util.HashMap;

import com.oblivioussp.spartanshields.init.ItemRegistrySS;

import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class Reference
{
	// Mod information
	public static final String ModID = "spartanshields";
	public static final String ModName = "Spartan Shields";
	public static final String ModVersion = "1.5.5";
	public static final String ModDependencies = "after:redstoneflux;after:enderio;after:rftools;after:botania;after:redstonearsenal;after:abyssalcraft;after:betterwithmods;after:thaumcraft";
	public static final String McVersion = "[1.12.2]";
	public static final String ConfigVersion = "1";
	
	// External Mods
	public static final String RedstoneFlux_ModID = "redstoneflux";
	public static final String EnderIO_ModID = "enderio";
	public static final String RFTools_ModID = "rftools";
	public static final String Botania_ModID = "botania";
	public static final String RedstoneArsenal_ModID = "redstonearsenal";
	public static final String Abyssalcraft_ModID = "abyssalcraft";
	public static final String BWM_ModID = "betterwithmods";
	public static final String Thaumcraft_ModID = "thaumcraft";
	
	// Classes
	public static final String ProxyClientClass = "com.oblivioussp.spartanshields.proxy.ClientProxy";
	public static final String ProxyServerClass = "com.oblivioussp.spartanshields.proxy.ServerProxy";
	public static final String GuiFactoryClass = "com.oblivioussp.spartanshields.client.gui.GuiFactorySS";
	
	// Config options
	public static final int DefaultDurabilityWoodShield = 104;		// B1.0 value: 104
	public static final int DefaultDurabilityStoneShield = 230;		// B1.0 value: 230
	public static final int DefaultDurabilityIronShield = 538;		// B1.0 value: 438
	public static final int DefaultDurabilityGoldShield = 192;		// B1.0 value: 160
	public static final int DefaultDurabilityDiamondShield = 2560;	// B1.0 value: 2732
	
	public static final int DefaultDurabilityBronzeShield = 680;	// New in 1.1
	public static final int DefaultDurabilitySteelShield = 800;

	public static final int DefaultDurabilityCopperShield = 400;	// New in 1.2
	public static final int DefaultDurabilityTinShield = 320;
	public static final int DefaultDurabilitySilverShield = 216;
	public static final int DefaultDurabilityObsidianShield = 1600;
	
	public static final int DefaultDurabilityEnderiumShield = 3120;		// New in 1.3
	public static final int DefaultDurabilityInvarShield = 720;
	public static final int DefaultDurabilityPlatinumShield = 1536;
	public static final int DefaultDurabilityElectrumShield = 320;
	public static final int DefaultDurabilityNickelShield = 420;
	public static final int DefaultDurabilityLeadShield = 480;
	public static final int DefaultDurabilitySignalumShield = 2048;
	public static final int DefaultDurabilityLumiumShield = 1280;
	
	public static final int DefaultDurabilityManasteelShield = 450;
	public static final int DefaultDurabilityTerrasteelShield = 2920;
	public static final int DefaultDurabilityElementiumShield = 1080;
	
	public static final int DefaultDurabilityConstantanShield = 640;	// New in 1.4
	public static final int DefaultDurabilityDarkstoneShield = 270;
	public static final int DefaultDurabilityAbyssalniteShield = 1800;
	public static final int DefaultDurabilityCoraliumShield = 2700;
	public static final int DefaultDurabilityDreadiumShield = 3450;
	public static final int DefaultDurabilityEthaxiumShield = 4200;
	public static final int DefaultDurabilitySoulforgedSteelShield = 1024;
	
	public static final int DefaultDurabilityThaumiumShield = 1024;		// New in 1.5
	public static final int DefaultDurabilityVoidShield = 225;
	
	public static final int DefaultCooldownShieldBash = 30;
	
	public static final int DefaultDamageToRFMultiplier = 50;		// New in 1.1 = How much RF is used to protect from 1 damage point.
	public static final int DefaultDamageToFEMultiplier = 50;		// New in 1.2 = How much Forge Energy is used to protect from 1 damage point.
	
	// UUIDs
	public static final String uuidShieldMoveSpeed = "c0d49eb1-c7be-4509-a6c8-20c7ee186aa3";
	public static final String uuidShieldKnockback = "045b59bd-7746-4be1-8ae2-25b67fdc6b46";
	
	// Old mappings
	/*public static final MappingConverterEntry[] mappings = {new MappingConverterEntry("spartanshields:shieldBasicWood", ItemRegistrySS.shieldWood),
															new MappingConverterEntry("spartanshields:shieldBasicStone", ItemRegistrySS.shieldStone),
															new MappingConverterEntry("spartanshields:shieldBasicIron", ItemRegistrySS.shieldIron),
															new MappingConverterEntry("spartanshields:shieldBasicGold", ItemRegistrySS.shieldGold),
															new MappingConverterEntry("spartanshields:shieldBasicDiamond", ItemRegistrySS.shieldDiamond),
															new MappingConverterEntry("spartanshields:shieldBasicBronze", ItemRegistrySS.shieldBronze),
															new MappingConverterEntry("spartanshields:shieldBasicSteel", ItemRegistrySS.shieldSteel),
															new MappingConverterEntry("spartanshields:shieldRiotRF", ItemRegistrySS.shieldFEEnderIO),
															};*/
	
	// Enchantments
	//public static final EnumEnchantmentType enchTypeShield = EnumHelper.addEnchantmentType("spshield");
}
