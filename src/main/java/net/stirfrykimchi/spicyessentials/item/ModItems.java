package net.stirfrykimchi.spicyessentials.item;

import net.fabricmc.fabric.api.command.v2.FabricEntitySelectorReader;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.stirfrykimchi.spicyessentials.SpicyEssentials;
import net.stirfrykimchi.spicyessentials.entity.PipebombEntity;
import net.stirfrykimchi.spicyessentials.item.custom.PipebombItem;

public class ModItems {
    // Using 'registerItem', registers Items

    // Pipebomb
    public static final Item PIPEBOMB = registerItem("pipebomb",
            new PipebombItem(new FabricItemSettings().group(ModItemGroup.SPICYESSENTIALS).maxCount(16)));


    // Registers Projectiles

    // Pipebomb
    public static final EntityType<PipebombEntity> PipebombEntityType = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(SpicyEssentials.MOD_ID, "pipebomb"),
            FabricEntityTypeBuilder.<PipebombEntity>create(SpawnGroup.MISC, PipebombEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // Uses minecraft units
                    .trackRangeBlocks(4).trackedUpdateRate(10) // Stops it from breaking
                    .build()
    );



    // Makes items able to exist
    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(SpicyEssentials.MOD_ID,name),item);
    }


    // Just leave for debugging for now
    public static void registerModItems(){
        SpicyEssentials.LOGGER.debug("Registering Mod Items for " + SpicyEssentials.MOD_ID);
    }
}
