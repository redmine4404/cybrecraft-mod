package fr.redmine.redmod.blocks;

import java.util.Random;

import fr.redmine.redmod.blocks.TileEntity.SmelterBlockTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SmelterBlocks extends BlocksBase{

	public SmelterBlocks(Material material) {
		super(material);
	}
	
	@Override
    public TileEntity createTileEntity(World world, int metadata)
    {
        return new SmelterBlockTileEntity();
    }
 
    @Override
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }
    
    @Override
    public void breakBlock(World world, int x, int y, int z, Block block, int meta)
    {
      SmelterBlockTileEntity tile = (SmelterBlockTileEntity) world.getTileEntity(x, y, z);
      tile.onDead();
    }
   

}
