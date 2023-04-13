package net.tonimatasdev.instakillmobs.commands;

import net.tonimatasdev.devlib.api.command.Command;
import net.tonimatasdev.devlib.api.command.subcommands.SubCommand;
import net.tonimatasdev.instakillmobs.commands.subcommands.*;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimaryCommand extends Command {

    @Override
    public String getName() {
        return "instakillmobs";
    }

    @Override
    public ArrayList<SubCommand> getSubCommands() {
        return new ArrayList<>(Arrays.asList(new Adventure(), new Creative(), new Reload(), new Survival(), new Version()));
    }

    @Override
    public String getPermission() {
        return null;
    }

    @Override
    public String getNoPermissionMessage() {
        return null;
    }

    @Override
    public boolean execute(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        return true;
    }
}