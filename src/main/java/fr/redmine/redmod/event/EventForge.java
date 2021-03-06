package fr.redmine.redmod.event;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

import java.util.List;

import javax.tools.DocumentationTool.Location;

import org.lwjgl.Sys;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.redmine.redmod.blocks.TileEntity.SmelterBlockTileEntity;
import fr.redmine.redmod.init.RegisterBlock;
import fr.redmine.redmod.init.RegisterItems;
import fr.redmine.redmod.mob.monster.Entitybob;
import fr.redmine.redmod.utils.utils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.event.world.ChunkEvent;


public class EventForge {
	  @SubscribeEvent
	  public void onInteract(PlayerInteractEvent event){
		  Action action = event.action;
		  ItemStack currentItem = event.entityPlayer.inventory.getCurrentItem();
		  int x = event.x;
		  int y = event.y;
		  int z = event.z;
		  World world = event.world;
		  EntityPlayer player = event.entityPlayer;
		  
		//	System.out.println(player.inventory.getCurrentItem().canEditBlocks());
		  
		  if(action == event.action.RIGHT_CLICK_BLOCK){
			  	if(player.inventory.getCurrentItem() != null && currentItem.getItem() == Items.lava_bucket && world.getBlock(x, y, z) == RegisterBlock.SmelterBlockEmpty){
			  		if(!player.capabilities.isCreativeMode){
			  		currentItem.stackSize--;
			  		player.inventory.addItemStackToInventory(new ItemStack(Items.bucket));
			  		}
			  		event.world.setBlock(x, y, z, RegisterBlock.SmelterBlock);
			  	}
			  	if(player.inventory.getCurrentItem() != null && world.getBlock(x, y, z) == RegisterBlock.SmelterBlock && player.inventory.getCurrentItem().getItem()  instanceof ItemBlock == false) {
			  		
			  		SmelterBlockTileEntity tile = (SmelterBlockTileEntity) world.getTileEntity(x, y, z);
			  		//System.out.println(tile.getItemStack1());
			  		System.out.println();
			  		if(tile.getItemStack1() == null) {
			  	System.out.println("truc");
			  			tile.setItem1(player.getCurrentEquippedItem().getItem());
			  		
			  		} else if (tile.getItemStack2() == null) {
			  			tile.setItem2(player.getCurrentEquippedItem().getItem());
			  		}
			  		player.inventory.getCurrentItem().stackSize--;
			  	}
		  	}
		  if(action == action.RIGHT_CLICK_BLOCK || action == action.RIGHT_CLICK_AIR) {
			  if(player.inventory.getCurrentItem() != null && currentItem.getItem() == RegisterItems.hearth){
				  
				  if(player.getMaxHealth() <= 41) {
				
				  utils.setEntityHealth(player, (int) (player.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue() - 18));
				  currentItem.stackSize--;
				  return;
				  }
			  }
		  }
	 }
	  
	  @SubscribeEvent
	  public void onEntityDead(LivingDropsEvent e) {
		  Entity entity = e.entityLiving;
		  World world = entity.worldObj;
		  double x = entity.posX;
		  double y = entity.posY;
		  double z = entity.posZ;
		//  System.out.println(entity);
		if(entity instanceof EntityLiving) {
		  if(entity instanceof Entitybob) {
			  
			 e.drops.add( new EntityItem(world, x, y, z, new ItemStack(RegisterItems.cpu)));
		  }
		  
		  if(entity instanceof EntitySheep) {
			  e.drops.add( new EntityItem(world, x, y, z, new ItemStack(RegisterItems.SheepMeat)));
		  }
		}
	  }

	//  @SubscribeEvent
	  public void onChunkLoaded(ChunkEvent.Load e) {
		  Chunk chunk = e.getChunk();
		  List[] list = chunk.entityLists;
		 for(int i = 0; i < list.length; i++) {
			List entitylist = list[i];
	//		System.out.println(list.length);
			for(int l = 0; l < entitylist.size(); l++) {
				Entity entity = (Entity) entitylist.get(l);
			//	System.out.println(entity);
				if(entity instanceof EntityItem) {
				entity.setDead();
				}
			}
		 }
	  }
	}
