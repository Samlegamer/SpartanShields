package com.oblivioussp.spartanshields.util;

import net.minecraft.item.Item;

public class MappingConverterEntry
{
	protected String name;
	protected Item itemToConvertTo;
	
	public MappingConverterEntry(String missingName, Item itemConvert)
	{
		name = missingName;
		itemToConvertTo = itemConvert;
	}
	
	public String getMappingName()
	{
		return name;
	}
	
	public Item getItemToConvertTo()
	{
		return itemToConvertTo;
	}
}
