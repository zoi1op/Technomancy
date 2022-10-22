package dev.Cosmos616.technomancy.registry;

import com.simibubi.create.content.contraptions.base.CasingBlock;
import com.simibubi.create.content.contraptions.relays.encased.EncasedCTBehaviour;
import com.simibubi.create.foundation.block.BlockStressDefaults;
import com.simibubi.create.foundation.data.*;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.BlockEntry;
import dev.Cosmos616.technomancy.Technomancy;
import dev.Cosmos616.technomancy.content.contraptions.components.soulengine.SoulEngineBlock;
import dev.Cosmos616.technomancy.content.contraptions.energy.battery.SoulBatteryBlock;
import dev.Cosmos616.technomancy.content.contraptions.energy.battery.SoulBatteryGenerator;
import dev.Cosmos616.technomancy.content.contraptions.energy.cable.CableAttachmentModel;
import dev.Cosmos616.technomancy.content.contraptions.energy.cable.CableBlock;
import dev.Cosmos616.technomancy.content.contraptions.energy.cable.EncasedCableBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraftforge.common.Tags;

import static com.simibubi.create.AllTags.*;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;

public class TMBlocks {
    private static final CreateRegistrate REGISTRATE = Technomancy.getRegistrate()
            .creativeModeTab(() -> Technomancy.BASE_CREATIVE_TAB);

//    public static final BlockEntry<SpectreCoilBlock> SPECTRE_COIL_BLOCK = REGISTRATE
//            .block("spectre_coil", SpectreCoilBlock::new)
//            .initialProperties(SharedProperties::softMetal)
//            .properties(p -> p
//                    .sound(SoundType.NETHERITE_BLOCK)
//                    .explosionResistance(1200)
//                    .noOcclusion())
//            .transform(pickaxeOnly())
//            .blockstate(new SpectreCoilGenerator()::generate)
//            .addLayer(() -> RenderType::cutoutMipped)
//            .item()
//            .model(AssetLookup.customBlockItemModel("_", "coil_single"))
//            .build()
//            .register();

    public static final BlockEntry<SoulBatteryBlock> SOUL_BATTERY_BLOCK = REGISTRATE
            .block("soul_battery", SoulBatteryBlock::regular)
            .initialProperties(SharedProperties::softMetal)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .properties(p -> p
                    .sound(SoundType.NETHERITE_BLOCK)
                    .isRedstoneConductor((p1, p2, p3) -> true))
            .transform(pickaxeOnly())
            .blockstate(new SoulBatteryGenerator()::generate)
            .addLayer(() -> RenderType::cutoutMipped)
            .item()
            .model(AssetLookup.customBlockItemModel("_", "block_single"))
            .build()
            .register();

    public static final BlockEntry<SoulBatteryBlock> CREATIVE_SOUL_BATTERY_BLOCK = REGISTRATE
            .block("creative_soul_battery", SoulBatteryBlock::creative)
            .initialProperties(SharedProperties::softMetal)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .properties(p -> p
                    .sound(SoundType.NETHERITE_BLOCK)
                    .isRedstoneConductor((p1, p2, p3) -> true))
            .transform(pickaxeOnly())
            .blockstate(new SoulBatteryGenerator("creative_")::generate)
            .addLayer(() -> RenderType::cutoutMipped)
            .item()
            .properties(p -> p.rarity(Rarity.EPIC))
            .model(AssetLookup.customBlockItemModel("_", "block_single"))
            .build()
            .register();

    public static final BlockEntry<CableBlock> CABLE_BLOCK = REGISTRATE
            .block("cable", CableBlock::new)
            .initialProperties(SharedProperties::softMetal)
            .blockstate(TMBlockStateGen.cable())
            .onRegister(CreateRegistrate.blockModel(() -> CableAttachmentModel::new))
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<EncasedCableBlock> ENCASED_CABLE_BLOCK = REGISTRATE
            .block("encased_cable", EncasedCableBlock::new)
            .initialProperties(SharedProperties::softMetal)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .blockstate(TMBlockStateGen.encasedCable())
            .onRegister(CreateRegistrate.connectedTextures(() -> new EncasedCTBehaviour(TMSpriteShifts.CABLE_CASING)))
            .onRegister(CreateRegistrate.casingConnectivity((block, cc) -> cc.make(block, TMSpriteShifts.CABLE_CASING)))
            .onRegister(CreateRegistrate.blockModel(() -> CableAttachmentModel::new))
            .loot((p, b) -> p.dropOther(b, CABLE_BLOCK.get()))
            .register();

    public static final BlockEntry<CasingBlock> CABLE_CASING = REGISTRATE
            .block("cable_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> TMSpriteShifts.CABLE_CASING))
            .properties(p -> p.sound(SoundType.COPPER))
            .register();

    public static final BlockEntry<OreBlock> ZIRCONIUM_ORE = REGISTRATE
            .block("zirconium_ore", OreBlock::new)
            .initialProperties(() -> Blocks.NETHER_GOLD_ORE)
            .properties(p -> p.color(MaterialColor.METAL))
            .properties(p -> p.requiresCorrectToolForDrops()
                    .sound(SoundType.NETHER_ORE))
            .transform(pickaxeOnly())
            .loot((lt, b) -> lt.add(b,
                    RegistrateBlockLootTables.createSilkTouchDispatchTable(b,
                            RegistrateBlockLootTables.applyExplosionDecay(b, LootItem.lootTableItem(TMItems.RAW_ZIRCONIUM.get())
                                    .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))))
            .tag(BlockTags.NEEDS_IRON_TOOL)
            .tag(Tags.Blocks.ORES)
            .transform(tagBlockAndItem("ores/zirconium", "ores_in_ground/netherrack"))
            .tag(Tags.Items.ORES)
            .lang("Zirconium Ore")
            .build()
            .register();

    public static final BlockEntry<SoulEngineBlock> SOUL_ENGINE = REGISTRATE.block("soul_engine", SoulEngineBlock::new)
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p.color(MaterialColor.METAL))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(axeOrPickaxe())
            .blockstate(BlockStateGen.directionalBlockProviderIgnoresWaterlogged(false))
            .addLayer(() -> RenderType::cutoutMipped)
            .transform(BlockStressDefaults.setCapacity(1024.0))
            .transform(BlockStressDefaults.setGeneratorSpeed(SoulEngineBlock::getSpeedRange))
            .simpleItem()
            .register();

    public static void register() {}
}