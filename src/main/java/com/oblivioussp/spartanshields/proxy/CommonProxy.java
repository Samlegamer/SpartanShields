package com.oblivioussp.spartanshields.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public abstract class CommonProxy 
{
	public abstract void preInit(FMLPreInitializationEvent ev);
	public abstract void init(FMLInitializationEvent ev);
	public abstract void postInit(FMLPostInitializationEvent ev);
}
