package net.tonimatasdev.instakillmobsingamemode;

import net.tonimatasdev.devlib.api.DevPlugin;
import net.tonimatasdev.instakillmobsingamemode.commands.Command;
import net.tonimatasdev.instakillmobsingamemode.events.Hit;
import net.tonimatasdev.instakillmobsingamemode.events.Join;
import net.tonimatasdev.instakillmobsingamemode.storage.PluginDescription;
import net.tonimatasdev.instakillmobsingamemode.storage.yml.List;
import net.tonimatasdev.instakillmobsingamemode.utils.TabulatorCompleter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class InstaKillMobs extends DevPlugin {
    private static InstaKillMobs instance;

    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        List.registerList();

        PluginDescription.register();

        registerCommand("instakillmobs", new Command(), new TabulatorCompleter());
        registerEvent(new Hit());
        registerEvent(new Join());

        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
        Bukkit.getConsoleSender().sendMessage(PluginDescription.getPrefixPositive() + " The plugin was activated (Version: " + PluginDescription.getVersion() + ")");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");

        if (getConfig().getBoolean("metrics")) {
            bStatsMetrics(12803);
        }

        if (getConfig().getBoolean("updateChecker")) {
            if (checkUpdateSpigot(96161)) {
                Bukkit.getConsoleSender().sendMessage(InstaKillMobs.getInstance().getName() + ChatColor.RED + " There is a new version available.");
                Bukkit.getConsoleSender().sendMessage(InstaKillMobs.getInstance().getName() + ChatColor.RED + " You can download it at: " + ChatColor.WHITE + "https://www.spigotmc.org/resources/perworldcommands.97003/");
            }
        }
    }

    public void onDisable() {
        reloadConfig();
        saveConfig();

        List.reloadList();
        List.saveList();

        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
        Bukkit.getConsoleSender().sendMessage(PluginDescription.getPrefixPositive() + " The plugin was disabled (Version: " + PluginDescription.getVersion() + ")");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
    }

    public static InstaKillMobs getInstance() {
        return instance;
    }
}