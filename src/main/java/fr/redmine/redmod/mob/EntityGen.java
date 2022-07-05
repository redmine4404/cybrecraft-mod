package fr.redmine.redmod.mob;

import akka.Main;
import cpw.mods.fml.common.registry.EntityRegistry;
import fr.redmine.redmod.redmod;
import fr.redmine.redmod.mob.monster.Entitybob;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

public class EntityGen {
	public static void mainRegistry() {
		registerEntity();
	}
	
	public static void registerEntity() {
	createEntity(Entitybob.class, "bob mob", 0x08d2ff, 0x0856ff, EnumCreatureType.monster);
	}
	
	public static void createEntity(Class entityClass, String entityName, int solidColor, int spotColor, EnumCreatureType type) {
		int randomId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, redmod.instance, 64, 1, true);
		EntityRegistry.addSpawn(entityClass, 2, 0, 10, type, BiomeGenBase.plains);
		
		createEgg(randomId, solidColor, spotColor);
	}

	private static void createEgg(int randomId, int solidColor, int spotColor) {
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, solidColor, spotColor));
		
	}
}
