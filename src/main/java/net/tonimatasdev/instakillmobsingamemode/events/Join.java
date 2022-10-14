package net.tonimatasdev.instakillmobsingamemode.events;

import net.tonimatasdev.instakillmobsingamemode.storage.yml.List;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if ((List.getList().getString("Players." + event.getPlayer().getName() + ".InstaKillMobsInCreative") == null) || (List.getList().getString("Players." + event.getPlayer().getName() + ".InstaKillMobsInSurvival") == null) || (List.getList().getString("Players." + event.getPlayer().getName() + ".InstaKillMobsInAdventure") == null)) {
            List.getList().set("Players." + event.getPlayer().getName() + ".InstaKillMobsInCreative", false);
            List.getList().set("Players." + event.getPlayer().getName() + ".InstaKillMobsInSurvival", false);
            List.getList().set("Players." + event.getPlayer().getName() + ".InstaKillMobsInAdventure", false);
            List.saveList();
            List.reloadList();
        }
    }
}
