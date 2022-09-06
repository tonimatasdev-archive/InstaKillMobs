package net.tonimatasdev.instakillmobsingamemode.manager;

import net.tonimatasdev.instakillmobsingamemode.commands.Command;
import net.tonimatasdev.instakillmobsingamemode.metrics.Metrics;
import net.tonimatasdev.instakillmobsingamemode.storage.PluginDescription;
import net.tonimatasdev.instakillmobsingamemode.InstaKillMobsInGameMode;
import net.tonimatasdev.instakillmobsingamemode.events.Hit;
import net.tonimatasdev.instakillmobsingamemode.events.Join;
import net.tonimatasdev.instakillmobsingamemode.utils.TabulatorCompleter;
import net.tonimatasdev.instakillmobsingamemode.utils.UpdateChecker;

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
