package fr.redmine.redmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RegisterRecipe {
	public static void init(){
        GameRegistry.addRecipe(new ItemStack(RegisterBlock.SmelterBlockEmpty, 1), new Object[] {"RGR","G#G","RGR", '#', Items.bucket, 'G', Item.getItemFromBlock(Blocks.glass), 'R', RegisterItems.redminite});
        GameRegistry.addRecipe(new ItemStack(RegisterItems.redminite_pickaxe, 1), new Object[] {"RRR"," S "," S ", 'S', Items.stick, 'R', RegisterItems.redminite});
        GameRegistry.addSmelting(RegisterBlock.Redminite_ore, new ItemStack(RegisterItems.redminite), 5);
        GameRegistry.addRecipe(new ItemStack(RegisterItems.hearth, 1), new Object[] {"rRr","RrR","rRr", 'R', Items.rotten_flesh, 'r', RegisterItems.redminite});
        GameRegistry.addRecipe(new ItemStack(RegisterItems.hammer_upgrade, 1), new Object[] {"ROR","OIO","ROR", 'I', Items.iron_pickaxe, 'R', RegisterItems.redminite, 'O', Blocks.planks});
        GameRegistry.addSmelting(RegisterItems.SheepMeat, new ItemStack(RegisterItems.CookedSheapMeat), 5);
        GameRegistry.addShapelessRecipe(new ItemStack(RegisterItems.TomatoSeed, 1), new Object[]{ new ItemStack(RegisterItems.Tomato)});

	}
}