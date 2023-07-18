package net.tonimatasdev.instakillmobs.events;

import net.tonimatasdev.instakillmobs.InstaKillMobs;
import net.tonimatasdev.instakillmobs.util.PlayerData;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Hit implements Listener {
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;

        Player player = (Player) event.getDamager();
        LivingEntity livingEntity = (LivingEntity) event.getEntity();

        if (event.getEntity().getType() == EntityType.PLAYER && InstaKillMobs.getInstance().getConfig().getBoolean("insta-kill-players")) return;

        if (PlayerData.getInstaKill(player)) {
            livingEntity.setHealth(0);
        }
    }
}
