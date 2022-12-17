package net.tonimatasdev.instakillmobsingamemode;

import net.tonimatasdev.instakillmobsingamemode.commands.Command;
import net.tonimatasdev.instakillmobsingamemode.events.Hit;
import net.tonimatasdev.instakillmobsingamemode.events.Join;
import net.tonimatasdev.instakillmobsingamemode.metrics.Metrics;
import net.tonimatasdev.instakillmobsingamemode.storage.PluginDescription;
import net.tonimatasdev.instakillmobsingamemode.storage.yml.Config;
import net.tonimatasdev.instakillmobsingamemode.storage.yml.List;
import net.tonimatasdev.instakillmobsingamemode.utils.TabulatorCompleter;
import net.tonimatasdev.instakillmobsingamemode.utils.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class InstaKillMobsInGameMode extends JavaPlugin implements Listener {
    private static InstaKillMobsInGameMode plugin;

    public void onEnable() {
        plugin = this;

        Config.registerConfig();
        List.registerList();

        PluginDescription.register();

        InstaKillMobsInGameMode.getPlugin().getCommand("instakillmobs").setExecutor(new Command());
        InstaKillMobsInGameMode.getPlugin().getCommand("instakillmobs").setTabCompleter(new TabulatorCompleter());
        InstaKillMobsInGameMode.getPlugin().getServer().getPluginManager().registerEvents(new Hit(), InstaKillMobsInGameMode.getPlugin());
        InstaKillMobsInGameMode.getPlugin().getServer().getPluginManager().registerEvents(new Join(), InstaKillMobsInGameMode.getPlugin());

        Metrics metrics = new Metrics(InstaKillMobsInGameMode.getPlugin(), 12803);
        metrics.addCustomChart(new Metrics.SimplePie("", () -> ""));

        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
        Bukkit.getConsoleSender().sendMessage(PluginDescription.getPrefixPositive() + " The plugin was activated (Version: " + PluginDescription.getVersion() + ")");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");

        if (InstaKillMobsInGameMode.getPlugin().getConfig().getBoolean("Config.CheckUpdate")) {
            UpdateChecker.updateChecker();
        }
    }

    public void onDisable() {
        InstaKillMobsInGameMode.getPlugin().reloadConfig();
        InstaKillMobsInGameMode.getPlugin().saveConfig();

        List.reloadList();
        List.saveList();

        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
        Bukkit.getConsoleSender().sendMessage(PluginDescription.getPrefixPositive() + " The plugin was disabled (Version: " + PluginDescription.getVersion() + ")");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
    }

    public static InstaKillMobsInGameMode getPlugin() {
        return plugin;
    }
}