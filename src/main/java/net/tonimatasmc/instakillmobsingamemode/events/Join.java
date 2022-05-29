package net.tonimatasmc.instakillmobsingamemode.events;

import net.tonimatasmc.instakillmobsingamemode.storage.yml.List;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if ((List.getList().getString("Players." + player.getName() + ".InstaKillMobsInCreative") == null) || (List.getList().getString("Players." + player.getName() + ".InstaKillMobsInSurvival") == null) || (List.getList().getString("Players." + player.getName() + ".InstaKillMobsInAdventure") == null)) {
            List.getList().set("Players." + player.getName() + ".InstaKillMobsInCreative", false);
            List.getList().set("Players." + player.getName() + ".InstaKillMobsInSurvival", false);
            List.getList().set("Players." + player.getName() + ".InstaKillMobsInAdventure", false);
            List.saveList();
            List.reloadList();
        }
    }
}
