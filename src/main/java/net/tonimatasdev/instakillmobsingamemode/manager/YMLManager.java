package net.tonimatasdev.instakillmobsingamemode.manager;

import net.tonimatasdev.instakillmobsingamemode.storage.yml.Config;
import net.tonimatasdev.instakillmobsingamemode.storage.yml.List;
import net.tonimatasdev.instakillmobsingamemode.InstaKillMobsInGameMode;

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
