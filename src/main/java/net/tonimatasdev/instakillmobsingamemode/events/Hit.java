package net.tonimatasdev.instakillmobsingamemode.events;

import net.tonimatasdev.instakillmobsingamemode.storage.yml.List;
import org.bukkit.GameMode;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Hit implements Listener {
    @EventHandler
    public void onHitCreative(EntityDamageByEntityEvent event) {
        assert event.getDamager() instanceof Player;
        Player player = (Player) event.getDamager();

        if (List.getList().getBoolean("Players." + player.getName() + ".InstaKillMobsInCreative")) {
            if (player.hasPermission("instakillmobsingamemode.creative")) {
                if (player.getGameMode() == GameMode.CREATIVE) {
                    LivingEntity entity = (LivingEntity) event.getEntity();
                    entity.setHealth(0);
                }
            }
        }
    }

    @EventHandler
    public void onHitSurvival(EntityDamageByEntityEvent event) {
        assert event.getDamager() instanceof Player;
        Player player = (Player) event.getDamager();

        if (List.getList().getBoolean("Players." + player.getName() + ".InstaKillMobsInSurvival")) {
            if (player.hasPermission("instakillmobsingamemode.survival")) {
                if (player.getGameMode() == GameMode.SURVIVAL) {
                    LivingEntity entity = (LivingEntity) event.getEntity();
                    entity.setHealth(0);
                }
            }
        }
    }


    @EventHandler
    public void onHitAdventure(EntityDamageByEntityEvent event) {
        assert event.getDamager() instanceof Player;
        Player player = (Player) event.getDamager();

        if (List.getList().getBoolean("Players." + player.getName() + ".InstaKillMobsInAdventure")) {
            if (player.hasPermission("instakillmobsingamemode.adventure")) {
                if (player.getGameMode() == GameMode.ADVENTURE) {
                    LivingEntity entity = (LivingEntity) event.getEntity();
                    entity.setHealth(0);
                }
            }
        }

    }
}
