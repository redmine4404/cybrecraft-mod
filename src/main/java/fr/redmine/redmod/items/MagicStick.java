package fr.redmine.redmod.items;

import fr.redmine.redmod.redmod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MagicStick extends Item{
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
		player.openGui(redmod.instance, 0, world, player.serverPosX, player.serverPosY, player.serverPosZ);
        return item;
    }

}
