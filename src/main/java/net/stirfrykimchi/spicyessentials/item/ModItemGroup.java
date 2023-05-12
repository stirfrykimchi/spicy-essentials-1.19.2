package net.stirfrykimchi.spicyessentials.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.stirfrykimchi.spicyessentials.SpicyEssentials;

public class ModItemGroup {
    public static final ItemGroup SPICYESSENTIALS = FabricItemGroupBuilder.build(
            new Identifier(SpicyEssentials.MOD_ID,"spicyessentials"), () -> new ItemStack(ModItems.PIPEBOMB));
}
