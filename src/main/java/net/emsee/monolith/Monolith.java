package net.emsee.monolith;

import net.emsee.monolith.processor.ModProcessors;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;


@Mod(Monolith.MOD_ID)
public class Monolith {
    public static final String MOD_ID = "monolith";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static ResourceLocation defaultLocation(String name) {
        return ResourceLocation.fromNamespaceAndPath (MOD_ID, name);
    }

    public Monolith(IEventBus modEventBus, ModContainer modContainer) {
        LOGGER.info("Started Setup For {}", MOD_ID);
        modEventBus.addListener(this::commonSetup);

        NeoForge.EVENT_BUS.register(this);
        ModProcessors.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    @SubscribeEvent
    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("Started Common Setup For {}", MOD_ID);


    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("Started Server For {}", MOD_ID);
    }
}
