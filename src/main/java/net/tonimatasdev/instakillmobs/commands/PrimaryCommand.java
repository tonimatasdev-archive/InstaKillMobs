package net.tonimatasdev.instakillmobs.commands;

import net.tonimatasdev.devlib.api.command.Command;
import net.tonimatasdev.devlib.api.command.subcommands.SubCommand;
import net.tonimatasdev.instakillmobs.InstaKillMobs;
import net.tonimatasdev.instakillmobs.storage.PluginDescription;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class PrimaryCommand extends Command {

    @Override
    public String getName() {
        return "instakillmobs";
    }

    @Override
    public ArrayList<SubCommand> getSubCommands() {
        return null;
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
        if (sender.hasPermission("instakillmobs.command") || sender.hasPermission("instakillmobs.cmd")) {
            assert args != null;

            if (args.length > 1) {
                if (args[0].equalsIgnoreCase("creative")) {
                    if (args.length > 2) {
                        Player target = Bukkit.getPlayer(args[1]);

                        if (target == null) {
                            sender.sendMessage(PluginDescription.getPrefixPositive() + ("The player %target% isn't online.").replace("%target%", args[1]));
                        } else {
                            if (args.length == 3) {
                                if (args[2].equalsIgnoreCase("enable")) {

                                    InstaKillMobs.playerData.get().set(sender.getName() + ".creative", true);
                                    InstaKillMobs.playerData.save();
                                    InstaKillMobs.playerData.reload();

                                    if (sender.getName().equals(target.getName())) {
                                        target.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in creative is enabled for you");
                                    } else {
                                        sender.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in creative is:" + ChatColor.DARK_GREEN + " enabled" + ChatColor.WHITE + (" for %target%").replace("%target%", args[1]));
                                        target.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in creative is enabled for you");
                                    }
                                }

                                if (args[2].equalsIgnoreCase("disable")) {
                                    InstaKillMobs.playerData.get().set(sender.getName() + ".creative", false);
                                    InstaKillMobs.playerData.save();
                                    InstaKillMobs.playerData.reload();

                                    if (sender.getName().equals(target.getName())) {
                                        target.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in creative is disabled for you");
                                    } else {
                                        sender.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in creative is:" + ChatColor.DARK_GREEN + " disabled" + ChatColor.WHITE + (" for %target%").replace("%target%", args[1]));
                                        target.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in creative is disabled for you");
                                    }
                                }
                            } else {
                                sender.sendMessage(PluginDescription.getPrefixNegative() + "Please use: /instakillmobs <gamemode> <player> <disable/enable>");
                            }
                        }
                    } else {
                        sender.sendMessage(PluginDescription.getPrefixNegative() + "Please use: /instakillmobs <gamemode> <player> <disable/enable>");
                    }
                }

                if (args[0].equalsIgnoreCase("survival")) {
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
                }

                if (args[0].equalsIgnoreCase("adventure")) {
                    if (args.length > 2) {
                        Player target = Bukkit.getPlayer(args[1]);

                        if (target == null) {
                            sender.sendMessage(PluginDescription.getPrefixNegative() + ("The player %target% isn't online.").replace("%target%", args[1]));
                        } else {
                            if (args[2].equalsIgnoreCase("enable")) {
                                InstaKillMobs.playerData.get().set(sender.getName() + ".adventure", true);
                                InstaKillMobs.playerData.save();
                                InstaKillMobs.playerData.reload();

                                if (sender.getName().equals(target.getName())) {
                                    target.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in adventure is enabled for you");
                                } else {
                                    sender.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in adventure is:" + ChatColor.DARK_GREEN + " enabled" + ChatColor.WHITE + (" for %target%").replace("%target%", args[1]));
                                    target.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in adventure is enabled for you");
                                }
                            }

                            if (args.length == 3) {
                                if (args[2].equalsIgnoreCase("disable")) {
                                    InstaKillMobs.playerData.get().set("Players." + sender.getName() + ".adventure", "false");
                                    InstaKillMobs.playerData.save();
                                    InstaKillMobs.playerData.reload();

                                    if (sender.getName().equals(target.getName())) {
                                        target.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in adventure is disabled for you");
                                    } else {
                                        sender.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in adventure is:" + ChatColor.DARK_GREEN + " disabled" + ChatColor.WHITE + (" for %target%").replace("%target%", args[1]));
                                        target.sendMessage(PluginDescription.getPrefixPositive() + "Insta kill mobs in adventure is disabled for you");
                                    }
                                }
                            } else {
                                sender.sendMessage(PluginDescription.getPrefixNegative() + "Please use: /instakillmobs <gamemode> <player> <disable/enable>");
                            }
                        }
                    } else {
                        sender.sendMessage(PluginDescription.getPrefixNegative() + "Please use: /instakillmobs <gamemode> <player> <disable/enable>");
                    }
                }

                if (args[0].equalsIgnoreCase("version")) {
                    sender.sendMessage(PluginDescription.getPrefixPositive() + PluginDescription.getVersion());
                }

                if (args[0].equalsIgnoreCase("reload")) {
                    sender.sendMessage(PluginDescription.getPrefixPositive() + "The plugin has been reloaded");
                    InstaKillMobs.getInstance().reloadConfig();
                    InstaKillMobs.playerData.reload();
                }
            } else {
                sender.sendMessage(PluginDescription.getPrefixNegative() + "Please use: /instakillmobs <gamemode/reload/version>");
            }
        } else {
            sender.sendMessage(PluginDescription.getPrefixNegative() + "Please use: /instakillmobs <gamemode/reload/version>");
        }
        return true;
    }
}