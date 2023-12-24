package com.oblivioussp.spartanshields.client.gui;

import java.util.ArrayList;
import java.util.List;

import com.oblivioussp.spartanshields.util.ConfigHandler;
import com.oblivioussp.spartanshields.util.Reference;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

public class GuiConfigSS extends GuiConfig
{
	public GuiConfigSS(GuiScreen guiScreen)
	{
		super(guiScreen,
				//new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
				getConfigElements(),
				Reference.ModID,
				false,
				true,
				Reference.ModName + " Config");
				//GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
	}
	
	private static List<IConfigElement> getConfigElements()
	{
		List<IConfigElement> elements = new ArrayList<IConfigElement>();
		
		for(int i = 0; i < ConfigHandler.categories.length; i++)
		{
			elements.add(new ConfigElement(ConfigHandler.config.getCategory(ConfigHandler.categories[i])));
		}
		return elements;
	}
}
