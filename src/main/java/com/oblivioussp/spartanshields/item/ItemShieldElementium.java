package com.oblivioussp.spartanshields.item;

import java.util.List;

import javax.annotation.Nullable;

import com.oblivioussp.spartanshields.util.Reference;
import com.oblivioussp.spartanshields.util.StringHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import vazkii.botania.api.item.IPixieSpawner;

@Optional.Interface(iface="vazkii.botania.api.item.IPixieSpawner", modid=Reference.Botania_ModID)
public class ItemShieldElementium extends ItemShieldBotania implements IPixieSpawner
{

	public ItemShieldElementium(String unlocName, int maxDamage, ToolMaterial toolMaterial) 
	{
		super(unlocName, maxDamage, toolMaterial);
	}
	
    @SideOnly(Side.CLIENT)
    @Override
    public void addEffectsTooltip(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag flagIn)
    {
    	tooltip.add(TextFormatting.GOLD + StringHelper.translateFormattedString("onBlock", "tooltip", Reference.ModID, StringHelper.translateFormattedString("shieldElementium.desc", "tooltip", (int)(getPixieChance(stack) * 100))));
    }

	@Override
	public float getPixieChance(ItemStack stack) 
	{
		return 0.1f;
	}

}
