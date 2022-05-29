package net.tonimatasmc.instakillmobsingamemode.manager;

import net.tonimatasmc.instakillmobsingamemode.InstaKillMobsInGameMode;
import net.tonimatasmc.instakillmobsingamemode.storage.yml.Config;
import net.tonimatasmc.instakillmobsingamemode.storage.yml.List;

public class YMLManager {
    public static void register() {
        Config.registerConfig();
        List.registerList();
    }

    public static void unregister() {
        InstaKillMobsInGameMode.getPlugin().reloadConfig();
        InstaKillMobsInGameMode.getPlugin().saveConfig();

        List.reloadList();
        List.saveList();
    }
}
