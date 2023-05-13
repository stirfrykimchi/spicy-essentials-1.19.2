package net.stirfrykimchi.spicyessentials;

import net.fabricmc.api.ModInitializer;
import net.stirfrykimchi.spicyessentials.block.ModBlocks;
import net.stirfrykimchi.spicyessentials.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpicyEssentials implements ModInitializer {
	// Makes it easier to refer to Mod ID
	public static final String MOD_ID = "spicyessentials";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);





	// Just stick to registers for now
	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
