package net.tonimatasdev.instakillmobsingamemode.storage.yml;

import net.tonimatasdev.instakillmobsingamemode.InstaKillMobsInGameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class List {
    private static FileConfiguration list = null;
    private static File listFile = null;


    public static FileConfiguration getList() {
        if (list == null) {
            reloadList();
        }

        return list;
    }

    public static void reloadList() {
        if (list == null) {
            listFile = new File(InstaKillMobsInGameMode.getPlugin().getDataFolder(), "list.yml");
        }

        list = YamlConfiguration.loadConfiguration(listFile);
        Reader defConfigStream = new InputStreamReader(Objects.requireNonNull(InstaKillMobsInGameMode.getPlugin().getResource("list.yml")), StandardCharsets.UTF_8);
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        list.setDefaults(defConfig);
    }

    public static void saveList() {
        try {
            list.save(listFile);
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public static void registerList() {
        listFile = new File(InstaKillMobsInGameMode.getPlugin().getDataFolder(), "list.yml");

        if (!listFile.exists()) {
            getList().options().copyDefaults(true);
            saveList();
        }
    }
}
