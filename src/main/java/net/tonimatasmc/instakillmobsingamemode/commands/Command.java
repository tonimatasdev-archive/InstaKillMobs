package net.tonimatasmc.instakillmobsingamemode.commands;

import net.tonimatasmc.instakillmobsingamemode.InstaKillMobsInGameMode;
import net.tonimatasmc.instakillmobsingamemode.storage.PluginDescription;
import net.tonimatasmc.instakillmobsingamemode.storage.yml.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.Objects;

public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, @Nullable org.bukkit.command.Command cmd, @Nullable String label, @Nullable String[] args) {
        if (sender.hasPermission("instakillmobsingamemode.command") || sender.hasPermission("instakillmobsingamemode.cmd")) {
            if (Objects.requireNonNull(args)[0].equalsIgnoreCase("creative")) {
                Player target = Bukkit.getPlayer(args[1]);

                if (target == null) {
                    sender.sendMessage(ChatColor.DARK_RED + "[Error]" + ChatColor.WHITE + ("The player %target% isn't online.").replace("%target%", args[1]));
                } else {
                    if (args[2].equalsIgnoreCase("enable")) {
                        List.getList().set("Players." + sender.getName() + ".InstaKillMobsInCreative", "true");
                        List.saveList();
                        List.reloadList();
                        sender.sendMessage(ChatColor.WHITE + "Insta kill mobs in creative is:" + ChatColor.DARK_GREEN + " enable" + ChatColor.WHITE + (" for %target%").replace("%target%", args[1]));
                        target.sendMessage("Insta kill mobs in creative is enabled for you");

                    }

                    if (args[2].equalsIgnoreCase("disable")) {
                        List.getList().set("Players." + sender.getName() + ".InstaKillMobsInCreative", "false");
                        List.saveList();
                        List.reloadList();
                        sender.sendMessage(ChatColor.WHITE + "Insta kill mobs in creative is:" + ChatColor.DARK_RED + " disabled" + ChatColor.WHITE + (" for %target%").replace("%target%", args[1]));
                        target.sendMessage("Insta kill mobs in creative is disabled for you");
                    }
                }
            } else {
                sender.sendMessage(ChatColor.DARK_RED + "Syntax error: " + ChatColor.WHITE + "Please use: /instakillmobs <gamemode> <player> <disable/enable>");
            }

            if (args[0].equalsIgnoreCase("survival")) {
                Player target = Bukkit.getPlayer(args[1]);

                if (target == null) {
                    sender.sendMessage(ChatColor.DARK_RED + "[Error]" + ChatColor.WHITE + ("The player %target% isn't online.").replace("%target%", args[1]));
                } else {
                    if (args[2].equalsIgnoreCase("enable")) {
                        List.getList().set("Players." + sender.getName() + ".InstaKillMobsInSurvival", "true");
                        List.saveList();
                        List.reloadList();
                        sender.sendMessage(ChatColor.WHITE + "Insta kill mobs in survival is:" + ChatColor.DARK_GREEN + " enable" + ChatColor.WHITE + (" for %target%").replace("%target%", args[1]));
                        target.sendMessage("Insta kill mobs in creative is enabled for you");

                    }

                    if (args[2].equalsIgnoreCase("disable")) {
                        List.getList().set("Players." + sender.getName() + ".InstaKillMobsInSurvival", "false");
                        List.saveList();
                        List.reloadList();
                        sender.sendMessage(ChatColor.WHITE + "Insta kill mobs in survival is:" + ChatColor.DARK_RED + " disabled" + ChatColor.WHITE + (" for %target%").replace("%target%", args[1]));
                        target.sendMessage("Insta kill mobs in creative is disabled for you");
                    }
                }
            } else {
                sender.sendMessage(ChatColor.DARK_RED + "Syntax error: " + ChatColor.WHITE + "Please use: /instakillmobs <gamemode> <player> <disable/enable>");
            }

            if (args[0].equalsIgnoreCase("adventure")) {
                Player target = Bukkit.getPlayer(args[1]);

                if (target == null) {
                    sender.sendMessage(ChatColor.DARK_RED + "[Error]" + ChatColor.WHITE + ("The player %target% isn't online.").replace("%target%", args[1]));
                } else {
                    if (args[2].equalsIgnoreCase("enable")) {
                        List.getList().set("Players." + sender.getName() + ".InstaKillMobsInAdventure", "true");
                        List.saveList();
                        List.reloadList();
                        sender.sendMessage(ChatColor.WHITE + "Insta kill mobs in adventure is:" + ChatColor.DARK_GREEN + " enable" + ChatColor.WHITE + (" for %target%").replace("%target%", args[1]));
                        target.sendMessage("Insta kill mobs in creative is enabled for you");
                    }

                    if (args[2].equalsIgnoreCase("disable")) {
                        List.getList().set("Players." + sender.getName() + ".InstaKillMobsInAdventure", "false");
                        List.saveList();
                        List.reloadList();
                        sender.sendMessage(ChatColor.WHITE + "Insta kill mobs in adventure is:" + ChatColor.DARK_RED + " disabled" + ChatColor.WHITE + (" for %target%").replace("%target%", args[1]));
                        target.sendMessage("Insta kill mobs in creative is disabled for you");
                    }
                }
            } else {
                sender.sendMessage(ChatColor.DARK_RED + "Syntax error: " + ChatColor.WHITE + "Please use: /instakillmobs <gamemode> <player> <disable/enable>");
            }

            if (args[0].equalsIgnoreCase("version")) {
                sender.sendMessage(PluginDescription.prefix + ": " + PluginDescription.version);
            }

            if (args[0].equalsIgnoreCase("reload")) {
                sender.sendMessage(ChatColor.DARK_GREEN + "The plugin has been reloaded");
                InstaKillMobsInGameMode.getPlugin().reloadConfig();
                List.reloadList();
            }
        } else {
            sender.sendMessage(ChatColor.DARK_RED + "Syntax error: " + ChatColor.WHITE + "Please use: /instakillmobs <gamemode> <player> <disable/enable>");
        }return true;
    }
}
