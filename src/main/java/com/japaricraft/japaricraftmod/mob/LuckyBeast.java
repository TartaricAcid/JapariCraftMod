package com.japaricraft.japaricraftmod.mob;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import com.japaricraft.japaricraftmod.item.JapariItems;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;



public class LuckyBeast extends EntityTameable {

    private EntityPlayerSP player;

    public LuckyBeast(World worldIn) {
        super(worldIn);
        this.setSize(0.6F, 1.0F);
        this.setTamed(false);
    }

    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 4.0F));
    }

    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand ) {
        ItemStack stack = player.getHeldItem(hand);

        if (this.isTamed()) {
            if (this.isOwner(player) && !this.world.isRemote && !this.isBreedingItem(stack)) {
                return true;
            }
        } else if (stack != null && stack.getItem() == Items.REDSTONE && player.getDistanceSqToEntity(this) < 22.0D) {
            if (!player.capabilities.isCreativeMode) {
                stack.setCount(stack.getCount() - 1);
            }

            if (!this.world.isRemote) {
                if (this.rand.nextInt(1) == 0) {
                    this.setTamed(true);
                    this.setOwnerId(player.getUniqueID());
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte) 7);
                } else {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte) 6);
                }


            }
        }
        return true;
    }

    protected void updateAITasks() {
        if (this.ticksExisted % 5 == 0) {
            this.heal(0.1F);
        }
    }



    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.BLOCK_GLASS_BREAK;
    }


    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.28D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(5.0D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
    }







    @Override
    public EnumCreatureAttribute getCreatureAttribute() { return EnumCreatureAttribute.UNDEFINED; }


    public Item getDropItem () {

        return null;//なにも落とさない
    }
    @Override
    protected void dropFewItems(boolean parRecentlyHit, int parLootingLevel) {
        {
            this.entityDropItem(new ItemStack(JapariItems.summonlucky, 1, 0), 0.0F);
        }
    }
    public void fall(float distance, float damageMultiplier)
    {
    }

    public boolean canDespawn()
    {
        return false;
    }

}


