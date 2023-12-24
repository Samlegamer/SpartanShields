package com.oblivioussp.spartanshields.client.model;

import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelShield;

public class ModelShieldKite extends ModelShield 
{
	public ModelRenderer plateLeft;
    public ModelRenderer plateRight;

    public ModelShieldKite()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        plate = new ModelRenderer(this);
		plate.setRotationPoint(0.0F, 0.0F, 0.0F);
		plate.cubeList.add(new ModelBox(plate, 0, 0, -6.0F, -11.0F, -2.0F, 12, 22, 1, 0.0F, false));

		handle = new ModelRenderer(this);
		handle.setRotationPoint(0.0F, 0.0F, 0.0F);
		handle.cubeList.add(new ModelBox(handle, 26, 0, -1.0F, -3.0F, -1.0F, 2, 6, 6, 0.0F, false));

		plateLeft = new ModelRenderer(this);
		plateLeft.setRotationPoint(-6.0F, 0.0F, 0.0F);
		setRotationAngle(plateLeft, 0.0F, 0.0F, -0.1963F);
		plateLeft.cubeList.add(new ModelBox(plateLeft, 52, 0, -1.85F, -10.788F, -1.99F, 4, 20, 1, 0.0F, false));

		plateRight = new ModelRenderer(this);
		plateRight.setRotationPoint(6.0F, 0.0F, 0.0F);
		setRotationAngle(plateRight, 0.0F, 0.0F, 0.1963F);
		plateRight.cubeList.add(new ModelBox(plateRight, 42, 0, -2.15F, -10.788F, -1.99F, 4, 20, 1, 0.0F, false));
    }

	@Override
	public void render() 
	{
		this.plate.render(0.0625f);
		
//		this.plateLeft = new ModelRenderer(this, 42, 0);
//		this.plateLeft.addBox(9.6f, -13.1f, -1.999f, 4, 20, 1);
//		this.plateLeft.setRotationPoint(-6.0f, 0.0f, 0.0f);
//		this.plateLeft.rotateAngleZ = 0.19634954f;
		this.plateLeft.render(0.0625f);

//		this.plateRight = new ModelRenderer(this, 52, 0);
//		this.plateRight.addBox(-12.8f, -17.025f, -1.999f, 4, 20, 1);
//		this.plateRight.setRotationPoint(6.0f, 4.0f, 0.0f);
//		this.plateRight.rotateAngleZ = -0.19634954f;
		this.plateRight.render(0.0625f);
		this.handle.render(0.0625f);
	}
	
	protected void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
