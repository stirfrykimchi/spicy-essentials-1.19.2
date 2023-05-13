package net.stirfrykimchi.spicyessentials;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.Entity;
import net.stirfrykimchi.spicyessentials.item.ModItems;

public class SpicyEssentialsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Renders the Projectile Entity, Pipebomb
        EntityRendererRegistry.register(ModItems.PipebombEntityType, FlyingItemEntityRenderer::new);

    }
}
