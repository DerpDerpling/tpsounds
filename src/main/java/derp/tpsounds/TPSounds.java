package derp.tpsounds;

import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TPSounds implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("tpsounds");
    public static final Identifier PETTP = new Identifier("tpsounds:pettp");
    public static SoundEvent PETWARP = SoundEvent.of(PETTP);
    public static final Identifier DRAGONEGGTP = new Identifier("tpsounds:dragoneggtp");
    public static SoundEvent DRAGONEGGWARP = SoundEvent.of(DRAGONEGGTP);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("TP Sounds loaded.");
        Registry.register(Registries.SOUND_EVENT, TPSounds.PETTP, PETWARP);
        Registry.register(Registries.SOUND_EVENT, TPSounds.DRAGONEGGTP, DRAGONEGGWARP);
    }
}