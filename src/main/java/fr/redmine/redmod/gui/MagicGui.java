package fr.redmine.redmod.gui;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;

public class MagicGui extends GuiScreen{
	
	public int selectMagic = 0;
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
		switch (button.id) {
		case 0:
			selectMagic = 0;

		default:
			break;
		}
	}
}