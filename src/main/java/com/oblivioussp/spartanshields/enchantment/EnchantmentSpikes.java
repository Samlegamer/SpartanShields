package com.oblivioussp.spartanshields.enchantment;

import java.util.Random;

import com.oblivioussp.spartanshields.init.EnchantmentRegistry;
import com.oblivioussp.spartanshields.item.ItemShieldBase;
import com.oblivioussp.spartanshields.util.LogHelper;
import com.oblivioussp.spartanshields.util.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Enchantments;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class EnchantmentSpikes extends EnchantmentSS
{
	public EnchantmentSpikes(Rarity rarityIn, EntityEquipmentSlot... slots) 
	{
		super(rarityIn, EnchantmentSS.TYPE_SHIELD, slots);
		this.setName("spikes");
		this.setRegistryName("ssEnchSpikes");
	}
	
	/**
     * Returns the minimal value of enchantability needed on the enchantment level passed.
     */
    @Override
    public int getMinEnchantability(int enchantmentLevel)
    {
        return 10 + 20 * (enchantmentLevel - 1);
    }

    /**
     * Returns the maximum value of enchantability needed on the enchantment level passed.
     */
    @Override
    public int getMaxEnchantability(int enchantmentLevel)
    {
        return super.getMinEnchantability(enchantmentLevel) + 50;
    }

    /**
     * Returns the maximum level that the enchantment can have.
     */
    @Override
    public int getMaxLevel()
    {
        return 3;
    }
    
    /**
     * Return the name of key in translation table of this enchantment.
     */
    @Override
    public String getName()
    {
    	return String.format("enchantment.%s:%s", Reference.ModID, this.name);
    }
    
    @Override
    public void onUserAttacked(EntityLivingBase user, Entity attacker, int level)
    {
        Random random = user.getRNG();
        ItemStack itemStack = EnchantmentHelper.getEnchantedItem(EnchantmentRegistry.enchSpikes, user);
        ItemStack activeStack = user.getActiveItemStack();

        // Only deal damage when Shield is blocking (is active)
        if(!activeStack.isEmpty() && activeStack == itemStack)
        {
	        if (shouldHit(level, random))
	        {
	            if (attacker != null)
	                attacker.attackEntityFrom(DamageSource.causeThornsDamage(user), (float)getDamage(level, random));
	
	            if (!itemStack.isEmpty())
	            	itemStack.damageItem(9, user);
	        }
	        else if (!itemStack.isEmpty())
	        	itemStack.damageItem(3, user);
        }
    }

    public static boolean shouldHit(int level, Random rnd)
    {
        return level <= 0 ? false : rnd.nextFloat() < 0.20F * (float)level;
    }

    public static int getDamage(int level, Random rnd)
    {
    	if(level == 1)
    		return 2;
        return 2 + rnd.nextInt(level - 1);
    }
    
   /* public static void damageShield(ItemStack stack, int i, EntityLivingBase entity)
    {
    	ItemStack activeStack = entity.getActiveItemStack();
    	
    	if(activeStack != null && activeStack == stack)
    	{
    		stack.damageItem(i * 3, entity);
    	}
    }*/
}
