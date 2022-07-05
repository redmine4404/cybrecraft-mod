package fr.redmine.redmod.mob.render;

import fr.redmine.redmod.mob.monster.Entitybob;
import fr.redmine.redmod.utils.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderMobBob extends RenderLiving{

	private static final ResourceLocation mobTextures = new ResourceLocation(Reference.MOD_ID + ":textures/entity/BobEntity.png"); 
	
	public RenderMobBob(ModelBase model, float par2) {
		super(model, par2);
	}

	protected ResourceLocation getEntityTexture(Entitybob entity) {
		return mobTextures;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return this.getEntityTexture((Entitybob)entity);
	}

}
