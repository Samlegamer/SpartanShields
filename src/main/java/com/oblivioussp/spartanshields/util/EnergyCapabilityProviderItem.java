package com.oblivioussp.spartanshields.util;

import com.oblivioussp.spartanshields.item.IItemPoweredFE;

import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;

public class EnergyCapabilityProviderItem implements ICapabilityProvider
{
	public IEnergyStorage storage;
	
	public EnergyCapabilityProviderItem(ItemStack stack, IItemPoweredFE item)
	{
		storage = new IEnergyStorage()
		{
			@Override
		    public int receiveEnergy(int maxReceive, boolean simulate)
		    {
				return item.receiveFE(stack, maxReceive, simulate);
		    }

			@Override
			public int extractEnergy(int maxExtract, boolean simulate) 
			{
				return item.extractFE(stack, maxExtract, simulate);
			}

			@Override
			public int getEnergyStored() 
			{
				return item.getFEStored(stack);
			}

			@Override
			public int getMaxEnergyStored()
			{
				return item.getFECapacity(stack);
			}

			@Override
			public boolean canExtract() 
			{
				return item.canExtractFE(stack);
			}

			@Override
			public boolean canReceive() 
			{
				return item.canReceiveFE(stack);
			}
		};
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
	{
		return this.getCapability(capability, facing) != null;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
	{
		if(capability == CapabilityEnergy.ENERGY)
			return (T)this.storage;
		return null;
	}

}
