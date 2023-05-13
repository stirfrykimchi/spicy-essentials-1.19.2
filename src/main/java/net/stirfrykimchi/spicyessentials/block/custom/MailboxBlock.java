package net.stirfrykimchi.spicyessentials.block.custom;

import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MailboxBlock extends Block {
    public MailboxBlock(Settings settings) {
        super(settings);
    }

    // Right-click to open storage


    // Tooltip
    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        if(Screen.hasShiftDown()){
            tooltip.add(Text.literal("Send and receive items from other mailboxes.").formatted(Formatting.AQUA));
        }else{
            tooltip.add(Text.literal("Press [Shift] for more info.").formatted(Formatting.YELLOW));
        }
        super.appendTooltip(stack, world, tooltip, options);
    }




}
