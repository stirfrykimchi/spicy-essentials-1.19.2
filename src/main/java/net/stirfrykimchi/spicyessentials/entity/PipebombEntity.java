package net.stirfrykimchi.spicyessentials.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import net.stirfrykimchi.spicyessentials.SpicyEssentials;
import net.stirfrykimchi.spicyessentials.item.ModItems;
import net.stirfrykimchi.spicyessentials.item.custom.PipebombItem;

public class PipebombEntity extends ThrownItemEntity {
    public PipebombEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public PipebombEntity(World world, LivingEntity owner) {
        super(ModItems.PipebombEntityType, owner, world);
    }

    public PipebombEntity(World world, double x, double y, double z) {
        super(ModItems.PipebombEntityType, x, y, z, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.PIPEBOMB;
    }


    // Called on entity hit
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        // Sets a new Entity instance as the EntityHitResult (victim)
        Entity entity = entityHitResult.getEntity();
        // Deals damage
        entity.damage(DamageSource.thrownProjectile(this,this.getOwner()), 2);
        // Checks if entity is an LivingEntity like a boat or minecart
        if (entity instanceof LivingEntity livingEntity) {
            // Creates a TNT entity
            TntEntity tntEntity = EntityType.TNT.create(world);
            // Makes it explode immediately
            tntEntity.setFuse(0);
            // Makes it spawn at the entity
            tntEntity.setPosition(entity.getX(),entity.getY(),entity.getZ());
            // Makes the explosion weaker and spawns it
            tntEntity.world.createExplosion(this, this.getX(), this.getBodyY(0.0625), this.getZ(),
                    1.0f, Explosion.DestructionType.BREAK);
            //world.spawnEntity(tntEntity);  the alternate line if the explosion power is unchanged
        }
    }


    // Called on block hit
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        // Checks if the world is client
        if (!this.world.isClient) {
            // Creates a TNT entity
            TntEntity tntEntity = EntityType.TNT.create(world);
            // Makes it explode immediately and makes the explosion weaker
            tntEntity.setFuse(0);
            tntEntity.world.createExplosion(this, this.getX(), this.getBodyY(0.0625), this.getZ(),
                    1.0f, Explosion.DestructionType.BREAK);
            // Makes it spawn at the location
            tntEntity.setPosition(tntEntity.getBlockX(),tntEntity.getBlockY(),tntEntity.getBlockZ());
            world.spawnEntity(tntEntity);
            // Destroys the projectile
            this.kill();
        }
    }


}
