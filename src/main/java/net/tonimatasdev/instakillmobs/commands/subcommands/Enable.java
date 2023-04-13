package net.tonimatasdev.instakillmobs.commands.subcommands;

import net.tonimatasdev.devlib.api.command.subcommands.SubCommand;
import net.tonimatasdev.devlib.api.command.subcommands.SubCommandTypes;
import net.tonimatasdev.instakillmobs.InstaKillMobs;
import net.tonimatasdev.instakillmobs.storage.PluginDescription;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class Enable extends SubCommand {
    @Override
    public boolean execute(CommandSender sender, Command command, String label, String[] args) {
        org.bukkit.entity.Player target = Bukkit.getPlayer(args[1]);

        InstaKillMobs.playerData.get().set(sender.getName() + "." + args[0], true);
        InstaKillMobs.playerData.save();
        InstaKillMobs.playerData.reload();

        assert target != null;

        if (sender.getName().equals(target.getName())) {
            target.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in " + args[0] + " is enabled for you");
        } else {
            sender.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in " + args[0] + " is:" + ChatColor.DARK_GREEN + " enabled" + ChatColor.WHITE + (" for %target%").replace("%target%", args[1]));
            target.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in " + args[0] + " is enabled for you");
        }

        return false;
    }

    @Override
    public String getName() {
        return "enable";
    }

    @Override
    public ArrayList<SubCommand> getSubCommands() {
        return null;
    }

    @Override
    public SubCommandTypes getType() {
        return SubCommandTypes.NORMAL;
    }

    @Override
    public String getPermission() {
        return null;
    }
}
