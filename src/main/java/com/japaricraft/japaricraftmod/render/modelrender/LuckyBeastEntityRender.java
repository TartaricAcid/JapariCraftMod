package com.japaricraft.japaricraftmod.render.modelrender;

import com.japaricraft.japaricraftmod.mob.LuckyBeast;
import com.japaricraft.japaricraftmod.mob.Shoebill;
import com.japaricraft.japaricraftmod.render.ModelShoebill;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.japaricraft.japaricraftmod.JapariCraftMod.MODID;

@SideOnly(Side.CLIENT)
public class LuckyBeastEntityRender extends RenderLivingBase<LuckyBeast>
{
    private static final ResourceLocation Lucky_TEXTURES = new ResourceLocation(MODID, "textures/entity/luckybeast.png");
    public LuckyBeastEntityRender(RenderManager renderManager)
    {
        super(renderManager, new ModelShoebill(), 0.6F);
    }


    @Override
    protected ResourceLocation getEntityTexture(LuckyBeast entity)
    {
        return Lucky_TEXTURES;
    }
}