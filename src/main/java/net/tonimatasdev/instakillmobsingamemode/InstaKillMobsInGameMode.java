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
    private static InstaKillMobsInGameMode instance;

    public static InstaKillMobsInGameMode getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;

        Config.registerConfig();
        List.registerList();

        PluginDescription.register();

        getCommand("instakillmobs").setExecutor(new Command());
        getCommand("instakillmobs").setTabCompleter(new TabulatorCompleter());
        getServer().getPluginManager().registerEvents(new Hit(), this);
        getServer().getPluginManager().registerEvents(new Join(), this);

        Metrics metrics = new Metrics(this, 12803);
        metrics.addCustomChart(new Metrics.SimplePie("", () -> ""));

        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
        Bukkit.getConsoleSender().sendMessage(PluginDescription.getPrefixPositive() + " The plugin was activated (Version: " + PluginDescription.getVersion() + ")");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");

        if (getConfig().getBoolean("Config.CheckUpdate")) {
            UpdateChecker.updateChecker();
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
}