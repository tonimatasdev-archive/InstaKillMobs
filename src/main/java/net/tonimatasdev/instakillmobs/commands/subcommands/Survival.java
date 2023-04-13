package net.tonimatasdev.instakillmobs.commands.subcommands;

import net.tonimatasdev.devlib.api.command.subcommands.SubCommand;
import net.tonimatasdev.devlib.api.command.subcommands.SubCommandTypes;
import net.tonimatasdev.instakillmobs.InstaKillMobs;
import net.tonimatasdev.instakillmobs.storage.PluginDescription;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;

public class Survival extends SubCommand {
    @Override
    public boolean execute(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 2) {
            Player target = Bukkit.getPlayer(args[1]);

            if (target == null) {
                sender.sendMessage(PluginDescription.getPrefixNegative() + ("The player %target% isn't online.").replace("%target%", args[1]));
            } else {
                if (args.length == 3) {
                    if (args[2].equalsIgnoreCase("enable")) {
                        InstaKillMobs.playerData.get().set(sender.getName() + ".survival", true);
                        InstaKillMobs.playerData.save();
                        InstaKillMobs.playerData.reload();

                        if (sender.getName().equals(target.getName())) {
                            target.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in survival is enabled for you");
                        } else {
                            sender.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in survival is:" + ChatColor.DARK_GREEN + " enable" + ChatColor.WHITE + (" for %target%").replace("%target%", args[1]));
                            target.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in survival is enabled for you");
                        }
                    }

                    if (args[2].equalsIgnoreCase("disable")) {
                        InstaKillMobs.playerData.get().set(sender.getName() + ".survival", false);
                        InstaKillMobs.playerData.save();
                        InstaKillMobs.playerData.reload();

                        if (sender.getName().equals(target.getName())) {
                            target.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in survival is disabled for you");
                        } else {
                            sender.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in survival is:" + ChatColor.DARK_GREEN + " disabled" + ChatColor.WHITE + (" for %target%").replace("%target%", args[1]));
                            target.sendMessage(PluginDescription.getPrefixNegative() + "Insta kill mobs in survival is disabled for you");
                        }
                    }
                } else {
                    sender.sendMessage(PluginDescription.getPrefixNegative() + "Please use: /instakillmobs <gamemode> <player> <disable/enable>");
                }
            }
        } else {
            sender.sendMessage(PluginDescription.getPrefixNegative() + "Please use: /instakillmobs <gamemode> <player> <disable/enable>");
        }

        return true;
    }

    @Override
    public String getName() {
        return "survival";
    }

    @Override
    public ArrayList<SubCommand> getSubCommands() {
        return new ArrayList<>(Collections.singletonList(new net.tonimatasdev.instakillmobs.commands.subcommands.Player()));
    }

    @Override
    public SubCommandTypes getType() {
        return SubCommandTypes.NORMAL;
    }

    @Override
    public String getPermission() {
        return "instakillmobs.survival";
    }
}
