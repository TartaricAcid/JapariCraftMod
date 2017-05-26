package com.japaricraft.japaricraftmod.item;

import com.japaricraft.japaricraftmod.JapariCraftMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;


public class StarCaramel extends ItemFood {

    public StarCaramel() {
        super(2, 1, false);
        this.setCreativeTab(JapariCraftMod.tabJapariCraft);
        this.setUnlocalizedName("StarCaramel");
        this.setAlwaysEdible();
    }
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote)
        {

            {
                player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 600, 0));

            }
        }
    }
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}