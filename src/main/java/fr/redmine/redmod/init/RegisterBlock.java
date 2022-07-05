package fr.redmine.redmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.redmine.redmod.redmod;
import fr.redmine.redmod.blocks.BlockTransluid;
import fr.redmine.redmod.blocks.BlocksBase;
import fr.redmine.redmod.blocks.SmelterBlocks;
import fr.redmine.redmod.blocks.TileEntity.SmelterBlockTileEntity;
import fr.redmine.redmod.blocks.crops.TomatoCrops;
import fr.redmine.redmod.items.redminite_bucket;
import fr.redmine.redmod.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


public class RegisterBlock {

    public static Block SmelterBlock, SmelterBlockEmpty, Redminite_ore, sandwith_machine, tomato;

    public static void init(){

        SmelterBlock = new SmelterBlocks(Material.anvil).setBlockName("SmelterBlock").setCreativeTab(redmod.trucTabs).setBlockTextureName(Reference.MOD_ID + ":SmelterBlock").setLightLevel(8).setHardness(5);
        SmelterBlockEmpty = new BlockTransluid(Material.anvil).setBlockName("SmelterBlockEmpty").setCreativeTab(redmod.trucTabs).setBlockTextureName(Reference.MOD_ID + ":SmelterBlockEmpty").setHardness(3);
        Redminite_ore = new BlocksBase(Material.iron).setBlockName("RedminiteOre").setCreativeTab(redmod.trucTabs).setBlockTextureName(Reference.MOD_ID + ":RedminiteOre").setHardness(5);
        sandwith_machine = new BlocksBase(Material.iron).setBlockName("SandwitchMachine").setCreativeTab(redmod.trucTabs).setBlockTextureName(Reference.MOD_ID + ":SandwitchMachine").setHardness(5);
        tomato = new TomatoCrops().setBlockName("TomatoCrops").setCreativeTab(redmod.trucTabs).setBlockTextureName(Reference.MOD_ID + ":Tomatocrps");
    }

    /**
     * register block
     */
    public static void register(){
        GameRegistry.registerBlock(SmelterBlock ,	SmelterBlock.getLocalizedName().substring(5));
        GameRegistry.registerBlock(SmelterBlockEmpty, SmelterBlockEmpty.getLocalizedName().substring(5));
        GameRegistry.registerBlock(Redminite_ore , Redminite_ore.getLocalizedName().substring(5));
        //System.out.println(Redminite_ore.getIdFromBlock(Redminite_ore));
        GameRegistry.registerTileEntity(SmelterBlockTileEntity.class, Reference.MOD_ID + ":SmelterBlocksTileEntity");
        GameRegistry.registerBlock(tomato, tomato.getUnlocalizedName().substring(5));
    }
}

