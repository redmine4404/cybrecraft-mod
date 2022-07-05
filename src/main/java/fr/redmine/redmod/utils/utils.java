package fr.redmine.redmod.utils;

import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class utils {

	public static EntityPlayerMP getPlayer(String name) {
		return MinecraftServer.getServer().getConfigurationManager().func_152612_a(name);

	}
	public static void setEntityHealth(EntityPlayer player, int maxHealth) {
		IAttributeInstance healthAttribute = player.getEntityAttribute(SharedMonsterAttributes.maxHealth);
		AttributeModifier moras = new AttributeModifier(UUID.fromString("B9766C51-9566-4402-BC1F-2EE2A276D836"), "Health Boost", maxHealth, 0).setSaved(true);
		healthAttribute.removeModifier(moras);
		healthAttribute.applyModifier(moras);
	  }
				
}

