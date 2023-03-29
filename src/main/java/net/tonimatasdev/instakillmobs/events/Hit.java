package net.tonimatasdev.instakillmobs.events;

import net.tonimatasdev.instakillmobs.InstaKillMobs;
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

        switch (player.getGameMode()) {
            case CREATIVE:
                execute(player, livingEntity, "creative");
                break;
            case SURVIVAL:
                execute(player, livingEntity, "survival");
                break;
            case ADVENTURE:
                execute(player, livingEntity, "adventure");
                break;
        }
    }

    private static void execute(Player player, LivingEntity livingEntity, String gameMode) {
        if (InstaKillMobs.playerData.get().getBoolean(player.getName() + "." + gameMode) && player.hasPermission("instakillmobs." + gameMode)) return;
        livingEntity.setHealth(0);
    }
}
