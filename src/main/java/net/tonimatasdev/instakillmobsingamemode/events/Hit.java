package net.tonimatasdev.instakillmobsingamemode.events;

import net.tonimatasdev.instakillmobsingamemode.storage.yml.List;
import org.bukkit.GameMode;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Objects;

public class Hit implements Listener {
    @EventHandler
    public void onHitCreative(EntityDamageByEntityEvent event) {
        assert event.getDamager() instanceof Player;

        if (Objects.requireNonNull(List.getList().getString("Players." + event.getDamager().getName() + ".InstaKillMobsInCreative")).equals("true")) {
            if (event.getDamager().hasPermission("instakillmobsingamemode.creative")) {
                if (((Player) event.getDamager()).getGameMode() == GameMode.CREATIVE) {
                    LivingEntity entity = (LivingEntity) event.getEntity();
                    entity.setHealth(0);
                }
            }
        }
    }

    @EventHandler
    public void onHitSurvival(EntityDamageByEntityEvent event) {
        assert event.getDamager() instanceof Player;

        if (Objects.requireNonNull(List.getList().getString("Players." + event.getDamager().getName() + ".InstaKillMobsInSurvival")).equals("true")) {
            if (event.getDamager().hasPermission("instakillmobsingamemode.survival")) {
                if (((Player) event.getDamager()).getGameMode() == GameMode.SURVIVAL) {
                    LivingEntity entity = (LivingEntity) event.getEntity();
                    entity.setHealth(0);
                }
            }
        }
    }



    @EventHandler
    public void onHitAdventure(EntityDamageByEntityEvent event) {
        assert event.getDamager() instanceof Player;

        if (Objects.requireNonNull(List.getList().getString("Players." + event.getDamager().getName() + ".InstaKillMobsInAdventure")).equals("true")) {
            if (event.getDamager().hasPermission("instakillmobsingamemode.adventure")) {
                if (((Player) event.getDamager()).getGameMode() == GameMode.ADVENTURE) {
                    LivingEntity entity = (LivingEntity) event.getEntity();
                    entity.setHealth(0);
                }
            }
        }

    }
}
