package com.lypaka.wedontfishpeople;

import com.google.common.reflect.TypeToken;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;

import java.util.List;

public class ConfigGetters {

    public static List<String> worlds;

    public static void load() throws ObjectMappingException {

        worlds = WeDontFishPeople.configManager.getConfigNode(0, "Worlds").getList(TypeToken.of(String.class));

    }

}
