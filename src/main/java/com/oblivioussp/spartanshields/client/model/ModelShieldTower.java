package com.oblivioussp.spartanshields.client.model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelShield;

public class ModelShieldTower extends ModelShield
{
    public ModelRenderer plateLeft;
    public ModelRenderer plateRight;

    public ModelShieldTower()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.plate = new ModelRenderer(this, 0, 0);
        this.plate.addBox(-6.0f, -11.0f, -2.0f, 12, 22, 1, 0.0f);
        this.handle = new ModelRenderer(this, 26, 0);
        this.handle.addBox(-1.0f, -3.0f, -1.0f, 2, 6, 6, 0.0f);
        this.plateLeft = new ModelRenderer(this, 42, 0);
        this.plateLeft.setRotationPoint(-6.0f, 0.0f, -2.0f);
        this.plateLeft.rotateAngleY = 45.0f;
        this.plateLeft.addBox(-2.0f, -11.0f, 0.0f, 2, 22, 1, 0.0f);
        this.plateRight = new ModelRenderer(this, 48, 0);
        this.plateRight.setRotationPoint(6.0f, 0.0f, -2.0f);
        this.plateRight.rotateAngleY = -45.0f;
        this.plateRight.addBox(0.0f, -11.0f, 0.0f, 2, 22, 1, 0.0f);
    }

    public void render()
    {
        this.plate.render(0.0625f);
        this.plateLeft.render(0.0625f);
        this.plateRight.render(0.0625f);
        this.handle.render(0.0625f);
    }
}
