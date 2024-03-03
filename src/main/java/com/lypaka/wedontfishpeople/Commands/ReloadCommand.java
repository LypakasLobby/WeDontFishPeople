package com.lypaka.wedontfishpeople.Commands;

import com.lypaka.lypakautils.FancyText;
import com.lypaka.lypakautils.MiscHandlers.PermissionHandler;
import com.lypaka.wedontfishpeople.ConfigGetters;
import com.lypaka.wedontfishpeople.WeDontFishPeople;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.ServerPlayerEntity;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;

public class ReloadCommand {

    public ReloadCommand (CommandDispatcher<CommandSource> dispatcher) {

        for (String a : WeDontFishPeopleCommand.ALIASES) {

            dispatcher.register(
                    Commands.literal(a)
                            .then(
                                    Commands.literal("reload")
                                            .executes(c -> {

                                                if (c.getSource().getEntity() instanceof ServerPlayerEntity) {

                                                    ServerPlayerEntity player = (ServerPlayerEntity) c.getSource().getEntity();
                                                    if (!PermissionHandler.hasPermission(player, "wedontfishpeople.command.admin")) {

                                                        player.sendMessage(FancyText.getFormattedText("&cYou don't have permission to use this command!"), player.getUUID());
                                                        return 0;

                                                    }

                                                }

                                                try {

                                                    WeDontFishPeople.configManager.load();
                                                    ConfigGetters.load();
                                                    c.getSource().sendSuccess(FancyText.getFormattedText("&aSuccessfully reloaded WeDontFishPeople's config!"), true);

                                                } catch (ObjectMappingException e) {

                                                    throw new RuntimeException(e);

                                                }

                                                return 1;

                                            })
                            )
            );

        }

    }

}
