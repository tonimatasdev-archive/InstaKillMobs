package net.tonimatasmc.instakillmobsingamemode;

import net.tonimatasmc.instakillmobsingamemode.manager.RegisterManager;
import net.tonimatasmc.instakillmobsingamemode.manager.UnregisterManager;
import net.tonimatasmc.instakillmobsingamemode.storage.PluginDescription;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import tonimatasmc.instakillmobsingamemode.metrics.Metrics;
import tonimatasmc.instakillmobsingamemode.utils.TabulatorCompleter;

import java.io.File;
import java.util.Objects;

public class InstaKillMobsInGameMode extends JavaPlugin implements Listener {
    public static InstaKillMobsInGameMode plugin;

    public void onEnable() {
        RegisterManager.register();
    }

    public void onDisable() {
        UnregisterManager.unregister();
    }

    public static InstaKillMobsInGameMode getPlugin() {
        return plugin;
    }
}