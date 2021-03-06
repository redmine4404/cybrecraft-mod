package fr.redmine.redmod.event;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.redmine.redmod.redmod;
import fr.redmine.redmod.gui.GuiCustomMainMenu;
import fr.redmine.redmod.init.RegisterBlock;
import fr.redmine.redmod.init.RegisterItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EventVannila {

	 private static final Logger logger = LogManager.getLogger();
	 
	
	static World world = null;
	 
	public static World getWorld() {
		return world;
		
	}
	
	@SideOnly(Side.SERVER)
	@SubscribeEvent
		public void onTickArmor(TickEvent.PlayerTickEvent e){
	//	System.out.println("truc");
			List playerlist = e.player.worldObj.playerEntities;
			for(int i1 = 0; i1 <= playerlist.size() - 1; i1++) {
		 		EntityPlayer player = e.player;
		 		double helmetLowest = 0;
		 		double chestplateLowest = 0;
		 		double leggingsLowest = 0;
		 		double bootLowest = 0;
		 		
		 		double total = 0;
		// 		System.out.println("truc");
		 		
		 		ItemStack[] inv = player.inventory.armorInventory;
		 		
		 		if(inv[0] != null && inv[0].getItem() == RegisterItems.CompressedIronBoots) {
		 			bootLowest = 0.004;
		 		} else {
		 			bootLowest = 0;
		 		}
		 		
		 		if(inv[1] != null && inv[1].getItem() == RegisterItems.CompressedIronLeggings) {	
		 			leggingsLowest = 0.005;
		 		} else {
		 			leggingsLowest = 0;
		 		}	
		 			
		 		if(inv[2] != null && inv[2].getItem() == RegisterItems.CompressedIronChestPlate) {
		 			chestplateLowest = 0.006;
		 		} else {
		 			chestplateLowest = 0;
		 		}
		 		
		 		if(inv[3] != null && inv[3].getItem() == RegisterItems.CompressedIronHelmet) {	
		 			helmetLowest = 0.004;
		 		} else {
		 			helmetLowest = 0;
		 		}
		 		

		 		total = helmetLowest + chestplateLowest + leggingsLowest + bootLowest;
		 //		System.out.println(total);
		 	//	final AttributeModifier SPEED_BONUS = new AttributeModifier("speed armor" ,bootLowest + leggingsLowest + chestplateLowest + helmetLowest);
		 		
		 		

			//	AttributeModifier moras = new AttributeModifier("Speed Boost", -total , 0);
			//	AttributeModifier moras2 = new AttributeModifier("Speed Boost", 0.001, 0);
				//System.out.println(player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getModifier(moras.getID())+ "       " + total);
				// player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).removeAllModifiers();
				player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(player.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue() - total);;
		//	}
		
			}
		}
  }