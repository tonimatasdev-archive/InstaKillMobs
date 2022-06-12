package net.tonimatasmc.instakillmobsingamemode.manager;

import net.tonimatasmc.instakillmobsingamemode.storage.PluginDescription;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class MessageManager {
    public static void start() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
        Bukkit.getConsoleSender().sendMessage(PluginDescription.getPrefixPositive() + " The plugin was activated (Version: " + PluginDescription.getVersion() + ")");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
    }

    public static void stop() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
        Bukkit.getConsoleSender().sendMessage(PluginDescription.getPrefixPositive() + " The plugin was disabled (Version: " + PluginDescription.getVersion() + ")");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
    }
}
