package fr.redmine.redmod.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class SandwitchScreen extends GuiScreen{

		@Override
		public boolean doesGuiPauseGame() {
			return false;
		}
		
		@Override
		public void initGui()
	    {
	        this.buttonList.clear();
	        this.buttonList.add(new GuiButton(0, this.width / 2 - 100, this.height / 4 + 96, "machin")); 
	    }
		
		@Override
		protected void actionPerformed(GuiButton button) 
		{
			
	}
}
