package dev.Cosmos616.technomancy.content.curiosities.weapons.firearms.revolver;
import dev.Cosmos616.technomancy.content.curiosities.weapons.firearms.base.AbstractFirearmItem;
import dev.Cosmos616.technomancy.content.curiosities.weapons.firearms.base.AbstractFirearmItemRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;


public class EnergyRevolverItem extends AbstractFirearmItem {
	public EnergyRevolverItem(Properties properties) {
		super(properties);
	}


	@Override
	public Vec3 getBarrelOffset() {
		return Vec3.ZERO;
	}

	@Override
	public void inventoryTick(ItemStack stack, Level level, Entity entity, int slot, boolean isSelected) {
		super.inventoryTick(stack, level, entity, slot, isSelected);
	}

	@Override
	protected int getFirerateTicks() {
		return 10;
	}

	@Override
	protected int getReloadTicks() {
		return 5;
	}

	@Override
	protected int getMaxAmmo() {
		return 8;
	}

	@Override
	public AbstractFirearmItemRenderer<?> getRenderer() {
		return new EnergyRevolverItemRenderer();
	}
}