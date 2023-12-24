package com.oblivioussp.spartanshields.init;

import com.oblivioussp.spartanshields.item.ItemShieldExtraMaterial;
import com.oblivioussp.spartanshields.item.crafting.RecipeShieldBanners;
import com.oblivioussp.spartanshields.util.ConfigHandler;
import com.oblivioussp.spartanshields.util.LogHelper;
import com.oblivioussp.spartanshields.util.Reference;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class RecipeRegistry 
{
	@SubscribeEvent
	public static void addRecipes(RegistryEvent.Register<IRecipe> ev)
	{
		IForgeRegistry<IRecipe> reg = ev.getRegistry();
		
		// Wood Shield (compatible with all OreDict-registered planks)
		/*addRecipe(reg, "spartanshields:shield_wood_1", ItemRegistrySS.shieldWood, " pp", "psp", "pp ", 'p', "plankWood", 's', "stickWood");
		addRecipe(reg, "spartanshields:shield_wood_2", ItemRegistrySS.shieldWood, "pp ", "psp", " pp", 'p', "plankWood", 's', "stickWood");

		// Stone Shield (compatible with all OreDict-registered cobblestone)
		//if(ConfigHandler.enableStoneShield)
		addRecipe(reg, "spartanshields:shield_stone", ItemRegistrySS.shieldStone, " c ", "csc", " c ", 'c', "cobblestone", 's', ItemRegistrySS.shieldWood);
	
		// Iron Shield (compatible with all OreDict-registered iron)
		//if(ConfigHandler.enableIronShield)
		addRecipe(reg, "spartanshields:shield_iron", ItemRegistrySS.shieldIron, " i ", "isi", " i ", 'i', "ingotIron", 's', ItemRegistrySS.shieldWood);

		// Gold Shield (compatible with all OreDict-registered gold)
		//if(ConfigHandler.enableGoldShield)
		addRecipe(reg, "spartanshields:shield_gold", ItemRegistrySS.shieldGold, " i ", "isi", " i ", 'i', "ingotGold", 's', ItemRegistrySS.shieldWood);

		// Diamond Shield (compatible with all OreDict-registered diamond)
		//if(ConfigHandler.enableDiamondShield)
		addRecipe(reg, "spartanshields:shield_diamond", ItemRegistrySS.shieldDiamond, " g ", "gsg", " g ", 'g', "gemDiamond", 's', ItemRegistrySS.shieldWood);
			
		if(ConfigHandler.enableObsidianShield)
			addRecipe(reg, "spartanshields:shield_obsidian", ItemRegistrySS.shieldObsidian, " o ", "oso", " o ", 'o', Blocks.OBSIDIAN, 's', ItemRegistrySS.shieldWood);
		*/
		/*if(!ConfigHandler.vanillaOnly)
		{
			// v1.1 standard recipes
			if(!addShieldRecipeIfValid(reg, "spartanshields:shield_bronze", ItemRegistrySS.shieldBronze, "ingotBronze", ConfigHandler.enableBronzeShield))			// Bronze Shield
				LogHelper.info("Can't add recipe for Bronze Plated Shield; No valid Bronze Ingot found...");
			if(!addShieldRecipeIfValid(reg, "spartanshields:shield_steel", ItemRegistrySS.shieldSteel, "ingotSteel", ConfigHandler.enableSteelShield))				// Steel Shield
				LogHelper.info("Can't add recipe for Steel Plated Shield; No valid Steel Ingot found...");
			
			// v1.2 standard recipes
			if(!addShieldRecipeIfValid(reg, "spartanshields:shield_copper", ItemRegistrySS.shieldCopper, "ingotCopper", ConfigHandler.enableCopperShield))			// Copper Shield
				LogHelper.info("Can't add recipe for Copper Braced Shield; No valid Copper Ingot found...");
			if(!addShieldRecipeIfValid(reg, "spartanshields:shield_tin", ItemRegistrySS.shieldTin, "ingotTin", ConfigHandler.enableTinShield))						// Tin Shield
				LogHelper.info("Can't add recipe for Tin Braced Shield; No valid Tin Ingot found...");
			if(!addShieldRecipeIfValid(reg, "spartanshields:shield_silver", ItemRegistrySS.shieldSilver, "ingotSilver", ConfigHandler.enableSilverShield))			// Silver Shield
				LogHelper.info("Can't add recipe for Silver Gilded Shield; No valid Silver Ingot found...");

			// v1.3 standard recipes
			if(!addShieldRecipeIfValid(reg, "spartanshields:shield_enderium", ItemRegistrySS.shieldEnderium, "ingotEnderium", ConfigHandler.enableEnderiumShield))		// Enderium Shield
				LogHelper.info("Can't add recipe for Enderium Reinforced Shield; No valid Enderium Ingot found...");
			if(!addShieldRecipeIfValid(reg, "spartanshields:shield_invar", ItemRegistrySS.shieldInvar, "ingotInvar", ConfigHandler.enableInvarShield))				// Invar Shield
				LogHelper.info("Can't add recipe for Invar Plated Shield; No valid Invar Ingot found...");
			if(!addShieldRecipeIfValid(reg, "spartanshields:shield_platinum", ItemRegistrySS.shieldPlatinum, "ingotPlatinum", ConfigHandler.enablePlatinumShield))		// Platinum Shield
				LogHelper.info("Can't add recipe for Platinum Plated Shield; No valid Platinum Ingot found...");
			if(!addShieldRecipeIfValid(reg, "spartanshields:shield_electrum", ItemRegistrySS.shieldElectrum, "ingotElectrum", ConfigHandler.enableElectrumShield))		// Electrum Shield
				LogHelper.info("Can't add recipe for Electrum Plated Shield; No valid Electrum Ingot found...");
			if(!addShieldRecipeIfValid(reg, "spartanshields:shield_nickel", ItemRegistrySS.shieldNickel, "ingotNickel", ConfigHandler.enableNickelShield))			// Nickel Shield
				LogHelper.info("Can't add recipe for Nickel Braced Shield; No valid Nickel Ingot found...");
			if(!addShieldRecipeIfValid(reg, "spartanshields:shield_lead", ItemRegistrySS.shieldLead, "ingotLead", ConfigHandler.enableLeadShield))					// Lead Shield
				LogHelper.info("Can't add recipe for Lead Plated Shield; No valid Lead Ingot found...");
			if(!addShieldRecipeIfValid(reg, "spartanshields:shield_signalum", ItemRegistrySS.shieldSignalum, "ingotSignalum", ConfigHandler.enableSignalumShield))		// Signalum Shield
				LogHelper.info("Can't add recipe for Signalum Strengthened Shield; No valid Signalum Ingot found...");
			if(!addShieldRecipeIfValid(reg, "spartanshields:shield_lumium", ItemRegistrySS.shieldLumium, "ingotLumium", ConfigHandler.enableLumiumShield))			// Lumium Shield
				LogHelper.info("Can't add recipe for Radiant Lumium Shield; No valid Lumium Ingot found...");
			
			// Infused Riot Shield (v1.2)
			if(Loader.isModLoaded(Reference.RFTools_ModID) && ConfigHandler.enableRFToolsShield)
			{
				ItemStack machineFrame = GameRegistry.makeItemStack("rftools:machine_base", 0, 1, null);
				ItemStack shieldProjector = GameRegistry.makeItemStack("rftools:shield_block1", 0, 1, null);
				ItemStack powerCell = GameRegistry.makeItemStack("rftools:powercell", 0, 1, null);
				ItemStack diamondInfused = GameRegistry.makeItemStack("rftools:infused_diamond", 0, 1, null);
				ItemStack shieldTemplate = GameRegistry.makeItemStack("rftools:shield_template_block", 0, 1, null);
				
				if(machineFrame != Reference.STACK_NULL && shieldProjector != Reference.STACK_NULL && powerCell != Reference.STACK_NULL && diamondInfused != Reference.STACK_NULL && shieldTemplate != Reference.STACK_NULL)
				{
					LogHelper.info("RFTools detected! Adding recipe to Infused Riot Shield!");
					addRecipe(reg, "spartanshields:shield_powered_rftools", new ItemStack(ItemRegistrySS.shieldFERFTools), "sbs", "dpd", "scs", 's', shieldTemplate, 'd', diamondInfused, 'b', machineFrame, 'p', shieldProjector, 'c', powerCell);
					//LogHelper.info("Added Infused Riot Shield recipe successfully!");
				}
			}

			// Redstone Arsenal (v1.3)
			if(Loader.isModLoaded(Reference.RedstoneArsenal_ModID) && ConfigHandler.enableRAShield)
			{
				ItemStack obStick = GameRegistry.makeItemStack("redstonearsenal:material", 192, 1, null);
				ItemStack fluxPlate = GameRegistry.makeItemStack("redstonearsenal:material", 224, 1, null);
				
				if(obStick != null && fluxPlate != null)
				{
					LogHelper.info("Redstone Arsenal detected! Adding Flux-Infused Shield Recipe!");
					addRecipe(reg, "spartanshields:shield_powered_ra", new ItemStack(ItemRegistrySS.shieldFERedstoneArsenal), " p ", "psp", " p ", 'p', fluxPlate, 's', obStick);
				}
			}
		}*/
		
		reg.register(new RecipeShieldBanners(ItemRegistrySS.shieldTowerWood).setRegistryName(new ResourceLocation(Reference.ModID, "shield_banner_wood")));
		reg.register(new RecipeShieldBanners(ItemRegistrySS.shieldTowerStone).setRegistryName(new ResourceLocation(Reference.ModID, "shield_banner_stone")));
		reg.register(new RecipeShieldBanners(ItemRegistrySS.shieldTowerIron).setRegistryName(new ResourceLocation(Reference.ModID, "shield_banner_iron")));
		reg.register(new RecipeShieldBanners(ItemRegistrySS.shieldTowerGold).setRegistryName(new ResourceLocation(Reference.ModID, "shield_banner_gold")));
		reg.register(new RecipeShieldBanners(ItemRegistrySS.shieldTowerDiamond).setRegistryName(new ResourceLocation(Reference.ModID, "shield_banner_diamond")));
		reg.register(new RecipeShieldBanners(ItemRegistrySS.shieldTowerObsidian).setRegistryName(new ResourceLocation(Reference.ModID, "shield_banner_obsidian")));
		
		reg.register(new RecipeShieldBanners(ItemRegistrySS.shieldTowerBronze).setRegistryName(new ResourceLocation(Reference.ModID, "shield_banner_bronze")));
		reg.register(new RecipeShieldBanners(ItemRegistrySS.shieldTowerSteel).setRegistryName(new ResourceLocation(Reference.ModID, "shield_banner_steel")));
		reg.register(new RecipeShieldBanners(ItemRegistrySS.shieldTowerCopper).setRegistryName(new ResourceLocation(Reference.ModID, "shield_banner_copper")));
		reg.register(new RecipeShieldBanners(ItemRegistrySS.shieldTowerTin).setRegistryName(new ResourceLocation(Reference.ModID, "shield_banner_tin")));
		reg.register(new RecipeShieldBanners(ItemRegistrySS.shieldTowerSilver).setRegistryName(new ResourceLocation(Reference.ModID, "shield_banner_silver")));
		reg.register(new RecipeShieldBanners(ItemRegistrySS.shieldTowerInvar).setRegistryName(new ResourceLocation(Reference.ModID, "shield_banner_invar")));
		reg.register(new RecipeShieldBanners(ItemRegistrySS.shieldTowerPlatinum).setRegistryName(new ResourceLocation(Reference.ModID, "shield_banner_platinum")));
		reg.register(new RecipeShieldBanners(ItemRegistrySS.shieldTowerElectrum).setRegistryName(new ResourceLocation(Reference.ModID, "shield_banner_electrum")));
		reg.register(new RecipeShieldBanners(ItemRegistrySS.shieldTowerNickel).setRegistryName(new ResourceLocation(Reference.ModID, "shield_banner_nickel")));
		reg.register(new RecipeShieldBanners(ItemRegistrySS.shieldTowerLead).setRegistryName(new ResourceLocation(Reference.ModID, "shield_banner_lead")));
		reg.register(new RecipeShieldBanners(ItemRegistrySS.shieldTowerConstantan).setRegistryName(new ResourceLocation(Reference.ModID, "shield_banner_constantan")));
		
		LogHelper.info("Recipes added!");
	}
	
	// Compatibility Recipes
	// Ender IO = 6 Dark Steel + 1 Ender Crystal + 1 Pulsating Crystal + 1 Octadic Capacitor = Riot Shield
	// Dark Steel = enderio:itemAlloy:6
	// Ender Crystal = enderio:itemMaterial:8
	// Pulsating Crystal = enderio:itemMaterial:5
	// Octadic Capacitor = enderio:itemBasicCapacitor:2
	
	public static void addCompatRecipes()
	{
		// Disable modded recipes if in Vanilla only mode.
		if(ConfigHandler.vanillaOnly)
			return;
		
		// Fluxed Riot Shield (v1.1)
/*		if(Loader.isModLoaded(Reference.EnderIO_ModID) && ConfigHandler.enableEnderIOShield)
		{
			ItemStack darkSteel = GameRegistry.makeItemStack("enderio:itemAlloy", 6, 1, null);
			ItemStack crystalEnder = GameRegistry.makeItemStack("enderio:itemMaterial", 8, 1, null);
			ItemStack crystalPulsating = GameRegistry.makeItemStack("enderio:itemMaterial", 5, 1, null);
			ItemStack capacitorOcto = GameRegistry.makeItemStack("enderio:itemBasicCapacitor", 2, 1, null);
			
			if(darkSteel != Reference.STACK_NULL && crystalEnder != Reference.STACK_NULL && crystalPulsating != Reference.STACK_NULL && capacitorOcto != Reference.STACK_NULL)
			{
				LogHelper.info("Ender IO detected! Adding recipe to Fluxed Riot Shield!");
//				GameRegistry.addShapedRecipe(new ItemStack(ItemRegistrySS.shieldFEEnderIO), "dpd", "dod", "ded", 'd', darkSteel, 'p', crystalPulsating, 'e', crystalEnder, 'o', capacitorOcto);
				//LogHelper.info("Added Fluxed Riot Shield recipe successfully!");
			}
			else
				LogHelper.error("Can't add Fluxed Riot Shield Recipe; An item from Ender IO has either had a name change or the developer didn't get the name right.");
		}
		else
			LogHelper.info("Can't add Fluxed Riot Shield Recipe; EnderIO not installed!");
*/	
		
		// Botania Shields (v1.3)
		/*if(Loader.isModLoaded(Reference.Botania_ModID))
		{
			ItemStack manasteel = GameRegistry.makeItemStack("botania:manaresource", 0, 1, null);
			ItemStack terrasteel = GameRegistry.makeItemStack("botania:manaresource", 4, 1, null);
			ItemStack elementium = GameRegistry.makeItemStack("botania:manaresource", 7, 1, null);
			ItemStack livingwoodTwig = GameRegistry.makeItemStack("botania:manaresource", 3, 1, null);
			ItemStack dreamwoodTwig = GameRegistry.makeItemStack("botania:manaresource", 13, 1, null);
			ItemStack runeEarth = GameRegistry.makeItemStack("botania:rune", 2, 1, null);
			ItemStack runeMana = GameRegistry.makeItemStack("botania:rune", 8, 1, null);
			ItemStack runeSummer = GameRegistry.makeItemStack("botania:rune", 5, 1, null);
			ItemStack runePride = GameRegistry.makeItemStack("botania:rune", 15, 1, null);
			
			if(manasteel != null && terrasteel != null && elementium != null &&
					livingwoodTwig != null && dreamwoodTwig != null &&
					runeEarth != null && runeMana != null && runeSummer != null && runePride != null)
			{
				LogHelper.info("Botania detected! Adding Botania Shield Recipes!");
//				if(ConfigHandler.enableManasteelShield)
//					GameRegistry.addShapedRecipe(new ItemStack(ItemRegistrySS.shieldManasteel), "iri", "iti", " s ", 'i', manasteel,
//						't', livingwoodTwig, 'r', runeEarth, 's', runeMana);		// Manasteel Shield
//				if(ConfigHandler.enableTerrasteelShield)
//					GameRegistry.addShapedRecipe(new ItemStack(ItemRegistrySS.shieldTerrasteel), "iri", "iti", " s ", 'i', terrasteel,
//						't', livingwoodTwig, 'r', runePride, 's', runeMana);		// Terrasteel Shield
//				if(ConfigHandler.enableElementiumShield)
//					GameRegistry.addShapedRecipe(new ItemStack(ItemRegistrySS.shieldElementium), "iri", "iti", " s ", 'i', elementium,
//						't', dreamwoodTwig, 'r', runeSummer, 's', runeMana);		// Elementium Shield
			}
		}*/
	
	}
	
	public static void addRecipe(IForgeRegistry<IRecipe> registry, String recipePath, Item result, Object... input)
	{
		ShapedOreRecipe recipe = new ShapedOreRecipe(new ResourceLocation("recipePath"), result, input);
		recipe.setRegistryName(recipePath);
		registry.register(recipe);
	}
	
	public static void addRecipe(IForgeRegistry<IRecipe> registry, String recipePath, ItemStack result, Object... input)
	{
		ShapedOreRecipe recipe = new ShapedOreRecipe(new ResourceLocation("recipePath"), result, input);
		recipe.setRegistryName(recipePath);
		registry.register(recipe);
	}
	
	public static boolean addShieldRecipeIfValid(IForgeRegistry<IRecipe> registry, String recipePath, ItemShieldExtraMaterial shield, String oreDict, boolean enabledFlag)
	{
		//if(ModHelper.isMaterialValid(oreDict))
		//{
			addRecipe(registry, recipePath, shield, " i ", "isi", " i ", 'i', oreDict, 's', ItemRegistrySS.shieldWood);
//			GameRegistry.addRecipe(new ShapedOreRecipe(shield, " i ", "isi", " i ", 'i', oreDict, 's', ItemRegistrySS.shieldWood));
			return true;
		//}
		//return false;
	}

}
