package fr.redmine.redmod.command;

import fr.redmine.redmod.utils.utils;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandClearInventory;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import fr.redmine.redmod.utils.utils;

public class sethealthCommand extends CommandBase {
	@Override
	public String getCommandName()
	{
		return "setHealth";
	}
	
	@Override
	public String getCommandUsage(ICommandSender icommandsender) 
	{
		return "/sethealth <player> <health>";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
	
	if(args.length == 2)
	{		if(args[0] != null && args[1] != null) {
			System.out.println(utils.getPlayer(args[0]));
				if(utils.getPlayer(args[0]) != null) {
					System.out.println("truc");
					int health = Integer.valueOf(args[1]);
					EntityPlayer player = utils.getPlayer(args[0]);
					
					utils.setEntityHealth(player, health);
				
					return; 
				}
		
			} 
	}	
	sender.addChatMessage(new ChatComponentText(getCommandUsage(sender)));
	
	
	}
}
