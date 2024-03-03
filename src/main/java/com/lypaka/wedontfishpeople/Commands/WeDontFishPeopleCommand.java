package com.lypaka.wedontfishpeople.Commands;

import com.lypaka.wedontfishpeople.WeDontFishPeople;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber(modid = WeDontFishPeople.MOD_ID)
public class WeDontFishPeopleCommand {

    public static final List<String> ALIASES = Arrays.asList("wedontfishpeople", "wdfp");

    @SubscribeEvent
    public static void onCommandRegistration (RegisterCommandsEvent event) {

        new ReloadCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());

    }

}
