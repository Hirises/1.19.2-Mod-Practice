package com.hirises.satisfactorymod.screen.custom.comveyor.screen;

import com.hirises.satisfactorymod.SatisfactoryMod;
import com.hirises.satisfactorymod.screen.custom.comveyor.menu.ConveyorBaseMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ConveyorBaseScreen extends AbstractContainerScreen<ConveyorBaseMenu> {
    private static final ResourceLocation BACKGROUND = new ResourceLocation(SatisfactoryMod.MODID, "textures/gui/conveyor_menu.png");

    public ConveyorBaseScreen(ConveyorBaseMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.passEvents = false;
        this.imageHeight = 133;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    @Override
    protected void renderBg(PoseStack poseStack, float deltaTime, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.setShaderTexture(0, BACKGROUND);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;

        this.blit(poseStack, x, y, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float deltaTime) {
        renderBackground(poseStack);
        super.render(poseStack, mouseX, mouseY, deltaTime);
        renderTooltip(poseStack, mouseX, mouseY);
    }
}
