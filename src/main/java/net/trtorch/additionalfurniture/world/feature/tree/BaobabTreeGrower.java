package net.trtorch.additionalfurniture.world.feature.tree;

import net.minecraft.core.Holder;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.trtorch.additionalfurniture.world.feature.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BaobabTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(Random p_204307_, boolean p_204308_) {
        return ModConfiguredFeatures.BAOBAB_TREE;
    }
}
