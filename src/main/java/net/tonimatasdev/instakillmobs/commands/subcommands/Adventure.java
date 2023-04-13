package net.tonimatasdev.instakillmobs.commands.subcommands;

import net.tonimatasdev.devlib.api.command.subcommands.SubCommand;
import net.tonimatasdev.devlib.api.command.subcommands.SubCommandTypes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Collections;

public class Adventure extends SubCommand {
    @Override
    public boolean execute(CommandSender sender, Command command, String label, String[] args) {
        return true;
    }

    @Override
    public String getName() {
        return "adventure";
    }

    @Override
    public ArrayList<SubCommand> getSubCommands() {
        return new ArrayList<>(Collections.singletonList(new Player()));
    }

    @Override
    public SubCommandTypes getType() {
        return SubCommandTypes.NORMAL;
    }

    @Override
    public String getPermission() {
        return "instakillmobs.adventure";
    }
}
