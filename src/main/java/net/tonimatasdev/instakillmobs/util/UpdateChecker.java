package net.tonimatasdev.instakillmobs.util;

import net.tonimatasdev.instakillmobs.InstaKillMobs;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateChecker {
    public static void check() {
        PluginDescriptionFile info = InstaKillMobs.getInstance().getDescription();

        try {
            // Get version of Spigot API.
            HttpURLConnection connection = (HttpURLConnection) (new URL("https://api.spigotmc.org/legacy/update.php?resource=96185")).openConnection();
            int timed_out = 1250;

            connection.setConnectTimeout(timed_out);
            connection.setReadTimeout(timed_out);

            String latestVersion = (new BufferedReader(new InputStreamReader(connection.getInputStream()))).readLine();

            // Convert strings to number.
            int latestVersionNumbers = Integer.parseInt(latestVersion.replaceAll("\\.", ""));
            int pluginVersion = Integer.parseInt(info.getVersion().replaceAll("\\.", ""));

            // If the plugin is not up-to-date, send a message with the link to update it.
            if (latestVersionNumbers > pluginVersion) {
                Bukkit.getConsoleSender().sendMessage(info.getName() + ChatColor.RED + " There is a new version available. " + ChatColor.YELLOW + "(" + ChatColor.GRAY + latestVersion + ChatColor.YELLOW + ")");
                Bukkit.getConsoleSender().sendMessage(info.getName() + ChatColor.RED + " You can download it at: " + ChatColor.WHITE + "https://www.spigotmc.org/resources/instakillmobs.96185/");
            }
        } catch (Exception var3) {
            Bukkit.getConsoleSender().sendMessage(info.getName() + ChatColor.RED + " Error while checking update.");
        }
    }
}
