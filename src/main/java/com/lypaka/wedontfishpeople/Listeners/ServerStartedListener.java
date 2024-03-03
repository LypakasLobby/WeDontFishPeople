package com.lypaka.wedontfishpeople.Listeners;

import com.lypaka.wedontfishpeople.WeDontFishPeople;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartedEvent;

@Mod.EventBusSubscriber(modid = WeDontFishPeople.MOD_ID)
public class ServerStartedListener {

    @SubscribeEvent
    public static void onServerStarted (FMLServerStartedEvent event) {

        MinecraftForge.EVENT_BUS.register(new UseListener());

    }

}
