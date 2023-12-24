package com.oblivioussp.spartanshields.item;

import java.util.UUID;

import com.google.common.collect.Multimap;
import com.oblivioussp.spartanshields.util.Reference;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ItemShieldObsidian extends ItemShieldBasic 
{
	private static final String ORE_DICT_REPAIR = "obsidian";
	
	public ItemShieldObsidian(String unlocName, int maxDamage, ToolMaterial toolMaterial) 
	{
		super(unlocName, maxDamage, toolMaterial);
	}

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack)
    {
		Multimap<String, AttributeModifier> modifiers = super.getAttributeModifiers(slot, stack);
		
		if (slot == EntityEquipmentSlot.MAINHAND || slot == EntityEquipmentSlot.OFFHAND)
        {
			modifiers.put(SharedMonsterAttributes.MOVEMENT_SPEED.getName(), new AttributeModifier(UUID.fromString(Reference.uuidShieldMoveSpeed), Reference.ModID + ":shieldMovementSpeed", -0.3, 2));
			modifiers.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName(), new AttributeModifier(UUID.fromString(Reference.uuidShieldKnockback), Reference.ModID + ":shieldMovementKnockback", 0.5, 0));
        }
		
		return modifiers;
    }
    
    /**
     * Return whether this item is repairable in an anvil.
     */
    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
    	return OreDictionary.containsMatch(false, OreDictionary.getOres(ORE_DICT_REPAIR), repair);
    }
}
