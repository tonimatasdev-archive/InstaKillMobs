package net.tonimatasdev.instakillmobsingamemode.storage.yml;

import net.tonimatasdev.instakillmobsingamemode.InstaKillMobsInGameMode;

import java.io.File;

public class Config {
    public static void registerConfig() {
        if (!new File(InstaKillMobsInGameMode.getInstance().getDataFolder(), "config.yml").exists()) {
            InstaKillMobsInGameMode.getInstance().getConfig().options().copyDefaults(true);
            InstaKillMobsInGameMode.getInstance().saveConfig();
        }
    }
}
