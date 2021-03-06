package fr.redmine.redmod.blocks.crops;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.redmine.redmod.blocks.Crops;
import fr.redmine.redmod.init.RegisterItems;
import fr.redmine.redmod.utils.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class TomatoCrops extends Crops{


	    public TomatoCrops()
	    {
	        // Basic block setup
	        setBlockName("TomatoCrops");
	        setBlockTextureName(Reference.MOD_ID + ":tomato0");
	    }

	    /**
	     * Returns the quantity of items to drop on block destruction.
	     */
	    @Override
	    public int quantityDropped(int parMetadata, int parFortune, Random parRand)
	    {
	        return (parMetadata/2);
	    }

	    @Override
	    public Item getItemDropped(int parMetadata, Random parRand, int parFortune)  
	    {
	     // DEBUG
	     //System.out.println("BlockBlueberry getItemDropped()");
	        return (RegisterItems.Tomato);
	    }
	    
	    @Override
	    @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister parIIconRegister)
	    {
	          iIcon = new IIcon[maxGrowthStage+1];
	          // seems that crops like to have 8 growth icons, but okay to repeat actual texture if you want
	          // to make generic should loop to maxGrowthStage
	          iIcon[0] = parIIconRegister.registerIcon(Reference.MOD_ID + ":TestCrops1");
	          iIcon[1] = parIIconRegister.registerIcon(Reference.MOD_ID + ":TestCrops2");
	          iIcon[2] = parIIconRegister.registerIcon(Reference.MOD_ID + ":TestCrops3");
	          iIcon[3] = parIIconRegister.registerIcon(Reference.MOD_ID + ":TestCrops4");
	          iIcon[4] = parIIconRegister.registerIcon(Reference.MOD_ID + ":TestCrops5");
	          iIcon[5] = parIIconRegister.registerIcon(Reference.MOD_ID + ":TestCrops6");
	          iIcon[6] = parIIconRegister.registerIcon(Reference.MOD_ID + ":TestCrops7");
	    }
}
