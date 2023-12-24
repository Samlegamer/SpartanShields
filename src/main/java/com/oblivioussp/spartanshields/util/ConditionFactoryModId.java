package com.oblivioussp.spartanshields.util;

import java.util.function.BooleanSupplier;

import com.google.gson.JsonObject;

import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;

public class ConditionFactoryModId implements IConditionFactory
{
	@Override
	public BooleanSupplier parse(JsonContext context, JsonObject json) 
	{
		String modId = json.get("mod").getAsString();
		boolean result = Loader.isModLoaded(modId) && !ConfigHandler.vanillaOnly;
		//LogHelper.info(String.format("Is Mod loaded: %s = %s",  modId, String.valueOf(Loader.isModLoaded(modId))));
		return () -> result;
	}

}
