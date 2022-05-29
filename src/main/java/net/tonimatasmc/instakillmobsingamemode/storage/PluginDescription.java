package net.tonimatasmc.instakillmobsingamemode.storage;

import net.tonimatasmc.instakillmobsingamemode.InstaKillMobsInGameMode;
import org.bukkit.ChatColor;

public class PluginDescription {
    public static String getprefix;
    public static String version;
    public static String website;
    public static String prefix;
    public static String name;

    public static void register() {
        getprefix = InstaKillMobsInGameMode.getPlugin().getDescription().getPrefix();
        website = InstaKillMobsInGameMode.getPlugin().getDescription().getWebsite();
        version = InstaKillMobsInGameMode.getPlugin().getDescription().getVersion();
        name = InstaKillMobsInGameMode.getPlugin().getDescription().getName();
        prefix = ChatColor.GOLD + "[" + ChatColor.DARK_RED + getprefix + ChatColor.GOLD + "]";
    }


}
