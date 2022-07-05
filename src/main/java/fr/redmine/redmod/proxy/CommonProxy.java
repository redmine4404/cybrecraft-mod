package fr.redmine.redmod.proxy;

import cpw.mods.fml.common.network.NetworkRegistry;
import fr.redmine.redmod.redmod;
import fr.redmine.redmod.gui.GuiHandler;

public class CommonProxy {

    public void registerRenders() {

    }
    
    public int addArmor(String armor) {
    	return 0;
    }
    
    public void registerNetworkStuff() {
    	NetworkRegistry.INSTANCE.registerGuiHandler(redmod.instance, new GuiHandler());
    }
}
