package com.oblivioussp.spartanshields.item;

import java.util.List;

import javax.annotation.Nullable;

import com.oblivioussp.spartanshields.util.LogHelper;
import com.oblivioussp.spartanshields.util.Reference;
import com.oblivioussp.spartanshields.util.StringHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBanner;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class ItemShieldBasic extends ItemShieldBase 
{
	protected Item.ToolMaterial material;	// The base material used for this shield

	public ItemShieldBasic(String unlocName, int maxDamage, ToolMaterial toolMaterial) 
	{
		super(unlocName);
		this.material = toolMaterial;
		this.setMaxDamage(maxDamage);
	}
	
	public ItemShieldBasic setToolMaterial(ToolMaterial toolMaterial)
	{
		this.material = toolMaterial;
		return this;
	}
	
	/**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
    	//tooltip.add(TextFormatting.RED + StringHelper.getLocalizedString("wip", "tooltip"));
    	tooltip.add(StringHelper.translateFormattedString("protection", "tooltip", this.getMaxDamage()));
    	
    	if(!stack.isEmpty() && stack.hasTagCompound() && stack.getTagCompound().hasKey("BlockEntityTag"))
    	{
    		EnumDyeColor dyeColor = TileEntityBanner.getColor(stack);
    		tooltip.add("");
    		tooltip.add(StringHelper.translateString("hasPatterns", "tooltip"));
    		tooltip.add(I18n.translateToLocal("item.banner." + dyeColor.getUnlocalizedName() + ".name"));
    		ItemBanner.appendHoverTextFromTileEntityTag(stack, tooltip);
    	}
    	
    	addEffectsTooltip(stack, worldIn, tooltip, flagIn);

    	tooltip.add("");
    	this.addShieldBashTooltip(stack, worldIn, tooltip, flagIn);
    }
    
	/**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    @Override
    public int getItemEnchantability()
    {
        return this.material.getEnchantability();
    }
    
    /**
     * Return whether this item is repairable in an anvil.
     */
    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
    	ItemStack repairStack = material.getRepairItemStack();
    	
    	if(repairStack == null)		return false;
    	if(OreDictionary.itemMatches(repairStack, repair, false))	return true;
    	return false;
    }

	/*@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) 
	{
		if(player.isActiveItemStackBlocking())
			LogHelper.info("SHIELD BASH!!! >|<");
		return super.onLeftClickEntity(stack, player, entity);
	}*/
    
    /**
     * Allows shields to take damage. Called from EventHandlerSS
     * @param shieldStack The Shield ItemStack
     * @param player The Player wielding the shield
     * @param damage The damage taken
     */
    /*@Override
    public void damageShield(ItemStack shieldStack, EntityPlayer player, Entity attacker, float damage)
    {
    	int i = 1 + MathHelper.floor(damage);
        shieldStack.damageItem(i, player);

        if (shieldStack.getCount() <= 0)
        {
            EnumHand activeHand = player.getActiveHand();
            net.minecraftforge.event.ForgeEventFactory.onPlayerDestroyItem(player, shieldStack, activeHand);

            if (activeHand == EnumHand.MAIN_HAND)
            {
                player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, Reference.STACK_NULL);
            }
            else
            {
                player.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, Reference.STACK_NULL);
            }

            shieldStack = null;
            player.playSound(SoundEvents.ITEM_SHIELD_BREAK, 0.8F, 0.8F + player.world.rand.nextFloat() * 0.4F);
        }
    }*/
}
