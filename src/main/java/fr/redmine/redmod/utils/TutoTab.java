package fr.redmine.redmod.utils;

import fr.redmine.redmod.init.RegisterItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class TutoTab extends CreativeTabs {


    public TutoTab(String l) {
        super(l);
    }
        @Override
        public Item getTabIconItem(){
            return RegisterItems.redminite;
        }


}
