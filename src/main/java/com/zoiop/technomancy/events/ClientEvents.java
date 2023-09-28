package com.zoiop.technomancy.events;


import com.zoiop.technomancy.content.curiosities.weapons.firearms.archer.ui.EnergyArcherUI;
import com.simibubi.create.content.contraptions.actors.trainControls.ControlsHandler;
import com.simibubi.create.content.kinetics.fan.AirCurrent;
import com.simibubi.create.content.redstone.link.controller.LinkedControllerClientHandler;
import com.zoiop.technomancy.TechnomancyClient;
import com.zoiop.technomancy.registry.TMItems;
import net.minecraft.client.Minecraft;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class ClientEvents {
	
	@SubscribeEvent
	public static void onTick(TickEvent.ClientTickEvent event) {
		if (!isGameActive())
			return;
		
		Level world = Minecraft.getInstance().level;
		if (event.phase == TickEvent.Phase.START) {
			LinkedControllerClientHandler.tick();
			ControlsHandler.tick();
			AirCurrent.tickClientPlayerSounds();
			return;
		}
		
		TechnomancyClient.FIREARM_RENDER_HANDLER.tick();


		Minecraft mc = Minecraft.getInstance();
		if(!mc.player.getItemInHand(InteractionHand.MAIN_HAND).is(TMItems.ENERGY_ARCHER.get())) {
			EnergyArcherUI.toRender = false;

		}else EnergyArcherUI.tick();
	}
	
	protected static boolean isGameActive() {
		return !(Minecraft.getInstance().level == null || Minecraft.getInstance().player == null);
	}
}
