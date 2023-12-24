package com.oblivioussp.spartanshields.item;

import java.util.List;

import javax.annotation.Nullable;

import com.oblivioussp.spartanshields.client.gui.CreativeTabsSS;
import com.oblivioussp.spartanshields.util.Reference;
import com.oblivioussp.spartanshields.util.StringHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Enchantments;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ItemShieldBase extends ItemShield 
{	
	public ItemShieldBase(String unlocName)
	{
		super();
		this.setCreativeTab(CreativeTabsSS.TAB_SS);
		this.setRegistryName(unlocName);
		this.setUnlocalizedName(unlocName);
	}
	
	@Override
	public String getUnlocalizedName()
	{
		return StringHelper.getItemUnlocalizedName(super.getUnlocalizedName());
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return StringHelper.getItemUnlocalizedName(super.getUnlocalizedName());
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
        return ("" + I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name")).trim();
    }
    
    /*@Override
	public EnumAction getItemUseAction(ItemStack stack) 
    {
		return super.getItemUseAction(stack);
	}*/

	/**
     * gets the CreativeTab this item is displayed on
     */
    @Override
    @SideOnly(Side.CLIENT)
    public CreativeTabs getCreativeTab()
    {
        return CreativeTabsSS.TAB_SS;
    }
    
    /**
     * Return whether this item is repairable in an anvil.
     */
    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
    	return false;
    }
    
    @Override
    public boolean isShield(ItemStack stack, @Nullable EntityLivingBase entity)
    {
    	return true;
    }

	/*@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
	{
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}*/
	
	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment)
	{
		return enchantment == Enchantments.KNOCKBACK || super.canApplyAtEnchantingTable(stack, enchantment);
	}

	@Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BLOCK;
    }

    @SideOnly(Side.CLIENT)
    public void addEffectsTooltip(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {}
	
    @SideOnly(Side.CLIENT)
    public void addShieldBashTooltip(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
    	tooltip.add(TextFormatting.BLUE + StringHelper.translateFormattedString("shieldBash", "tooltip", Reference.ModID, Minecraft.getMinecraft().gameSettings.keyBindAttack.getDisplayName() /*StringHelper.translateString("buttonShieldBash", "tooltip")*/));
    }
    
    /**
     * Allows shields to customise how they take damage. Called from EventHandlerSS.
     * @param shieldStack The Shield ItemStack
     * @param player The Player wielding the shield
     * @param damage The damage taken
     */
    //public abstract void damageShield(ItemStack shieldStack, EntityPlayer player, Entity attacker, float damage);
}
