package net.tonimatasdev.instakillmobs;

import net.tonimatasdev.instakillmobs.commands.PrimaryCommand;
import net.tonimatasdev.instakillmobs.events.Hit;
import net.tonimatasdev.instakillmobs.metrics.Metrics;
import net.tonimatasdev.instakillmobs.util.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class InstaKillMobs extends JavaPlugin {
    private static InstaKillMobs instance;

    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        Objects.requireNonNull(getCommand("instakillmobs")).setExecutor(new PrimaryCommand());

        getServer().getPluginManager().registerEvents(new Hit(), this);

        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
        Bukkit.getConsoleSender().sendMessage("[InstaKillMobs] The plugin was activated (Version: " + this.getDescription().getVersion() + ")");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");

        if (getConfig().getBoolean("metrics")) {
            new Metrics(this, 12803);
        }

        if (getConfig().getBoolean("updateChecker")) {
            UpdateChecker.check();
        }
    }

    public void onDisable() {
        reloadConfig();

        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
        Bukkit.getConsoleSender().sendMessage("[InstaKillMobs] The plugin was disabled (Version: " + this.getDescription().getVersion() + ")");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
    }

    public static InstaKillMobs getInstance() {
        return instance;
    }
}