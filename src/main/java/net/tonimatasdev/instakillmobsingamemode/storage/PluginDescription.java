package net.tonimatasdev.instakillmobsingamemode.storage;

import net.tonimatasdev.instakillmobsingamemode.InstaKillMobs;
import org.bukkit.ChatColor;

public class PluginDescription {
    private static String version;
    private static String prefixPositive;
    private static String prefixNegative;

    public static void register() {
        version = InstaKillMobs.getInstance().getDescription().getVersion();
        prefixPositive = "[" + ChatColor.DARK_GREEN + "+" + ChatColor.WHITE + "] " + ChatColor.GRAY + "InstaKillMobs: " + ChatColor.WHITE;
        prefixNegative = "[" + ChatColor.DARK_RED + "-" + ChatColor.WHITE + "] " + ChatColor.GRAY + "InstaKillMobs: " + ChatColor.WHITE;
    }

    public static String getVersion() {
        return version;
    }

    public static String getPrefixPositive() {
        return prefixPositive;
    }

    public static String getPrefixNegative() {
        return prefixNegative;
    }
}
