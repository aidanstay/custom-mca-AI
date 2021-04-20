package mca.client.render;

import mca.client.colors.HairColors;
import mca.entity.EntityVillagerMCA;
import mca.enums.EnumGender;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerHair extends LayerVillager {
    public LayerHair(RenderLivingBase<?> rendererIn) {
        super(rendererIn, 0.0833f, 0.16666f);
    }

    @Override
    String getTexture(EntityLivingBase entity) {
        EntityVillagerMCA villager = (EntityVillagerMCA) entity;
        return villager.get(EntityVillagerMCA.HAIR);
    }

    @Override
    String getOverlayTexture(EntityLivingBase entity) {
        EntityVillagerMCA villager = (EntityVillagerMCA) entity;
        return villager.get(EntityVillagerMCA.HAIR_OVERLAY);
    }

    @Override
    float[] getColor(EntityLivingBase entity) {
        EntityVillagerMCA villager = (EntityVillagerMCA) entity;
        float e = villager.get(EntityVillagerMCA.GENE_EUMELANIN);
        float p = villager.get(EntityVillagerMCA.GENE_PHEOMELANIN);
        double[] color = HairColors.getColor(e, p);
        return new float[]{(float) color[0], (float) color[1], (float) color[2]};
    }
}
