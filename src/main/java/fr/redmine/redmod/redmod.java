package fr.redmine.redmod;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

import org.lwjgl.opengl.Display;
import net.minecraft.client.resources.DefaultResourcePack;
import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.server.FMLServerHandler;
import fr.redmine.redmod.command.getEnergyHasPlayer;
import fr.redmine.redmod.command.setTankEnergy;
import fr.redmine.redmod.command.sethealthCommand;
import fr.redmine.redmod.event.EventForge;
import fr.redmine.redmod.event.EventVannila;
import fr.redmine.redmod.generator.generator_ore;
import fr.redmine.redmod.gui.GuiCustomMainMenu;
import fr.redmine.redmod.gui.GuiHandler;
import fr.redmine.redmod.init.RegisterBlock;
import fr.redmine.redmod.init.RegisterItems;
import fr.redmine.redmod.init.RegisterRecipe;
import fr.redmine.redmod.mob.EntityGen;
import fr.redmine.redmod.proxy.ClientProxy;
import fr.redmine.redmod.proxy.CommonProxy;
import fr.redmine.redmod.utils.Reference;
import fr.redmine.redmod.utils.TutoTab;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemTossEvent;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class redmod {


  // @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
   // public static ClientProxy clientProxy;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
    public static CommonProxy commonProxy;
    
    
    @Instance("redmod")
    public static redmod instance;
    

    public static CreativeTabs trucTabs = new TutoTab("tructabs");
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	RegisterBlock.init();
        RegisterBlock.register();
    	RegisterItems.init();
        RegisterItems.register();
        RegisterRecipe.init();
        EntityGen.registerEntity();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
    	 if(e.getSide().isClient())
          {
            FMLCommonHandler.instance().bus().register(this);
            
          }
    	NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    	MinecraftForge.EVENT_BUS.register(new EventForge());
    	FMLCommonHandler.instance().bus().register(new EventVannila());
    	GameRegistry.registerWorldGenerator(new generator_ore(), 0);
		commonProxy.registerRenders();
		commonProxy.registerNetworkStuff();

    	 }
    
   @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

   @SubscribeEvent
   @SideOnly(Side.CLIENT)
   public void onTick(TickEvent.ClientTickEvent event)
   {
       Minecraft mc = FMLClientHandler.instance().getClient();
       if(mc.currentScreen != null && mc.currentScreen.getClass().equals(GuiMainMenu.class))
       {
           mc.displayGuiScreen(new GuiCustomMainMenu());
       }

   }
   
   @EventHandler
   public void onServerStart(FMLServerStartedEvent e)
   {
	   
	   MinecraftServer server = MinecraftServer.getServer();
	   ICommandManager command = server.getCommandManager();
	   ServerCommandManager manager = (ServerCommandManager) command;
	   manager.registerCommand(new sethealthCommand());
	   manager.registerCommand(new setTankEnergy());
	   manager.registerCommand(new getEnergyHasPlayer());
	   
	//  World world = server.getEntityWorld();
	//	  List entitylist = world.getLoadedEntityList();
//	  for(int i = 0; i < )
	 
   
   }
}