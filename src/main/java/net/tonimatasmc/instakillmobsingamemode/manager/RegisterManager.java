package net.tonimatasmc.instakillmobsingamemode.manager;

import net.tonimatasmc.instakillmobsingamemode.InstaKillMobsInGameMode;
import net.tonimatasmc.instakillmobsingamemode.commands.Command;
import net.tonimatasmc.instakillmobsingamemode.events.Hit;
import net.tonimatasmc.instakillmobsingamemode.events.Join;
import net.tonimatasmc.instakillmobsingamemode.metrics.Metrics;
import net.tonimatasmc.instakillmobsingamemode.storage.PluginDescription;
import net.tonimatasmc.instakillmobsingamemode.utils.TabulatorCompleter;
import net.tonimatasmc.instakillmobsingamemode.utils.UpdateChecker;

import java.util.Objects;

public class RegisterManager {
    public static void register() {
        YMLManager.register();
        PluginDescription.register();
        updateChecker();

        registerCommands();
        registerTabulatorCompleter();
        registerEvents();

        registerMetrics();

        MessageManager.start();
    }

    private static void updateChecker() {
        if (Objects.equals(InstaKillMobsInGameMode.getPlugin().getConfig().getString("Config.CheckUpdate"), "true")) {
            UpdateChecker.updateChecker();
        }
    }

    private static void registerCommands() {
        Objects.requireNonNull(InstaKillMobsInGameMode.getPlugin().getCommand("instakillmobs")).setExecutor(new Command());
    }

    private static void registerTabulatorCompleter() {
        Objects.requireNonNull(InstaKillMobsInGameMode.getPlugin().getCommand("instakillmobs")).setTabCompleter(new TabulatorCompleter());
    }

    private static void registerEvents() {
        InstaKillMobsInGameMode.getPlugin().getServer().getPluginManager().registerEvents(new Hit(), InstaKillMobsInGameMode.getPlugin());
        InstaKillMobsInGameMode.getPlugin().getServer().getPluginManager().registerEvents(new Join(), InstaKillMobsInGameMode.getPlugin());
    }

    private static void registerMetrics() {
        int pluginId = 12803;

        Metrics metrics = new Metrics(InstaKillMobsInGameMode.getPlugin(), pluginId);
        metrics.addCustomChart(new Metrics.SimplePie("", () -> ""));
    }
}
