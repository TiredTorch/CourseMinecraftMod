package net.trtorch.additionalfurniture.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.trtorch.additionalfurniture.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> BAOBAB_TREE =
            FeatureUtils.register("baobab", Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(ModBlocks.BAOBAB_LOG.get()),
                    new StraightTrunkPlacer(5, 6, 3),
                    BlockStateProvider.simple(ModBlocks.BAOBAB_LEAVES.get()),
                    new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                    new TwoLayersFeatureSize(1, 0, 2)).build());

    public static final Holder<PlacedFeature> BAOBAB_CHECKED = PlacementUtils.register("baobab_checked", BAOBAB_TREE,
            PlacementUtils.filteredByBlockSurvival(ModBlocks.BAOBAB_SAPLING.get()));

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> BAOBAB_SPAWN =
            FeatureUtils.register("baobab_spawn", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(BAOBAB_CHECKED,
                            0.5F)), BAOBAB_CHECKED));
}
