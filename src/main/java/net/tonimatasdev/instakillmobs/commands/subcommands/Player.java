package net.tonimatasdev.instakillmobs.commands.subcommands;

import net.tonimatasdev.devlib.api.command.subcommands.SubCommand;
import net.tonimatasdev.devlib.api.command.subcommands.SubCommandTypes;
import net.tonimatasdev.instakillmobs.storage.PluginDescription;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;

public class Player extends SubCommand {
    @Override
    public boolean execute(CommandSender sender, Command command, String label, String[] args) {
        if (Bukkit.getPlayer(args[1]) == null) sender.sendMessage(PluginDescription.getPrefixNegative() + ("The player %target% isn't online.").replace("%target%", args[1]));
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public ArrayList<SubCommand> getSubCommands() {
        return new ArrayList<>(Arrays.asList(new Enable(), new Disable()));
    }

    @Override
    public SubCommandTypes getType() {
        return SubCommandTypes.PLAYER;
    }

    @Override
    public String getPermission() {
        return null;
    }
}
