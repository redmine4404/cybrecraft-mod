package fr.redmine.redmod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTransluid extends Block {

    public BlockTransluid(Material p_i45394_1_) {
        super(p_i45394_1_);
    }
    public boolean isOpaqueCube()
    {
        return false;
    }

}
