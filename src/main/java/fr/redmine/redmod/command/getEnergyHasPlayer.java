package fr.redmine.redmod.command;

import java.awt.print.PrinterGraphics;

import fr.redmine.redmod.items.EnergyTanks;
import fr.redmine.redmod.utils.TanksUtils;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;

public class getEnergyHasPlayer extends CommandBase{

	@Override
	public String getCommandName() {
		return "getEnergy";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "test";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
			if(sender instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) sender;
				if(args.length == 0) {
					sender.addChatMessage(new ChatComponentText(String.valueOf(TanksUtils.whatenrgyhasplayer(player))));
				}else {
					sender.addChatMessage(new ChatComponentText("invalid argument"));
				}
			}else {
				sender.addChatMessage(new ChatComponentText("commend can't be send with the console"));
			}
		}
	}