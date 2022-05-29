package net.tonimatasmc.instakillmobsingamemode.storage.yml;

import net.tonimatasmc.instakillmobsingamemode.InstaKillMobsInGameMode;

import java.io.File;

public class Config {
    public static void registerConfig() {
        File config = new File(InstaKillMobsInGameMode.getPlugin().getDataFolder(), "config.yml");

        if (!config.exists()) {
            InstaKillMobsInGameMode.getPlugin().getConfig().options().copyDefaults(true);
            InstaKillMobsInGameMode.getPlugin().saveConfig();
        }
    }
}
