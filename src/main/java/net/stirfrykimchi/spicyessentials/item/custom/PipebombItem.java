package net.stirfrykimchi.spicyessentials.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.stirfrykimchi.spicyessentials.entity.PipebombEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PipebombItem extends Item {
    public PipebombItem(Settings settings) {
        super(settings);
    }


    // On right-click, throw a "heavy" & "weak" explosive
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        // Creates a reference for making entities and decreasing stack size
        ItemStack itemStack = user.getStackInHand(hand);
        // Makes it server side
        if(!world.isClient() && hand == Hand.MAIN_HAND){
            // Plays a sound on use
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f,1f);
            // Creates a snowball entity
            PipebombEntity snowballEntity = new PipebombEntity(world, user);
            snowballEntity.setItem(itemStack);
            // Throws the entity
            snowballEntity.setVelocity(user, user.getPitch(),user.getYaw(),0.0f,0.3f,0f);
            world.spawnEntity(snowballEntity);
            // Adds a cooldown of 1 second
            user.getItemCooldownManager().set(this,5);
        } else if (!world.isClient() && hand == Hand.OFF_HAND) {
            // Plays a sound on use
            world.playSound(null, user.getX(), user.getY(), user.getZ(),
                    SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f,1f);
            // Creates a snowball entity
            PipebombEntity snowballEntity = new PipebombEntity(world, user);
            snowballEntity.setItem(itemStack);
            // Throws the entity
            snowballEntity.setVelocity(user, user.getPitch(),user.getYaw(),0.0f,0.3f,0f);
            world.spawnEntity(snowballEntity);
            // Adds a cooldown of 1 second
            user.getItemCooldownManager().set(this,5);
        }
        // Decreases stack size by 1 on use if not in creative
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }


    // Tooltip
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(Text.literal("Explodes inside chests. Throwable.").formatted(Formatting.AQUA));
        }else{
            tooltip.add(Text.literal("Press [Shift] for more info.").formatted(Formatting.YELLOW));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }





}
