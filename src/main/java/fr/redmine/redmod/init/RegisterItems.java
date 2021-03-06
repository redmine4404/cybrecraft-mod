package fr.redmine.redmod.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.redmine.redmod.redmod;
import fr.redmine.redmod.items.item_sword;
import fr.redmine.redmod.utils.Reference;
import fr.redmine.redmod.utils.TutoTab;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;
import scala.tools.nsc.backend.icode.TypeKinds.REFERENCE;
import fr.redmine.redmod.items.redminite_bucket;
import fr.redmine.redmod.items.redmod_hammer;
import fr.redmine.redmod.items.EnergyTanks;
import fr.redmine.redmod.items.ItemCompressedIronArmor;
import fr.redmine.redmod.items.MagicStick;
import fr.redmine.redmod.items.Sandwitch;
import fr.redmine.redmod.items.SheepMeat;
import fr.redmine.redmod.items.item_axe;
import fr.redmine.redmod.items.item_pickaxe;
import fr.redmine.redmod.items.item_shovel;

public class RegisterItems {
	
	public static ToolMaterial RedminiteMaterial = EnumHelper.addToolMaterial("redminite", 5, 3000, 10, 3, 22);
	public static ToolMaterial CompressedIronTools = EnumHelper.addToolMaterial("CompressedIron", 5, 4000, 12, 5, 10);
	public static ToolMaterial RedminiteHammer = EnumHelper.addToolMaterial("RedminitHammer", 1, 1500, 2.0F, 0.0F, 10);
	public static ArmorMaterial CompressedIronMaterials = EnumHelper.addArmorMaterial("compressedIron", 20, new int[]{4, 9, 7, 4}, 5);
	public static Item truc, redminite, redminite_sword, redminite_pickaxe, hammer_upgrade, redminite_hammer, hearth, cpu, SheepMeat, CookedSheapMeat, CompressedIronIngot, magicStick, CompressedIronPickaxe, CompressedIronSword, CompressedIronShovel, CompressedIronAxe;
    public static Item CompressedIronHelmet, CompressedIronChestPlate, CompressedIronLeggings, CompressedIronBoots, creative_boot; 
    public static Item EnergyTanks;
    public static Item TomatoSandwitch, SaladSandwitch;
    public static Item Tomato, TomatoSeed;
    
