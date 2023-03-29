package net.tonimatasdev.instakillmobs.events;

import net.tonimatasdev.instakillmobs.InstaKillMobs;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        FileConfiguration data = InstaKillMobs.playerData.get();

        if (data.getString(event.getPlayer().getName() + ".creative") == null) return;
        if (data.getString(event.getPlayer().getName() + ".survival") == null) return;
        if (data.getString(event.getPlayer().getName() + ".adventure") == null) return;

        data.set(event.getPlayer().getName() + ".creative", false);
        data.set(event.getPlayer().getName() + ".survival", false);
        data.set(event.getPlayer().getName() + ".adventure", false);

        InstaKillMobs.playerData.save();
        InstaKillMobs.playerData.reload();
    }
}
