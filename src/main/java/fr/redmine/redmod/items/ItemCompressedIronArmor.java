package fr.redmine.redmod.items;

import fr.redmine.redmod.init.RegisterItems;
import fr.redmine.redmod.utils.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ItemCompressedIronArmor extends ItemArmor {

	public ItemCompressedIronArmor( ArmorMaterial materials, int layer, int type) {
		super( materials, layer, type);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
	    if(stack.getItem() == RegisterItems.CompressedIronLeggings)
	    {
	        return Reference.MOD_ID + ":textures/armor/compressiron_layer_2.png";
	    }
	    else
	    {
	        return Reference.MOD_ID +  ":textures/armor/compressiron_layer_1.png";
	    }
	}
}
