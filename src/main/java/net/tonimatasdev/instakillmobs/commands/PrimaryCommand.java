package net.tonimatasdev.instakillmobs.commands;

import net.tonimatasdev.instakillmobs.util.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrimaryCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            if (sender.hasPermission("instakillmobs.other")) return true;

            Player target = Bukkit.getPlayer(args[0]);
            if (target == null) return true;

            if (PlayerData.getInstaKill(target)) {
                PlayerData.removeToInstaKill(target);
                sender.sendMessage("You have disabled Insta-Kill mode for " + target.getName());
                target.sendMessage(sender.getName() + " has disabled Insta-Kill mode for you.");
            } else {
                PlayerData.addToInstaKill(target);
                sender.sendMessage("You have enabled Insta-Kill mode for " + target.getName());
                target.sendMessage(sender.getName() + " has enabled Insta-Kill mode for you.");
            }
        } else {
            if (!(sender instanceof Player)) return true;
            if (sender.hasPermission("instakillmobs.me")) return true;

            Player player = (Player) sender;

            if (PlayerData.getInstaKill(player)) {
                PlayerData.removeToInstaKill(player);
                player.sendMessage("You have disabled Insta-Kill mode for you");
            } else {
                PlayerData.addToInstaKill(player);
                player.sendMessage("You have enabled Insta-Kill mode for you");
            }
        }

        return false;
    }
}