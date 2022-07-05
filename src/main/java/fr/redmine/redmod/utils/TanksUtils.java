package fr.redmine.redmod.utils;

import java.awt.List;

import fr.redmine.redmod.init.RegisterItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TanksUtils {
public static int whatenrgyhasplayer(EntityPlayer player) {
	int energy = 0;
	InventoryPlayer inventory = player.inventory;
	
	
	for(int i = 0; i < inventory.getSizeInventory(); i++) {
		ItemStack item = inventory.getStackInSlot(i);
		if(item != null && item.getItem() == RegisterItems.EnergyTanks) {
			energy += whatenergyhasthanks(item);
		}
	}
	return energy;
}

	public static int whatenergyhasthanks(ItemStack item) {
		int energy = 0;
		
		if (item.hasTagCompound() && item.getTagCompound().hasKey("Energy")) {
	        energy = item.getTagCompound().getInteger("Energy");
			} 
		return energy;
		}
	
}
