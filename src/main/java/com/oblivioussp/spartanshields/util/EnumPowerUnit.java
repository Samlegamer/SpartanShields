package com.oblivioussp.spartanshields.util;

public enum EnumPowerUnit 
{
	RedstoneFlux("rfCapacity", "rfPerDamage", 1.0f),
	ForgeEnergy("feCapacity", "fePerDamage", 1.0f),
	MicroInfinity("uiCapacity", "uiPerDamage", 1.0f);
	
	
	private String capUnloc;
	private String enPerDamUnloc;
	private float scale;
	
	private EnumPowerUnit(String capacityUnloc, String energyPerDamageUnloc, float powerScale)
	{
		capUnloc = capacityUnloc;
		enPerDamUnloc = energyPerDamageUnloc;
		scale = powerScale;
	}

	public String getCapacityUnlocalised()
	{
		return capUnloc;
	}
	
	public String getEnergyPerDamageUnlocalised()
	{
		return enPerDamUnloc;
	}
	
	public float getEnergyScaleToRF()
	{
		return scale;
	}
}
