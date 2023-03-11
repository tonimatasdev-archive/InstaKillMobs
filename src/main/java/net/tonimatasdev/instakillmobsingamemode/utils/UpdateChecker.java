package net.tonimatasdev.instakillmobsingamemode.utils;

import net.tonimatasdev.instakillmobsingamemode.InstaKillMobs;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateChecker {
    public static void check() {
        try {
            HttpURLConnection connection = (HttpURLConnection) (new URL("https://api.spigotmc.org/legacy/update.php?resource=96161")).openConnection();
            int timed_out = 1250;

            connection.setConnectTimeout(timed_out);
            connection.setReadTimeout(timed_out);

            String latestVersion = (new BufferedReader(new InputStreamReader(connection.getInputStream()))).readLine();

            int latestVersionNumbers = Integer.parseInt(latestVersion.replaceAll("\\.", ""));
            int pluginVersion = Integer.parseInt(InstaKillMobs.getInstance().getDescription().getVersion().replaceAll("\\.", ""));

            if (latestVersionNumbers > pluginVersion) {
                Bukkit.getConsoleSender().sendMessage(InstaKillMobs.getInstance().getName() + ChatColor.RED + " There is a new version available. " + ChatColor.YELLOW + "(" + ChatColor.GRAY + latestVersion + ChatColor.YELLOW + ")");
                Bukkit.getConsoleSender().sendMessage(InstaKillMobs.getInstance().getName() + ChatColor.RED + " You can download it at: " + ChatColor.WHITE + "https://www.spigotmc.org/resources/perworldcommands.97003/");
            }
        } catch (Exception var3) {
            Bukkit.getConsoleSender().sendMessage(InstaKillMobs.getInstance().getName() + ChatColor.RED + " Error while checking update.");
        }
    }
}
