package com.oblivioussp.spartanshields.client.render.item;

import com.oblivioussp.spartanshields.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelShield;
import net.minecraft.client.renderer.BannerTextures;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.ResourceLocation;

public class TileEntityItemStackRendererSS extends TileEntityItemStackRenderer 
{
	//protected static final BannerTextures.Cache SHIELD_TOWER_IRON_DESIGNS = new BannerTextures.Cache("S_I", new ResourceLocation(Reference.ModID, "textures/entity/shield_tower_iron_pattern.png"), "textures/entity/shield/");
	//protected static final BannerTextures.Cache SHIELD_TOWER_GOLD_DESIGNS = new BannerTextures.Cache("S_G", new ResourceLocation(Reference.ModID, "textures/entity/shield_tower_gold_pattern.png"), "textures/entity/shield/");
	//protected static final BannerTextures.Cache SHIELD_TOWER_DIAMOND_DESIGNS = new BannerTextures.Cache("S_D", new ResourceLocation(Reference.ModID, "textures/entity/shield_tower_diamond_pattern.png"), "textures/entity/shield/");
	//protected final ResourceLocation TEXTURE_SHIELD_TOWER_IRON = new ResourceLocation(Reference.ModID, "textures/entity/shield_tower_iron_nopattern.png");
	//protected final ResourceLocation TEXTURE_SHIELD_TOWER_GOLD = new ResourceLocation(Reference.ModID, "textures/entity/shield_tower_gold_nopattern.png");
	//protected final ResourceLocation TEXTURE_SHIELD_TOWER_DIAMOND = new ResourceLocation(Reference.ModID, "textures/entity/shield_tower_diamond_nopattern.png");
	
	protected final BannerTextures.Cache SHIELD_BANNER_DESIGNS;
	protected final ResourceLocation TEXTURE_SHIELD_NO_PATTERN;
	protected final Item shield;
	protected final ModelShield shieldModel;
	protected final TileEntityBanner teBanner = new TileEntityBanner();
	
	public TileEntityItemStackRendererSS(ItemShield itemShield, String textureNoPattern, String texturePattern, String bannerID, ModelShield modelShield)
	{
		shield = itemShield;
		shieldModel = modelShield;
		TEXTURE_SHIELD_NO_PATTERN = new ResourceLocation(Reference.ModID, textureNoPattern);
		SHIELD_BANNER_DESIGNS = new BannerTextures.Cache(bannerID, new ResourceLocation(Reference.ModID, texturePattern), "textures/entity/shield/");
	}

	@Override
	public void renderByItem(ItemStack stack) 
	{
		this.renderByItem(stack, 1.0f);
	}

	@Override
	public void renderByItem(ItemStack stack, float partialTicks) 
	{
		Item item = stack.getItem();
		if(item == shield)
		{
			if (stack.getSubCompound("BlockEntityTag") != null)
			{
				this.teBanner.setItemValues(stack, true);
				Minecraft.getMinecraft().getTextureManager().bindTexture(this.SHIELD_BANNER_DESIGNS.getResourceLocation(this.teBanner.getPatternResourceLocation(), this.teBanner.getPatternList(), this.teBanner.getColorList()));
			}
			else
			{
				Minecraft.getMinecraft().getTextureManager().bindTexture(this.TEXTURE_SHIELD_NO_PATTERN);
			}
			
            GlStateManager.pushMatrix();
            GlStateManager.scale(1.0F, -1.0F, -1.0F);
            this.shieldModel.render();
            GlStateManager.popMatrix();
		}
		
		super.renderByItem(stack, partialTicks);
	}	
}
