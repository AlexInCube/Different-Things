package com.alexincube.differentthings.Blocks.FunctionalBlocks.BlockBreaker;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import java.util.Collections;

public class GuiBreaker extends GuiContainer {
    private static final ResourceLocation GUI_CHEST = new ResourceLocation("differentthings:textures/gui/container/repairer.png");
    private final InventoryPlayer playerInventory;
    private final TileEntityBreaker te;

    public GuiBreaker(InventoryPlayer playerInventory, TileEntityBreaker chestInventory, EntityPlayer player){
        super(new ContainerBreaker(playerInventory,chestInventory,player));
        this.playerInventory=playerInventory;
        this.te=chestInventory;
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);

        int energy = te.getField(0);
        if (mouseX > guiLeft+37 && mouseX < guiLeft+139 && mouseY > guiTop+57 && mouseY < guiTop+65){
            drawHoveringText(Collections.singletonList("Energy: "+energy+"/"+ TileEntityBreaker.MAX_POWER),mouseX,mouseY,fontRenderer);
        }
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = this.te.getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
        int energy = te.getField(0);

        //this.fontRenderer.drawString(String.valueOf(energy), this.xSize/2, this.ySize - 96 + 2, 4210752);
    }



    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0f,1.0f,1.0f);
        this.mc.getTextureManager().bindTexture(GUI_CHEST);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop,0,0,this.xSize, this.ySize);

        int energy = te.getField(0);
        drawEnergyBar(energy);
    }

    private void drawEnergyBar(int energy){
        drawRect(guiLeft+37,guiTop+57,guiLeft+139,guiTop+65, 0xff7f0000);
        drawRect(guiLeft+38,guiTop+58,guiLeft+38+((energy*100/ TileEntityBreaker.MAX_POWER)),guiTop+64, 0xffff0000);

    }
}
