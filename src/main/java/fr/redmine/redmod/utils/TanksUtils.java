package fr.redmine.redmod.utils;

import java.awt.List;

import fr.redmine.redmod.command.setTankEnergy;
import fr.redmine.redmod.init.RegisterItems;
import fr.redmine.redmod.items.EnergyTanks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEmptyMap;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;

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
	
	public static void setEnregyHasTank(ItemStack item, int energy){
		if(item.getItem() instanceof EnergyTanks) {
		if(!item.hasTagCompound()) {
			NBTTagCompound nbt = new NBTTagCompound();
			item.setTagCompound(nbt);
		}
			NBTTagCompound nbt = item.getTagCompound();
			nbt.setInteger("Energy", Integer.valueOf(energy));
			item.setTagCompound(nbt);
			item.setItemDamage(5000 - Integer.valueOf(energy));

		}
	}
	
	public static void addEnergy(int energy, EntityPlayer player){
	InventoryPlayer inv	= player.inventory;
		ItemStack[] tank = new ItemStack[36];
		int lenght = 0;
		
		for(int i = 1; i < 35; i++){
			System.out.println(i);
			ItemStack item = inv.mainInventory[i];
			if(item != null && item.getItem() == RegisterItems.EnergyTanks){
			tank[lenght] = item;
			lenght++;
			}
		}
		
		System.out.print(tank);
		
		boolean cont = true;
		int l = 0;
		while(cont){
			if(tank[l] != null &&  tank[l].getItem() == RegisterItems.EnergyTanks){
				ItemStack item = tank[l];
				
				boolean cont1 = true;
				while(cont1){
					if(whatenergyhasthanks(item) != 5000){
						setEnregyHasTank(item, whatenergyhasthanks(item) + 1);
						energy--;
					} else {
						cont1 = false;
					}
					if(energy == 0){
						cont1 = false;
						cont = false;
					}
				}
			} else {
				cont = false;
			}
			l++;
		}
		
	}
	
}
