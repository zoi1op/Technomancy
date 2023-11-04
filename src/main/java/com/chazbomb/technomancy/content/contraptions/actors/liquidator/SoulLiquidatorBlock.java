package com.chazbomb.technomancy.content.contraptions.actors.liquidator;

import com.chazbomb.technomancy.registry.TMBlockEntities;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;

public abstract class SoulLiquidatorBlock extends Block implements IBE<SoulLiquidatorBlockEntity> { // I have no doubt about the work

	public SoulLiquidatorBlock(Properties props) {
		super(props);
	}

	@Override
	public Class<SoulLiquidatorBlockEntity> getBlockEntityClass() {
		return SoulLiquidatorBlockEntity.class;
	}

	@Override
	public BlockEntityType<? extends SoulLiquidatorBlockEntity> getBlockEntityType() {
		return TMBlockEntities.SOUL_LIQUIDATOR.get();
	}
}
