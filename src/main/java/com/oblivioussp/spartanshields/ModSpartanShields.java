package com.oblivioussp.spartanshields;

import java.util.List;

import com.oblivioussp.spartanshields.client.gui.CreativeTabsSS;
import com.oblivioussp.spartanshields.enchantment.EnchantmentSS;
import com.oblivioussp.spartanshields.event.EventHandlerCommon;
import com.oblivioussp.spartanshields.init.EnchantmentRegistry;
import com.oblivioussp.spartanshields.init.ItemRegistrySS;
import com.oblivioussp.spartanshields.init.RecipeRegistry;
import com.oblivioussp.spartanshields.network.NetworkHandler;
import com.oblivioussp.spartanshields.proxy.CommonProxy;
import com.oblivioussp.spartanshields.util.ConfigHandler;
import com.oblivioussp.spartanshields.util.LogHelper;
import com.oblivioussp.spartanshields.util.MappingConverterEntry;
import com.oblivioussp.spartanshields.util.ModHelper;
import com.oblivioussp.spartanshields.util.Reference;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.ModID, name = Reference.ModName, version = Reference.ModVersion, dependencies = Reference.ModDependencies, acceptedMinecraftVersions = Reference.McVersion, guiFactory = Reference.GuiFactoryClass)
public class ModSpartanShields 
{

	@Instance(Reference.ModID)
	public static ModSpartanShields instance;
	
	@SidedProxy(clientSide = Reference.ProxyClientClass, serverSide = Reference.ProxyServerClass)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent ev)
	{
		/* Register the following here:
		 * - Config File
		 * - Event Bus registration
		 * - Keybindings
		 * - Network Handling
		 * - Block & Item Registration
		 */
		
		LogHelper.info("Starting up Spartan Shields!");
		
		// Initialise Config
		ConfigHandler.init(ev.getSuggestedConfigurationFile());
		//MinecraftForge.EVENT_BUS.register(new ConfigHandler());
		
		// Initialise other events
		//MinecraftForge.EVENT_BUS.register(new EventHandlerCommon());
		
		//MinecraftForge.EVENT_BUS.register(new ItemRegistrySS());
		//MinecraftForge.EVENT_BUS.register(new EnchantmentRegistry());
		
		//ItemRegistrySS.registerItems();

		proxy.preInit(ev);
		LogHelper.debug("Finished preInit phase!");
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent ev)
	{
		/* Register the following here:
		 * - Entities
		 * - Recipes
		 */
		//RecipeRegistry.addRecipes();
		
		NetworkHandler.init();
		CreativeTabsSS.TAB_SS.setRelevantEnchantmentTypes(EnchantmentSS.TYPE_SHIELD);
		
		//LogHelper.info("Registering enchantments...");
		//EnchantmentRegistry.register();

		proxy.init(ev);
		LogHelper.debug("Finished init phase!");
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent ev)
	{
		/* Register the following here:
		 * - Anything that requires other mods to be initialised first.
		 */
		
		ModHelper.postInit();
		
		RecipeRegistry.addCompatRecipes();
		
		//EnumHelper.addEnchantmentType(name)
		
		/*LogHelper.info("OreDict Names detected:");
		String[] oreNames = OreDictionary.getOreNames();
		
		for(String name : oreNames)
		{
			LogHelper.info(name);
		}*/

		proxy.postInit(ev);
		LogHelper.debug("Finished postInit phase!");
	}
	
	/*
	// MissingMappingsEvent 
	// Converting old shield names to new ones.
	@EventHandler
	public void missingMappingsEvent(FMLMissingMappingsEvent ev)
	{
		List<MissingMapping> mappings = ev.get();
		
		for(MissingMapping mapping : mappings)
		{
			LogHelper.info(String.format("Missing Mapping: %s - %s - %s", mapping.name, mapping.resourceLocation.toString(), mapping.type.toString()));
			//mapping.fail();
			//boolean converted = false;
			for(MappingConverterEntry entry : Reference.mappings)
			{
				if(mapping.name.equalsIgnoreCase(entry.getMappingName()))
				{
					mapping.remap(entry.getItemToConvertTo());
					LogHelper.info(String.format("Mapping: %s successfully converted to item %s", mapping.name, entry.getItemToConvertTo().getRegistryName()));
					//converted = true;
				}
			}
		}
	}*/
}
