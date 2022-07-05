package fr.redmine.redmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class Sandwitch extends ItemFood{

	PotionEffect potion;
	
	public Sandwitch(int var, int saturation, boolean bool, PotionEffect potion1) {
		super(var, saturation, bool);
		potion = potion1;
	}
	
	@Override
	 protected void onFoodEaten(ItemStack itemstack, World world, EntityPlayer player)
    {
        player.addPotionEffect(potion);
    }

}
