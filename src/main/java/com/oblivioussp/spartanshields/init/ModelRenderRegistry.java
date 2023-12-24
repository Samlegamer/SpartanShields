package com.oblivioussp.spartanshields.init;

import com.oblivioussp.spartanshields.util.LogHelper;
import com.oblivioussp.spartanshields.util.StringHelper;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ModelRenderRegistry 
{
	
	@SubscribeEvent
	public static void registerItemRenders(ModelRegistryEvent ev)
	{
		registerItemRender(ItemRegistrySS.shieldWood);
		registerItemRender(ItemRegistrySS.shieldStone);
		registerItemRender(ItemRegistrySS.shieldIron);
		registerItemRender(ItemRegistrySS.shieldGold);
		registerItemRender(ItemRegistrySS.shieldDiamond);

		registerItemRender(ItemRegistrySS.shieldBronze);
		registerItemRender(ItemRegistrySS.shieldSteel);
		registerItemRender(ItemRegistrySS.shieldCopper);
		registerItemRender(ItemRegistrySS.shieldTin);
		registerItemRender(ItemRegistrySS.shieldSilver);
		registerItemRender(ItemRegistrySS.shieldObsidian);
		
		registerItemRender(ItemRegistrySS.shieldEnderium);
		registerItemRender(ItemRegistrySS.shieldInvar);
		registerItemRender(ItemRegistrySS.shieldPlatinum);
		registerItemRender(ItemRegistrySS.shieldElectrum);
		registerItemRender(ItemRegistrySS.shieldNickel);
		registerItemRender(ItemRegistrySS.shieldLead);
		registerItemRender(ItemRegistrySS.shieldSignalum);
		registerItemRender(ItemRegistrySS.shieldLumium);
		
		registerItemRender(ItemRegistrySS.shieldManasteel);
		registerItemRender(ItemRegistrySS.shieldTerrasteel);
		registerItemRender(ItemRegistrySS.shieldElementium);
		
		registerItemRender(ItemRegistrySS.shieldConstantan);
		
		registerItemRender(ItemRegistrySS.shieldDarkstone);
		registerItemRender(ItemRegistrySS.shieldAbyssalnite);
		registerItemRender(ItemRegistrySS.shieldCoralium);
		registerItemRender(ItemRegistrySS.shieldDreadium);
		registerItemRender(ItemRegistrySS.shieldEthaxium);
		
		registerItemRender(ItemRegistrySS.shieldSoulforgedSteel);
		
		registerItemRender(ItemRegistrySS.shieldThaumium);
		registerItemRender(ItemRegistrySS.shieldVoid);
		
		registerItemRender(ItemRegistrySS.shieldFEEnderIO);
		registerItemRender(ItemRegistrySS.shieldFERFTools);
		registerItemRender(ItemRegistrySS.shieldFERedstoneArsenal);
		
		registerItemRender(ItemRegistrySS.shieldTowerWood);
		registerItemRender(ItemRegistrySS.shieldTowerStone);
		registerItemRender(ItemRegistrySS.shieldTowerIron);
		registerItemRender(ItemRegistrySS.shieldTowerGold);
		registerItemRender(ItemRegistrySS.shieldTowerDiamond);
		registerItemRender(ItemRegistrySS.shieldTowerObsidian);

		registerItemRender(ItemRegistrySS.shieldTowerBronze);
		registerItemRender(ItemRegistrySS.shieldTowerSteel);
		registerItemRender(ItemRegistrySS.shieldTowerCopper);
		registerItemRender(ItemRegistrySS.shieldTowerTin);
		registerItemRender(ItemRegistrySS.shieldTowerSilver);
		registerItemRender(ItemRegistrySS.shieldTowerInvar);
		registerItemRender(ItemRegistrySS.shieldTowerPlatinum);
		registerItemRender(ItemRegistrySS.shieldTowerElectrum);
		registerItemRender(ItemRegistrySS.shieldTowerNickel);
		registerItemRender(ItemRegistrySS.shieldTowerLead);
		registerItemRender(ItemRegistrySS.shieldTowerConstantan);
		
		LogHelper.info("Registered all item renders!");
	}
	
	@SubscribeEvent
	public static void registerBlockRenders(ModelRegistryEvent ev) 
	{
		// This space intentionally left blank; there are no blocks in this mod!
		LogHelper.info("Registered all block renders!");
	}

	public static void registerItemRender(Item item)
	{
		if(item == null)	return;

		LogHelper.debug("Registering model of item: " + StringHelper.stripUnlocalizedName(item.getUnlocalizedName()));
		ModelResourceLocation modelLoc = new ModelResourceLocation(StringHelper.stripUnlocalizedName(item.getUnlocalizedName()), "inventory");
		ModelLoader.setCustomModelResourceLocation(item, 0, modelLoc);
	}
	
	/**
	 * Registers an item variant using the model file at "[modName]:[itemUnlocName]_[variant]"
	 * @param item
	 * @param variant
	 */
	/*public static void registerItemRenderVariant(Item item, String variant)
	{
		ModelLoader.registerItemVariants(item, new ModelResourceLocation(StringHelper.stripUnlocalizedName(item.getUnlocalizedName()) + "_" + variant, "inventory"));
	}*/
}
