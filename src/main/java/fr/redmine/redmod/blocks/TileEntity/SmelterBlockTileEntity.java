package fr.redmine.redmod.blocks.TileEntity;

import cpw.mods.fml.common.registry.GameRegistry.ObjectHolder;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.redmine.redmod.init.RegisterItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SmelterBlockTileEntity extends TileEntity{
	
	Item item1;
	Item item2;
	EntityItem itementity1;
	EntityItem itementity2;
//	Item item;
	
	@Override
    public void readFromNBT(NBTTagCompound compound)
    {
		item1 = item1.getItemById(compound.getInteger("Item1") - 1);
		item2 = item1.getItemById(compound.getInteger("Item2") - 1);
        super.readFromNBT(compound);
    }
 
    @Override
    public void writeToNBT(NBTTagCompound compound)
    {
    	if(item1 != null) {
        compound.setInteger("Item1", item1.getIdFromItem(item1) + 1);
    	}
    	if(item2 != null) {
        compound.setInteger("Item2", item1.getIdFromItem(item2) + 1);
    	}
    	super.writeToNBT(compound);
    }
    
    public void setItem1(Item item) {
    	item1 = item;
		System.out.println("truc");
    }
    
    public void setItem2(Item item) {
    	item2 = item;
		System.out.println("truc");
    }
    
    public Item getItemStack1() {
    	if(item1 != null) {
    	return item1;
    	} else return null;
    }
    
    public Item getItemStack2() {
    	if(item2 != null) {
    	return item2;
    	} else return null;
    }
    
    public void Smelt(Item item) {
    	EntityItem entityitem = new EntityItem(this.worldObj, this.xCoord, this.yCoord, this.zCoord, new ItemStack(item));
    	this.worldObj.spawnEntityInWorld(entityitem);
    	item1 = null;
    	item2 = null;
    	itementity1.setDead();
    }
    
    public void onDead() {
    	if(itementity1 != null) {
    	itementity1.setDead();
    	}
    	if(item1 != null) {
    	EntityItem entityitem1 = new EntityItem(this.worldObj, this.xCoord, this.yCoord, this.zCoord, new ItemStack(item1));
    	this.worldObj.spawnEntityInWorld(entityitem1);
    	}
    	if(item2 != null) {
    	EntityItem entityitem2 = new EntityItem(this.worldObj, this.xCoord, this.yCoord, this.zCoord, new ItemStack(item2));
    	this.worldObj.spawnEntityInWorld(entityitem2);
    	}
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void updateEntity() {
   // 	System.out.println(item1);
    	if(!this.worldObj.isRemote)
    	if(item1 != null) {
    		if(itementity1 == null|| itementity1.getEntityItem().getItem() != item1) {
    		itementity1 = new EntityItem(this.worldObj, this.xCoord + 0.5, this.yCoord + 1, this.zCoord + 0.5, new ItemStack(item1));
    		itementity1.motionX = 0.0D;
    		itementity1.motionY = 0.0D;
    		itementity1.motionZ = 0.0D;
    		itementity1.delayBeforeCanPickup = 1000000000;   
    		this.worldObj.spawnEntityInWorld(itementity1);
    		itementity1.delayBeforeCanPickup = 1000000000;   
    		}
    		itementity1.posX = this.xCoord + 0.5;
    		itementity1.posY = this.yCoord + 1;
    		itementity1.posZ = this.zCoord + 0.5;
    		itementity1.motionX = 0.0D;
    		itementity1.motionY = 0.0D;
    		itementity1.motionZ = 0.0D;
    		itementity1.delayBeforeCanPickup = 1000000000;   		
    		// System.out.println("julien a une tete de piou");
   // 		entity.motionX = entity.motionZ = entity.motionY = 0.0D;
    		//item1 = null;
    		if(item2 != null) {
    			switch(item1.getIdFromItem(item1)) {
    			case 310:
    			if(item2 == RegisterItems.CompressedIronIngot) {
    				Smelt(RegisterItems.CompressedIronHelmet);
    				break;
    				}
    			case 311:
        			if(item2 == RegisterItems.CompressedIronIngot) {
        				Smelt(RegisterItems.CompressedIronChestPlate);
        				break;
        				}
    			case 312:
        			if(item2 == RegisterItems.CompressedIronIngot) {
        				Smelt(RegisterItems.CompressedIronLeggings);
        				break;
        				}
    			case 313:
        			if(item2 == RegisterItems.CompressedIronIngot) {
        				Smelt(RegisterItems.CompressedIronBoots);
        				break;
        				}
    			default : 
    				//	item1 = null;
    				//	item2 = null;
    				itementity1.setDead();
    				EntityItem entityitem = new EntityItem(this.worldObj, this.xCoord, this.yCoord, this.zCoord, new ItemStack(item1));
    		    	this.worldObj.spawnEntityInWorld(entityitem);
    		    	EntityItem entityitem2 = new EntityItem(this.worldObj, this.xCoord, this.yCoord, this.zCoord, new ItemStack(item2));
    		    	this.worldObj.spawnEntityInWorld(entityitem2);
    		    	item1 = null;
    				item2 = null;
    		    	break;
    			}
    		}
    	}
    	
    }
    
}