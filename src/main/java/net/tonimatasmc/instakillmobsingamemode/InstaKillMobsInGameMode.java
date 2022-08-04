package net.tonimatasmc.instakillmobsingamemode;

import net.tonimatasmc.instakillmobsingamemode.manager.RegisterManager;
import net.tonimatasmc.instakillmobsingamemode.manager.UnregisterManager;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class InstaKillMobsInGameMode extends JavaPlugin implements Listener {
    public static InstaKillMobsInGameMode plugin;

    public static InstaKillMobsInGameMode getPlugin() {
        return plugin;
    }

    public void onEnable() {
        plugin = this;
        RegisterManager.register();
    }

    public void onDisable() {
        UnregisterManager.unregister();
    }
}