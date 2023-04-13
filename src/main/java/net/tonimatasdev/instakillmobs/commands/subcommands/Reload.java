package net.tonimatasdev.instakillmobs.commands.subcommands;

import net.tonimatasdev.devlib.api.command.subcommands.SubCommand;
import net.tonimatasdev.devlib.api.command.subcommands.SubCommandTypes;
import net.tonimatasdev.instakillmobs.InstaKillMobs;
import net.tonimatasdev.instakillmobs.storage.PluginDescription;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;

public class Reload extends SubCommand {
    @Override
    public boolean execute(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(PluginDescription.getPrefixPositive() + "The plugin has been reloaded");
        InstaKillMobs.getInstance().reloadConfig();
        InstaKillMobs.playerData.reload();
        return true;
    }

    @Override
    public String getName() {
        return "reload";
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
        return "instakillmobs.admin";
    }
}
