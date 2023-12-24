package com.oblivioussp.spartanshields.init;

import com.oblivioussp.spartanshields.enchantment.EnchantmentSS;
import com.oblivioussp.spartanshields.enchantment.EnchantmentSpikes;
import com.oblivioussp.spartanshields.util.ConfigHandler;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class EnchantmentRegistry 
{
	public static EnchantmentSS enchSpikes = new EnchantmentSpikes(Rarity.UNCOMMON, EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND);
	//public static EnchantmentSS enchDeflect = new EnchantmentDeflect(Rarity.VERY_RARE, EntityEquipmentSlot.MAINHAND, EntityEquipmentSlot.OFFHAND);
	
	/*public static void register()
	{
		GameRegistry.register(enchSpikes);
		//GameRegistry.register(enchDeflect);
	}*/
	
	@SubscribeEvent
	public static void register(RegistryEvent.Register<Enchantment> ev)
	{
		IForgeRegistry<Enchantment> reg = ev.getRegistry();
		
		if(ConfigHandler.enableSpikesEnchantment)	reg.register(enchSpikes);
		//GameRegistry.register(enchDeflect);
	}
}