    /* initialisation des item */
   public static void init() {
       truc = new Item().setUnlocalizedName("TrucItem").setCreativeTab(redmod.trucTabs).setTextureName(Reference.MOD_ID + ":truc");
       redminite = new Item().setUnlocalizedName("Redminite").setCreativeTab(redmod.trucTabs).setTextureName(Reference.MOD_ID + ":redminite");
       redminite_sword = new item_sword(RedminiteMaterial).setTextureName(Reference.MOD_ID + ":redminite_sword").setCreativeTab(redmod.trucTabs).setUnlocalizedName("redminite_sword");
       redminite_pickaxe = new item_pickaxe(RedminiteMaterial).setTextureName(Reference.MOD_ID + ":redminite_pickaxe").setCreativeTab(redmod.trucTabs).setUnlocalizedName("redminite_pickaxe").setMaxDamage(3300);
       hammer_upgrade = new Item().setUnlocalizedName("hammer_upgrade").setTextureName(Reference.MOD_ID + ":hammer_upgrade").setCreativeTab(redmod.trucTabs);
       redminite_hammer = new redmod_hammer(RedminiteHammer).setUnlocalizedName("redminite_hammer").setCreativeTab(redmod.trucTabs).setMaxDamage(2000).setTextureName(Reference.MOD_ID + ":RedminiteHammer");
       hearth = new Item().setUnlocalizedName("hearth").setTextureName(Reference.MOD_ID + ":hearth").setCreativeTab(redmod.trucTabs);
       cpu = new Item().setUnlocalizedName("cpu").setTextureName(Reference.MOD_ID + ":cpu").setCreativeTab(redmod.trucTabs);
       SheepMeat = new SheepMeat(3, 2, false).setUnlocalizedName("SheepMeat").setTextureName(Reference.MOD_ID + ":SheepMeat").setCreativeTab(redmod.trucTabs);
       CookedSheapMeat = new SheepMeat(5, 5, false).setUnlocalizedName("CookedSheepMeat").setTextureName(Reference.MOD_ID + ":CookedSheepMeat").setCreativeTab(redmod.trucTabs);
       magicStick = new MagicStick().setCreativeTab(redmod.trucTabs).setUnlocalizedName("MagicStick").setUnlocalizedName(Reference.MOD_ID + ":MackStick");
       
       EnergyTanks = new EnergyTanks().setMaxDamage(5000).setMaxStackSize(1).setUnlocalizedName("Tanks").setCreativeTab(redmod.trucTabs).setCreativeTab(redmod.trucTabs);
       CompressedIronPickaxe = new item_pickaxe(CompressedIronTools).setUnlocalizedName("CompressIronPickaxe").setTextureName(Reference.MOD_ID + ":CompressedIronPickaxe").setMaxStackSize(1).setCreativeTab(redmod.trucTabs);
       CompressedIronSword = new item_sword(CompressedIronTools).setUnlocalizedName("CompressedIronSword").setTextureName(Reference.MOD_ID + ":CompressedIronSword").setCreativeTab(redmod.trucTabs).setMaxStackSize(1);
       CompressedIronShovel = new item_shovel(CompressedIronTools).setUnlocalizedName("CompressedIronShovel").setTextureName(Reference.MOD_ID + ":CompressedIronShovel").setCreativeTab(redmod.trucTabs).setMaxStackSize(1);
       CompressedIronAxe = new item_axe(CompressedIronTools).setUnlocalizedName("CompressedIronAxe").setTextureName(Reference.MOD_ID + ":CompressedIronAxe").setCreativeTab(redmod.trucTabs).setMaxStackSize(1);
       
       CompressedIronHelmet = new ItemCompressedIronArmor(CompressedIronMaterials, 1, 0).setUnlocalizedName("CompressIronHelmet").setCreativeTab(redmod.trucTabs).setTextureName(Reference.MOD_ID + ":CompressIronHelmet");
       CompressedIronChestPlate = new ItemCompressedIronArmor(CompressedIronMaterials, 1, 1).setUnlocalizedName("CompressIronChestplate").setCreativeTab(redmod.trucTabs).setTextureName(Reference.MOD_ID + ":CompressIronChestplate");
       CompressedIronLeggings = new ItemCompressedIronArmor(CompressedIronMaterials, 1, 2).setUnlocalizedName("CompressIronLegging").setCreativeTab(redmod.trucTabs).setTextureName(Reference.MOD_ID + ":CompressIronLegging");
       CompressedIronBoots = new ItemCompressedIronArmor(CompressedIronMaterials, 1, 3).setUnlocalizedName("CompressIronBoot").setCreativeTab(redmod.trucTabs).setTextureName(Reference.MOD_ID + ":CompressIronBoot");
       
       CompressedIronIngot = new Item().setUnlocalizedName("CompressedIronIngot").setCreativeTab(redmod.trucTabs).setTextureName(Reference.MOD_ID + ":CompressedIronIngot");
      // creative_boot = new 
       
       TomatoSandwitch = new Sandwitch(10, 5, false, new PotionEffect(Potion.regeneration.id, 500, 3)).setUnlocalizedName("TomatoSandwitch").setCreativeTab(redmod.trucTabs).setTextureName(Reference.MOD_ID  + ":TomatoSandwitch");

       Tomato = new fr.redmine.redmod.items.Tomato().setUnlocalizedName("Tomato").setCreativeTab(redmod.trucTabs).setTextureName(Reference.MOD_ID + ":Tomato");
       TomatoSeed = new fr.redmine.redmod.items.TomatoSeed(RegisterBlock.tomato, Blocks.farmland).setUnlocalizedName("TomatoSeed").setCreativeTab(redmod.trucTabs).setTextureName(Reference.MOD_ID + "TomatoSeed");
   }

   public static void register(){

       GameRegistry.registerItem(truc,"truc");
       GameRegistry.registerItem(redminite, "redminite");
       GameRegistry.registerItem(redminite_sword, "redminite_sword");
       GameRegistry.registerItem(redminite_pickaxe, "redminite_pickaxe");
       GameRegistry.registerItem(hammer_upgrade, "hammer_upgrade");
       GameRegistry.registerItem(redminite_hammer, "redminite hammer");
       GameRegistry.registerItem(hearth, "hearth");
       GameRegistry.registerItem(cpu, "cpu");
       GameRegistry.registerItem(SheepMeat, "SheapMeat");
       GameRegistry.registerItem(CookedSheapMeat, "CookedSheapMeat");
       GameRegistry.registerItem(magicStick, "MagicStick");
       GameRegistry.registerItem(EnergyTanks, "EnergyTanks");
       GameRegistry.registerItem(CompressedIronIngot, "CompressedIronIngot");
       
       GameRegistry.registerItem(CompressedIronBoots, "CompresIronBoot");
       GameRegistry.registerItem(CompressedIronChestPlate, CompressedIronChestPlate.getUnlocalizedName().substring(5));
       GameRegistry.registerItem(CompressedIronLeggings, "CompressLegging");
       GameRegistry.registerItem(CompressedIronHelmet, "CompressHelmet");
       
       GameRegistry.registerItem(CompressedIronPickaxe, "CompresseIronPickaxe");
       GameRegistry.registerItem(CompressedIronSword, "CompresseIronSword");
       GameRegistry.registerItem(CompressedIronShovel, "CompressedIronShovel");
       GameRegistry.registerItem(CompressedIronAxe, "CompressedIronAxe");
       
       GameRegistry.registerItem(TomatoSandwitch, "TomatoSandwitch");
       
       GameRegistry.registerItem(Tomato, "Tomato");
       GameRegistry.registerItem(TomatoSeed, "TomatoSeed");
   }
}