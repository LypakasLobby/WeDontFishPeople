package com.lypaka.wedontfishpeople.Listeners;

import com.lypaka.lypakautils.WorldStuff.WorldMap;
import com.lypaka.wedontfishpeople.ConfigGetters;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;

public class UseListener {

    @SubscribeEvent
    public void onFish (PlayerInteractEvent.RightClickItem event) {

        if (event.getSide() == LogicalSide.CLIENT) return;
        ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
        String world = WorldMap.getWorldName(player);
        if (event.getHand() == Hand.MAIN_HAND) {

            String id = player.getItemInHand(Hand.MAIN_HAND).getItem().getRegistryName().toString();
            if (id.equals("minecraft:fishing_rod")) {

                if (ConfigGetters.worlds.contains(world)) {

                    event.setCanceled(true);

                }

            }

        } else if (event.getHand() == Hand.OFF_HAND) {

            String id = player.getItemInHand(Hand.OFF_HAND).getItem().getRegistryName().toString();
            if (id.equals("minecraft:fishing_rod")) {

                if (ConfigGetters.worlds.contains(world)) {

                    event.setCanceled(true);

                }

            }

        }

    }

}
