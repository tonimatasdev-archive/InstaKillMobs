package net.tonimatasdev.instakillmobs.events;

import net.tonimatasdev.instakillmobs.InstaKillMobs;
import net.tonimatasdev.instakillmobs.util.PlayerData;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class Hit implements Listener {
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;

        Player player = (Player) event.getDamager();
        if (event.getEntity().getType() == EntityType.PLAYER && InstaKillMobs.getInstance().getConfig().getBoolean("insta-kill-players")) return;

        if (PlayerData.getInstaKill(player)) {
            event.setDamage(Integer.MAX_VALUE);
        }
    }

    @EventHandler
    private void onEntityDeath(EntityDeathEvent event) {
        Player player = event.getEntity().getKiller();

        if (player == null) return;

        if (PlayerData.getInstaKill(player)) {
            if (!InstaKillMobs.getInstance().getConfig().getBoolean("drop-items")) event.getDrops().clear();
            if (!InstaKillMobs.getInstance().getConfig().getBoolean("drop-exp")) event.setDroppedExp(0);
        }
    }
}
