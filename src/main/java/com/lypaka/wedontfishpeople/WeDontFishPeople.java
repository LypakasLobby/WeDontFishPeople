package com.lypaka.wedontfishpeople;

import com.lypaka.lypakautils.ConfigurationLoaders.BasicConfigManager;
import com.lypaka.lypakautils.ConfigurationLoaders.ConfigUtils;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("wedontfishpeople")
public class WeDontFishPeople {

    public static final String MOD_ID = "wedontfishpeople";
    public static final String MOD_NAME = "WeDontFishPeople";
    public static final Logger logger = LogManager.getLogger(MOD_NAME);
    public static BasicConfigManager configManager;

    public WeDontFishPeople() throws IOException, ObjectMappingException {

        Path dir = ConfigUtils.checkDir(Paths.get("./config/wedontfishpeople"));
        String[] files = new String[]{"wedontfishpeople.conf"};
        configManager = new BasicConfigManager(files, dir, WeDontFishPeople.class, MOD_NAME, MOD_ID, logger);
        configManager.init();
        ConfigGetters.load();

    }

}
