package com.oblivioussp.spartanshields.item;

import java.util.List;

import javax.annotation.Nullable;

import com.oblivioussp.spartanshields.client.gui.CreativeTabsSS;
import com.oblivioussp.spartanshields.util.ConfigHandler;
import com.oblivioussp.spartanshields.util.EnergyCapabilityProviderItem;
import com.oblivioussp.spartanshields.util.EnumPowerUnit;
import com.oblivioussp.spartanshields.util.Reference;
import com.oblivioussp.spartanshields.util.StringHelper;

import cofh.redstoneflux.api.IEnergyContainerItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Optional.Interface(iface="cofh.redstoneflux.api.IEnergyContainerItem", modid=Reference.RedstoneFlux_ModID)
public class ItemShieldPoweredFE extends ItemShieldBase implements IDamageShield, IItemPoweredFE, IEnergyContainerItem
{
	protected int energyCapacity;
	protected int maxEnergyReceive;
	protected String modName;
	protected EnumPowerUnit preferredEnergyUnit;

	public ItemShieldPoweredFE(String unlocName, int capacity, int maxReceive, String modName, EnumPowerUnit preferredUnit)
	{
		super(unlocName);
		this.energyCapacity = capacity;
		this.maxEnergyReceive = maxReceive;
		this.modName = modName;
		this.preferredEnergyUnit = preferredUnit;
		if(!Loader.isModLoaded(Reference.RedstoneFlux_ModID))
			this.preferredEnergyUnit = EnumPowerUnit.ForgeEnergy;
		
		this.setCreativeTab(CreativeTabsSS.TAB_SS);
		
		this.addPropertyOverride(new ResourceLocation("disabled"), new IItemPropertyGetter()
			{
				@SideOnly(Side.CLIENT)
				public float apply(ItemStack stack, World worldIn, EntityLivingBase entityIn) 
				{
					if(!stack.hasTagCompound())
						stack.setTagCompound(new NBTTagCompound());
					return stack.getTagCompound().getInteger("Energy") <= 0 ? 1.0f : 0.0f;
				}
			});
		
	}
    
    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems)
    {
    	if(this.isInCreativeTab(tab))
    	{
	    	ItemStack fullShield = new ItemStack(this);
	    	fullShield.setTagCompound(new NBTTagCompound());
	    	fullShield.getTagCompound().setInteger("Energy", energyCapacity);
	    	
	        subItems.add(new ItemStack(this));
	        subItems.add(fullShield);
    	}
    }
	
	@Override
	public void setDamage(ItemStack stack, int damage)
	{
		super.setDamage(stack, 0);
	}
	
	@Override
	public double getDurabilityForDisplay(ItemStack stack)
	{
		if(!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());
		int energy = stack.getTagCompound().getInteger("Energy");
		return ((double)energyCapacity - energy) / (double)energyCapacity;
	}
	
	/**
     * Returns the packed int RGB value used to render the durability bar in the GUI.
     * Defaults to a value based on the hue scaled as the damage decreases, but can be overriden.
     *
     * @param stack Stack to get durability from
     * @return A packed RGB value for the durability colour (0x00RRGGBB)
     */
    public int getRGBDurabilityForDisplay(ItemStack stack)
    {
    	return 0x69B3FF;
    }
	
	@Override
	public int getMaxDamage()
	{
		return energyCapacity;
	}
	
	@Override
	public boolean showDurabilityBar(ItemStack stack)
    {
		if(!stack.hasTagCompound())
			stack.setTagCompound(new NBTTagCompound());
		int energy = stack.getTagCompound().getInteger("Energy");
        return energy < energyCapacity;
    }
	
	/**
     * allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
    	//tooltip.add(TextFormatting.RED + StringHelper.getLocalizedString("dev.wip", "tooltip"));
    	if(!Loader.isModLoaded(modName) && !ConfigHandler.forceDisableUncraftableTooltips)
    	{
    		tooltip.add(TextFormatting.RED + StringHelper.translateString("cantCraftMissingMods", "tooltip"));
    		tooltip.add(TextFormatting.RED + StringHelper.translateString(modName.toLowerCase(), "mod"));
    	}
    	
    	String capacityStr, perDamageStr;
    	
    	tooltip.add(StringHelper.translateFormattedString(preferredEnergyUnit.getCapacityUnlocalised(), "tooltip", MathHelper.floor(this.getFEStored(stack) * preferredEnergyUnit.getEnergyScaleToRF()), MathHelper.floor(this.getFECapacity(stack) * preferredEnergyUnit.getEnergyScaleToRF())));
    	tooltip.add(StringHelper.translateFormattedString(preferredEnergyUnit.getEnergyPerDamageUnlocalised(), "tooltip", MathHelper.floor(ConfigHandler.damageToFEMultiplier * 2  * preferredEnergyUnit.getEnergyScaleToRF())));
    	tooltip.add(StringHelper.translateString("feShield.desc", "tooltip"));
    	
    	tooltip.add("");
    	this.addShieldBashTooltip(stack, worldIn, tooltip, flagIn);
    	
    	//super.addInformation(stack, worldIn, tooltip, flagIn);
    }
    
    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
    	if(this.getFEStored(stack) > 0)
    		return EnumAction.BLOCK;
    	else
    		return EnumAction.NONE;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        playerIn.setActiveHand(hand);
        ItemStack stack = playerIn.getHeldItem(hand);
        if(this.getFEStored(stack) > 0)
        	return new ActionResult(EnumActionResult.SUCCESS, stack);
        else
        {
        	if(worldIn.isRemote)
        		playerIn.sendMessage(new TextComponentString(TextFormatting.YELLOW
        			+ StringHelper.translateString("poweredShieldBlockFail", "message")));
        	return new ActionResult(EnumActionResult.FAIL, stack);
        }
    }

	@Override
	public void damageShield(ItemStack shieldStack, EntityPlayer player, Entity attacker, float damage) 
	{
		int energyToUse = MathHelper.floor((float)(damage * ConfigHandler.damageToRFMultiplier));
		
		// Remove RF from the shield to absorb the damage.
		if(!shieldStack.hasTagCompound())
			shieldStack.setTagCompound(new NBTTagCompound());
		
		int currentEnergy = shieldStack.getTagCompound().getInteger("Energy");
		int energyRemoved = Math.min(energyToUse, currentEnergy);
		
		currentEnergy -= energyRemoved;
		shieldStack.getTagCompound().setInteger("Energy", currentEnergy);
		
		if(currentEnergy == 0)
			player.playSound(SoundEvents.ITEM_SHIELD_BREAK, 0.8F, 0.8F + player.world.rand.nextFloat() * 0.4F);
	}
	
	public ItemShieldPoweredFE setCapacity(int capacity) 
	{
		this.energyCapacity = capacity;
		return this;
	}

	public ItemShieldPoweredFE  setMaxReceive(int maxReceive) 
	{
		this.maxEnergyReceive = maxReceive;
		return this;
	}

	/* IItemPoweredFE */
	@Override
	public int receiveFE(ItemStack container, int maxReceive, boolean simulate) 
	{
		if (!container.hasTagCompound()) 
			container.setTagCompound(new NBTTagCompound());
		
		int energy = container.getTagCompound().getInteger("Energy");
		int energyReceived = Math.min(energyCapacity - energy, Math.min(this.maxEnergyReceive, maxReceive));

		if (!simulate)
		{
			energy += energyReceived;
			container.getTagCompound().setInteger("Energy", energy);
		}
		return energyReceived;
	}

	@Override
	public int extractFE(ItemStack container, int maxExtract, boolean simulate) 
	{
		return 0;
	}

	@Override
	public int getFEStored(ItemStack container) {

		if (container.getTagCompound() == null || !container.getTagCompound().hasKey("Energy")) 
			return 0;
		
		return container.getTagCompound().getInteger("Energy");
	}

	@Override
	public int getFECapacity(ItemStack container) 
	{
		return energyCapacity;
	}

	@Override
	public boolean canExtractFE(ItemStack stack)
	{
		return false;
	}

	@Override
	public boolean canReceiveFE(ItemStack stack) 
	{
		return true;
	}
	
	/**
     * Called from ItemStack.setItem, will hold extra data for the life of this ItemStack.
     * Can be retrieved from stack.getCapabilities()
     * The NBT can be null if this is not called from readNBT or if the item the stack is
     * changing FROM is different then this item, or the previous item had no capabilities.
     *
     * This is called BEFORE the stacks item is set so you can use stack.getItem() to see the OLD item.
     * Remember that getItem CAN return null.
     *
     * @param stack The ItemStack
     * @param nbt NBT of this item serialized, or null.
     * @return A holder instance associated with this ItemStack where you can hold capabilities for the life of this item.
     */
	@Override
    public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound nbt)
    {
        return new EnergyCapabilityProviderItem(stack, this);
    }
	
	/* IEnergyContainerItem */
	// Wraps to using the FE methods
	@Override
	public int receiveEnergy(ItemStack stack, int maxReceive, boolean simulate) 
	{
		return receiveFE(stack, maxReceive, simulate);
	}

	@Override
	public int extractEnergy(ItemStack stack, int maxExtract, boolean simulate) 
	{
		return extractFE(stack, maxExtract, simulate);
	}

	@Override
	public int getEnergyStored(ItemStack stack) 
	{
		return getFEStored(stack);
	}

	@Override
	public int getMaxEnergyStored(ItemStack stack) 
	{
		return getFECapacity(stack);
	}
}
