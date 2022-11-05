package dev.Cosmos616.technomancy.registry;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import dev.Cosmos616.technomancy.Technomancy;
import dev.Cosmos616.technomancy.content.contraptions.components.laser.LaserRenderer;
import dev.Cosmos616.technomancy.content.contraptions.components.laser.LaserTileEntity;
import dev.Cosmos616.technomancy.content.contraptions.energy.battery.SoulBatteryTileEntity;
import dev.Cosmos616.technomancy.content.contraptions.energy.cable.CableTileEntity;

public class TMTileEntities {

    private static final CreateRegistrate REGISTRATE = Technomancy.getRegistrate();

//    public static final BlockEntityEntry<SpectreCoilTileEntity> SPECTRE_COIL = REGISTRATE
//            .tileEntity("spectre_coil", SpectreCoilTileEntity::new)
//            .validBlocks(TMBlocks.SPECTRE_COIL_BLOCK)
//            .register();

    public static final BlockEntityEntry<SoulBatteryTileEntity> SOUL_BATTERY = REGISTRATE
            .tileEntity("soul_battery", SoulBatteryTileEntity::new)
            .validBlocks(TMBlocks.SOUL_BATTERY_BLOCK)
            .register();

    public static final BlockEntityEntry<SoulBatteryTileEntity> CREATIVE_SOUL_BATTERY = REGISTRATE
            .tileEntity("creative_soul_battery", SoulBatteryTileEntity::new)
            .validBlocks(TMBlocks.CREATIVE_SOUL_BATTERY_BLOCK)
            .register();

    public static final BlockEntityEntry<CableTileEntity> CABLE = REGISTRATE
            .tileEntity("cable", CableTileEntity::new)
            .validBlocks(TMBlocks.CABLE_BLOCK)
            .register();

    public static final BlockEntityEntry<CableTileEntity> ENCASED_CABLE = REGISTRATE
            .tileEntity("encased_cable", CableTileEntity::new)
            .validBlocks(TMBlocks.ENCASED_CABLE_BLOCK)
            .register();

    public static final BlockEntityEntry<LaserTileEntity> LASER = REGISTRATE
            .tileEntity("laser", LaserTileEntity::new)
            .validBlocks(TMBlocks.LASER)
            .renderer(() -> LaserRenderer::new)
            .register();

    public static void register() {}
}
