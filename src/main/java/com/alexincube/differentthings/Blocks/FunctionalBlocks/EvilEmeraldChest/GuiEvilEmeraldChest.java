package com.alexincube.differentthings.Blocks.FunctionalBlocks.EvilEmeraldChest;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiEvilEmeraldChest extends GuiContainer {
    private static final ResourceLocation GUI_CHEST = new ResourceLocation("differentthings:textures/gui/copper_chest.png");
    private final InventoryPlayer playerInventory;
    private final TileEntityEvilEmeraldChest te;

    public GuiEvilEmeraldChest(InventoryPlayer playerInventory, TileEntityEvilEmeraldChest chestInventory, EntityPlayer player){
        super(new ContainerEvilEmeraldChest(playerInventory,chestInventory,player));
        this.playerInventory=playerInventory;
        this.te=chestInventory;

        this.xSize=179;
                this.ySize=256;
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.fontRenderer.drawString(this.te.getDisplayName().getUnformattedText(),8,6,16086784);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(),8,this.ySize-92,16086784);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0f,1.0f,1.0f);
        this.mc.getTextureManager().bindTexture(GUI_CHEST);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop,0,0,this.xSize, this.ySize);
    }
}
