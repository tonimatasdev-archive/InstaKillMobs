package net.tonimatasdev.instakillmobsingamemode.utils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TabulatorCompleter implements org.bukkit.command.TabCompleter {

    private boolean hasPermission(CommandSender sender) {
        if (!(sender instanceof Player)) {
            return true;
        } else {
            return sender.hasPermission("instakillmobsingamemode");
        }
    }

    @Override
    public List<String> onTabComplete(@Nullable CommandSender sender, Command cmd, @Nullable String alias, @Nullable String[] args) {
        if (cmd.getName().equalsIgnoreCase("instakillmobs")) {
            List<String> argList = new ArrayList<>();

            assert args != null;

            if (args.length == 1 && hasPermission(sender)) {
                argList.add("creative");
                argList.add("survival");
                argList.add("adventure");
                argList.add("version");
                argList.add("reload");
                return argList.stream().filter(a -> a.startsWith(args[0])).collect(Collectors.toList());
            }

            if (args.length == 2 && (args[0].equals("creative"))) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    argList.add(p.getName());
                }
                return argList;
            }

            if (args.length == 2 && (args[0].equals("survival"))) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    argList.add(p.getName());
                }
                return argList;
            }

            if (args.length == 2 && (args[0].equals("adventure"))) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    argList.add(p.getName());
                }
                return argList;
            }

            if (args.length == 3) {
                argList.add("enable");
                argList.add("disable");
                return argList;
            }
            return argList;
        }
        return null;
    }
}
