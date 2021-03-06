package com.japaricraft.japaricraftmod.render.modelrender;

import com.japaricraft.japaricraftmod.mob.KouteiPenguin;
import com.japaricraft.japaricraftmod.mob.Shoebill;
import com.japaricraft.japaricraftmod.render.ModelKouteiPengin;
import com.japaricraft.japaricraftmod.render.ModelShoebill;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.japaricraft.japaricraftmod.JapariCraftMod.MODID;

@SideOnly(Side.CLIENT)
public class KouteiPenginEntityRender extends RenderBiped<KouteiPenguin>
{
    private static final ResourceLocation Pengin_TEXTURES = new ResourceLocation(MODID, "textures/entity/kouteipenguin.png");
    public KouteiPenginEntityRender(RenderManager renderManager)
    {
        super(renderManager, new ModelKouteiPengin(), 0.6F);
    }


    @Override
    protected ResourceLocation getEntityTexture(KouteiPenguin entity)
    {
        return Pengin_TEXTURES;
    }
}