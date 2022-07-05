package fr.redmine.redmod.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import fr.redmine.redmod.mob.model.ModelBob;
import fr.redmine.redmod.mob.monster.Entitybob;
import fr.redmine.redmod.mob.render.RenderMobBob;
import net.minecraftforge.common.MinecraftForge;
import fr.redmine.redmod.proxy.CommonProxy;
public class ClientProxy extends CommonProxy {

	
    @Override
    public void registerRenders() {
    	System.out.println("Client Proxy eneable");
    	RenderingRegistry.registerEntityRenderingHandler(Entitybob.class, new RenderMobBob(new ModelBob(), 2));
    	
    	
    	MinecraftForge.EVENT_BUS.register(this);
    }
    
    public int addArmor(String armor) {
    	return RenderingRegistry.addNewArmourRendererPrefix(armor);
    }
    
    
}
