package com.oblivioussp.spartanshields.proxy;

import com.oblivioussp.spartanshields.client.model.ModelShieldTower;
import com.oblivioussp.spartanshields.client.model.ModelShieldKite;
import com.oblivioussp.spartanshields.client.render.item.TileEntityItemStackRendererSS;
import com.oblivioussp.spartanshields.init.ItemRegistrySS;

import net.minecraft.client.model.ModelShield;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{

	@Override
	public void preInit(FMLPreInitializationEvent ev) {}

	@Override
	public void init(FMLInitializationEvent ev) 
	{
		registerSimpleItemColourHandler(ItemRegistrySS.shieldFEEnderIO, 0x80FFA0);
		
		setShieldTEISR(ItemRegistrySS.shieldTowerWood, "shield_tower_wood", "S_WOOD", new ModelShield());
		setShieldTEISR(ItemRegistrySS.shieldTowerStone, "shield_tower_stone", "S_STONE", new ModelShield());
		setShieldTEISR(ItemRegistrySS.shieldTowerIron, "shield_tower_iron", "S_IRON", new ModelShieldKite());
		setShieldTEISR(ItemRegistrySS.shieldTowerGold, "shield_tower_gold", "S_GOLD", new ModelShieldTower());
		setShieldTEISR(ItemRegistrySS.shieldTowerDiamond, "shield_tower_diamond", "S_DIAMOND", new ModelShieldKite());
		setShieldTEISR(ItemRegistrySS.shieldTowerObsidian, "shield_tower_obsidian", "S_OBSIDIAN", new ModelShield());
		
		setShieldTEISR(ItemRegistrySS.shieldTowerBronze, "shield_tower_bronze", "S_BRONZE", new ModelShieldKite());
		setShieldTEISR(ItemRegistrySS.shieldTowerSteel, "shield_tower_steel", "S_STEEL", new ModelShieldKite());
		setShieldTEISR(ItemRegistrySS.shieldTowerCopper, "shield_tower_copper", "S_COPPER", new ModelShield());
		setShieldTEISR(ItemRegistrySS.shieldTowerTin, "shield_tower_tin", "S_TIN", new ModelShield());
		setShieldTEISR(ItemRegistrySS.shieldTowerSilver, "shield_tower_silver", "S_SILVER", new ModelShieldTower());
		setShieldTEISR(ItemRegistrySS.shieldTowerInvar, "shield_tower_invar", "S_INVAR", new ModelShieldTower());
		setShieldTEISR(ItemRegistrySS.shieldTowerPlatinum, "shield_tower_platinum", "S_PLATINUM", new ModelShieldKite());
		setShieldTEISR(ItemRegistrySS.shieldTowerElectrum, "shield_tower_electrum", "S_ELECTRUM", new ModelShieldTower());
		setShieldTEISR(ItemRegistrySS.shieldTowerNickel, "shield_tower_nickel", "S_NICKEL", new ModelShield());
		setShieldTEISR(ItemRegistrySS.shieldTowerLead, "shield_tower_lead", "S_LEAD", new ModelShieldKite());
		setShieldTEISR(ItemRegistrySS.shieldTowerConstantan, "shield_tower_constantan", "S_CONSTANTAN", new ModelShieldTower());
	}
	
	private void registerSimpleItemColourHandler(Item item, int colour)
	{
		if(item == null)	return;
		FMLClientHandler.instance().getClient().getItemColors().registerItemColorHandler(new IItemColor()
		{
			@Override
			public int colorMultiplier(ItemStack stack, int tintIndex) 
			{
				return tintIndex == 1 ? colour : 0xFFFFFF;
			}
		}
		, item);
	}
	
	private void setShieldTEISR(ItemShield shield, String textureName, String bannerID, ModelShield model)
	{
		if(shield == null)	return;
		shield.setTileEntityItemStackRenderer(new TileEntityItemStackRendererSS(shield, String.format("textures/entity/%s_nopattern.png", textureName), String.format("textures/entity/%s_pattern.png", textureName), bannerID, model));
	}

	@Override
	public void postInit(FMLPostInitializationEvent ev) {}

}
