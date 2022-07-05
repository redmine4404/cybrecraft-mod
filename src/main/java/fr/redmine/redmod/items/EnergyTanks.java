package fr.redmine.redmod.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import scala.reflect.internal.Trees.This;

public class EnergyTanks extends Item {
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List lores, boolean b)
	{
	    if (stack.hasTagCompound() && stack.getTagCompound().hasKey("Energy"))
	    {
	        lores.add(Integer.toString(stack.getTagCompound().getInteger("Energy")) + "/5000");
	    }
	}
	
	@Override
	 public boolean showDurabilityBar(ItemStack stack)
    {
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("Energy")) {
        return stack.getTagCompound().getInteger("Energy")!= 4999;
		} else {
			return false;
			}
    }
	
 /**	public static void setEnergy(int energy, ItemStack stack) {
		stack.setItemDamage(energy + 1);
		NBTTagCompound nbt = stack.getTagCompound();
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("Energy")) {
			nbt.setInteger("Energy", energy);
		}
		stack.setTagCompound(nbt);
	}
	
	public static int getEnergy(ItemStack stack) {
		if(stack.hasTagCompound() && stack.getTagCompound().hasKey("Energy")) {
			return stack.getTagCompound().getInteger("energy");
		} else {
			return 0;
		}
	} **/
	
}
