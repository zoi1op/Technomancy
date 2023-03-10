package dev.Cosmos616.technomancy.content.curiosities.weapons.firearms.base;

import com.simibubi.create.content.curiosities.zapper.ShootableGadgetItemMethods;
import com.simibubi.create.content.curiosities.zapper.ShootableGadgetRenderHandler;
import dev.Cosmos616.technomancy.TechnomancyClient;
import dev.Cosmos616.technomancy.registry.TMPackets;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class FirearmInteractionHandler {
//	@SubscribeEvent
//	public void onKeyPressed(InputEvent.KeyInputEvent event) {
//
//	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onMouseClick(InputEvent.ClickInputEvent event) {
		if (event.isCanceled())
			return;
		
		Minecraft mc = Minecraft.getInstance();
		Player player = mc.player;
		if (player == null)
			return;
		
		ItemStack heldItem = player.getMainHandItem();
		if (!(heldItem.getItem() instanceof AbstractFirearmItem gunItem))
			return;
		event.setSwingHand(false);
		event.setCanceled(true);
		mc.options.keyAttack.setDown(false);
		

		
		if (!event.isAttack())
			return;
		
		// Handle firing
		if ((!gunItem.hasAmmo(heldItem) && !player.isCreative()) || player.isSpectator())
			return;
		
		ItemCooldowns cooldownTracker = player.getCooldowns();
		if (cooldownTracker.isOnCooldown(gunItem))
			return;
		
		cooldownTracker.addCooldown(gunItem, gunItem.getFirerateTicks());
		TMPackets.channel.sendToServer(new FirearmShootPacket(ShootableGadgetItemMethods.getGunBarrelVec(player, true, gunItem.getBarrelOffset())));
		gunItem.shootWeapon(player, heldItem, true);
	}

	
//	@SubscribeEvent
//	public void onClientTick(TickEvent.ClientTickEvent event) {
//
//	}
}
