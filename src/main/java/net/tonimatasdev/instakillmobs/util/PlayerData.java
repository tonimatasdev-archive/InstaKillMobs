package net.tonimatasdev.instakillmobs.util;

import net.tonimatasdev.instakillmobs.InstaKillMobs;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class PlayerData {
    public static void addToInstaKill(Player player) {
        FileConfiguration config = InstaKillMobs.getInstance().getConfig();
        config.set("players", config.getStringList("players").add(player.getName()));
    }

    public static void removeToInstaKill(Player player) {
        FileConfiguration config = InstaKillMobs.getInstance().getConfig();
        config.set("players", config.getStringList("players").remove(player.getName()));
    }

    public static boolean getInstaKill(Player player) {
        return InstaKillMobs.getInstance().getConfig().getStringList("players").contains(player.getName());
    }
}
