package fr.redmine.redmod.items;

import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

public class item_pickaxe extends ItemPickaxe{

	public item_pickaxe(ToolMaterial material) {
		super(material);
	}
	  public boolean onBlockDestroyed(ItemStack stack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
	        if(entity instanceof EntityPlayer) {
	        stack.damageItem(1, entity);
    
	        }
			return true;
	  }
	  
}
