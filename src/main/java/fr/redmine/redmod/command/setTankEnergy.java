package fr.redmine.redmod.command;

import java.awt.print.PrinterGraphics;

import fr.redmine.redmod.items.EnergyTanks;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;

public class setTankEnergy extends CommandBase{

	@Override
	public String getCommandName() {
		return "setTankEnergy";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "this command set the energy in tank";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		if(sender instanceof EntityPlayer) {
		EntityPlayer player = (EntityPlayer) sender;
		ItemStack item = player.getCurrentEquippedItem();
			if(!item.hasTagCompound()) {
				NBTTagCompound nbt = new NBTTagCompound();
				item.setTagCompound(nbt);
			}
			if(item.getItem() instanceof EnergyTanks) {
				if(args.length == 1) {
				NBTTagCompound nbt = item.getTagCompound();
				nbt.setInteger("Energy", Integer.valueOf(args[0]));
				item.setTagCompound(nbt);
				item.setItemDamage(5000 - Integer.valueOf(args[0]));
				} else {
					player.addChatMessage(new ChatComponentText("argument invalide"));
				}
			} else {
				player.addChatMessage(new ChatComponentText("cet item est invalide"));
			}
		}
	}

}
