package net.tonimatasdev.instakillmobsingamemode.storage;

import net.tonimatasdev.instakillmobsingamemode.InstaKillMobsInGameMode;
import org.bukkit.ChatColor;

public class PluginDescription {
    private static String version;
    private static String prefix;
    private static String name;
    private static String prefixPositive;
    private static String prefixNegative;

    public static void register() {
        version = InstaKillMobsInGameMode.getPlugin().getDescription().getVersion();
        name = InstaKillMobsInGameMode.getPlugin().getDescription().getName();
        prefix = ChatColor.GOLD + "[" + ChatColor.DARK_RED + InstaKillMobsInGameMode.getPlugin().getDescription().getPrefix() + ChatColor.GOLD + "]";
        prefixPositive = "[" + ChatColor.DARK_GREEN + "+" + ChatColor.WHITE + "] " + ChatColor.GRAY + "InstaKillMobs: " + ChatColor.WHITE;
        prefixNegative = "[" + ChatColor.DARK_RED + "-" + ChatColor.WHITE + "] " + ChatColor.GRAY + "InstaKillMobs: " + ChatColor.WHITE;
    }

    public static String getName() {
        return name;
    }

    public static String getVersion() {
        return version;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static String getPrefixPositive() {
        return prefixPositive;
    }

    public static String getPrefixNegative() {
        return prefixNegative;
    }
}
