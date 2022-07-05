package fr.redmine.redmod.mob.monster;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class Entitybob extends EntityMob{

	public Entitybob(World world) {
		super(world);
		this.setSize(0.5F , 1.9F);
		this.tasks.addTask(0, new EntityAIWander(this, 0.5D));
		this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
		this.tasks.addTask(2, new EntityAITempt(this, 0.7D, Items.beef, false));
	}

	public boolean isAIEneable() {
		return true;
	}
	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0F);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0F);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(2.5F);
	}
}

