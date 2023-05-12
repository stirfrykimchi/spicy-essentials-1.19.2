package net.stirfrykimchi.spicyessentials.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.stirfrykimchi.spicyessentials.SpicyEssentials;

public class ModItems {

    public static final Item PIPEBOMB = registerItem("pipebomb",
            new Item(new FabricItemSettings().group(ModItemGroup.SPICYESSENTIALS)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registry.ITEM, new Identifier(SpicyEssentials.MOD_ID,name),item);
    }


    public static void registerModItems(){
        SpicyEssentials.LOGGER.debug("Registering Mod Items for " + SpicyEssentials.MOD_ID);
    }
}
