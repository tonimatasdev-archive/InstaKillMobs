package net.tonimatasdev.instakillmobs;

import net.tonimatasdev.devlib.api.DevPlugin;
import net.tonimatasdev.devlib.api.config.Config;
import net.tonimatasdev.instakillmobs.commands.PrimaryCommand;
import net.tonimatasdev.instakillmobs.events.Hit;
import net.tonimatasdev.instakillmobs.events.Join;
import net.tonimatasdev.instakillmobs.storage.PluginDescription;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class InstaKillMobs extends DevPlugin {
    private static InstaKillMobs instance;
    public static Config playerData;

    public void onEnable() {
        instance = this;
        saveDefaultConfig();

        playerData = new Config("data\\players.yml", instance);
        playerData.register();

        PluginDescription.register();

        registerCommand(new PrimaryCommand());

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

        playerData.reload();
        playerData.save();

        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
        Bukkit.getConsoleSender().sendMessage(PluginDescription.getPrefixPositive() + " The plugin was disabled (Version: " + PluginDescription.getVersion() + ")");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "<---------------------------------------->");
    }

    public static InstaKillMobs getInstance() {
        return instance;
    }
}