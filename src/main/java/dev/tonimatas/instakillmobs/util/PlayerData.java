package dev.tonimatas.instakillmobs.util;

import dev.tonimatas.instakillmobs.InstaKillMobs;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

public class PlayerData {
    public static void addToInstaKill(Player player) {
        FileConfiguration config = InstaKillMobs.getInstance().getConfig();

        // Add player to the list
        List<String> newList = config.getStringList("activeInstaKill");
        newList.add(player.getName());
        config.set("activeInstaKill", newList);

        // Save and reload config
        InstaKillMobs.getInstance().saveConfig();
        InstaKillMobs.getInstance().reloadConfig();
    }

    public static void removeToInstaKill(Player player) {
        FileConfiguration config = InstaKillMobs.getInstance().getConfig();

        // Remove player of the list
        List<String> newList = config.getStringList("activeInstaKill");
        newList.remove(player.getName());
        config.set("activeInstaKill", newList);

        // Save and reload config
        InstaKillMobs.getInstance().saveConfig();
        InstaKillMobs.getInstance().reloadConfig();
    }

    // Detects if player is in the list
    public static boolean getInstaKill(Player player) {
        return InstaKillMobs.getInstance().getConfig().getStringList("activeInstaKill").contains(player.getName());
    }
}
