package mca.client.render.layer;

import mca.client.model.VillagerEntityModelMCA;
import mca.client.render.HairColors;
import mca.entity.VillagerLike;
import mca.entity.ai.Genetics;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class HairLayer<T extends MobEntity & VillagerLike<T>> extends VillagerLayer<T, VillagerEntityModelMCA<T>> {
    public HairLayer(FeatureRendererContext<T, VillagerEntityModelMCA<T>> renderer, VillagerEntityModelMCA<T> model) {
        super(renderer, model);

        this.model.leftLeg.visible = false;
        this.model.leftLegwear.visible = false;
        this.model.rightLeg.visible = false;
        this.model.rightLegwear.visible = false;
    }

    @Override
    protected Identifier getSkin(T villager) {
        return cached(villager.getHair().texture(), Identifier::new);
    }

    @Override
    protected Identifier getOverlay(T villager) {
        return cached(villager.getHair().overlay(), Identifier::new);
    }

    @Override
    protected float[] getColor(T villager) {
        Optional<DyeColor> hairDye = villager.getHairDye();
        if (hairDye.isPresent()) {
            return hairDye.get().getColorComponents();
        }

        return HairColors.PALLET.getColor(
                villager.getGenetics().getGene(Genetics.EUMELANIN),
                villager.getGenetics().getGene(Genetics.PHEOMELANIN),
                0
        );
    }
}
