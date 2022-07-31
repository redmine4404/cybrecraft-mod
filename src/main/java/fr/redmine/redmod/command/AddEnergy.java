package fr.redmine.redmod.command;

import fr.redmine.redmod.utils.TanksUtils;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;

public class AddEnergy extends CommandBase{

	@Override
	public String getCommandName() {
		return "addEnergy";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "this command is for test";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		if(sender instanceof EntityPlayer){
			if(args.length == 1){
			TanksUtils.addEnergy(Integer.valueOf(args[0]), (EntityPlayer) sender);
			} else {
				sender.addChatMessage(new ChatComponentText("invalid argument"));
			}
		} else {
			sender.addChatMessage(new ChatComponentText("this command is only for a player"));
		}
	}

}
