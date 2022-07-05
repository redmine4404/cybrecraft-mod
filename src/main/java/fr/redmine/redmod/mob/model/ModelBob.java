package fr.redmine.redmod.mob.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports


public class ModelBob extends ModelBase {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightLeg;

	public ModelBob() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 0, -5.0F, -10.0F, -4.0F, 10, 10, 10, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, -1.0F, -9.0F, 0.0F, 1, 1, 1, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, 1.0F, -11.0F, -2.0F, 1, 1, 1, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, 1.0F, -11.0F, 0.0F, 1, 1, 1, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, 1.0F, -11.0F, 1.0F, 1, 1, 1, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, 1.0F, -11.0F, 2.0F, 1, 1, 1, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, 1.0F, -11.0F, 3.0F, 1, 1, 1, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, 1.0F, -11.0F, 4.0F, 1, 1, 1, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, 1.0F, -11.0F, -1.0F, 1, 1, 1, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, 1.0F, -11.0F, 5.0F, 1, 1, 1, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, 1.0F, -7.0F, 6.0F, 1, 1, 1, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, 1.0F, -10.0F, 6.0F, 1, 1, 1, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, 1.0F, -9.0F, 6.0F, 1, 1, 1, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, 1.0F, -8.0F, 6.0F, 1, 1, 1, 0.0F));
		head.cubeList.add(new ModelBox(head, 0, 0, 1.0F, -6.0F, 6.0F, 1, 1, 1, 0.0F));

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 16, 16, -4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F));

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		leftArm.cubeList.add(new ModelBox(leftArm, 40, 16, -3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F));

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		rightArm.cubeList.add(new ModelBox(rightArm, 40, 16, -1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F));

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		leftLeg.cubeList.add(new ModelBox(leftLeg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F));

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		rightLeg.cubeList.add(new ModelBox(rightLeg, 0, 16, -2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);	
		head.render(f5);
		body.render(f5);
		leftArm.render(f5);
		rightArm.render(f5);
		leftLeg.render(f5);
		rightLeg.render(f5);
	}

	  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	  {
		  super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		  float f6 = (180F / (float)Math.PI);
		  this.leftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
		  this.rightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
		  this.leftArm.rotateAngleX = -90F;
		  this.rightArm.rotateAngleX = -90F;
	  }
}