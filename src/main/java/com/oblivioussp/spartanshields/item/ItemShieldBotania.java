package com.oblivioussp.spartanshields.item;

import java.util.List;

import javax.annotation.Nullable;

import com.oblivioussp.spartanshields.util.ConfigHandler;
import com.oblivioussp.spartanshields.util.Reference;
import com.oblivioussp.spartanshields.util.StringHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;

@Optional.Interface(iface="vazkii.botania.api.mana.IManaUsingItem", modid=Reference.Botania_ModID)
public class ItemShieldBotania extends ItemShieldBasic implements IManaUsingItem
{
	protected int manaPerDamage = 60;

	public ItemShieldBotania(String unlocName, int maxDamage, ToolMaterial toolMaterial) 
	{
		super(unlocName, maxDamage, toolMaterial);
	}
	
	public ItemShieldBotania(String unlocName, int maxDamage, ToolMaterial toolMaterial, int manaUsePerDamage)
	{
		this(unlocName, maxDamage, toolMaterial);
		this.manaPerDamage = manaUsePerDamage;
	}
	
	/*@Override
    public void damageShield(ItemStack shieldStack, EntityPlayer player, Entity attacker, float damage)
    {
    	int requestedMana = (1 + MathHelper.floor(damage)) * manaPerDamage;
    	// Attempt to absorb shield damage via mana use
    	
    	boolean useManaInstead = ManaItemHandler.requestManaExactForTool(shieldStack, player, requestedMana, true);
		// If not enough mana is available, damage the shield by normal means
    	if(!useManaInstead)
			super.damageShield(shieldStack, player, attacker, damage);
    }*/
	
	/**
     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
     * update it's contents.
     */
	@Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		if(!worldIn.isRemote && entityIn instanceof EntityPlayer && 
				stack.getItemDamage() > 0 && 
				requestManaForRepair(stack, (EntityPlayer)entityIn, this.manaPerDamage * 2))
		{
			stack.setItemDamage(this.getDamage(stack) - 1);
		}
    }
	
	@Optional.Method(modid = Reference.Botania_ModID)
	protected boolean requestManaForRepair(ItemStack stack, EntityPlayer player, int manaRequested)
	{
		return ManaItemHandler.requestManaExactForTool(stack, player, manaRequested, true);
	}
	
	/**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn)
    {
    	//tooltip.add(TextFormatting.RED + StringHelper.getLocalizedString("dev.wip", "tooltip"));
    	if(!Loader.isModLoaded(Reference.Botania_ModID) && !ConfigHandler.forceDisableUncraftableTooltips)
    	{
    		tooltip.add(TextFormatting.RED + StringHelper.translateString("cantCraftMissingMods", "tooltip"));
    		tooltip.add(TextFormatting.RED + StringHelper.translateString("botania", "mod"));
    	}
    	tooltip.add(StringHelper.translateFormattedString("protection", "tooltip", this.getMaxDamage()));
    	
    	this.addEffectsTooltip(stack, world, tooltip, flagIn);
    	
    	tooltip.add("");
    	this.addShieldBashTooltip(stack, world, tooltip, flagIn);
    }

	@Override
	public boolean usesMana(ItemStack stack) 
	{
		return true;
	}

}
