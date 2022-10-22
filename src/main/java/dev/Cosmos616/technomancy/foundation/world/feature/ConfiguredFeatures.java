package dev.Cosmos616.technomancy.foundation.world.feature;

import dev.Cosmos616.technomancy.registry.TMBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

import java.util.List;

public class ConfiguredFeatures {
    public static final List<OreConfiguration.TargetBlockState> ZIRCONIUM_ORES = List.of(
            OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, TMBlocks.ZIRCONIUM_ORE.get().defaultBlockState()));

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ZIRCONIUM_ORE = FeatureUtils.register("zirconium_ore",
            Feature.ORE, new OreConfiguration(ZIRCONIUM_ORES, 13));
}