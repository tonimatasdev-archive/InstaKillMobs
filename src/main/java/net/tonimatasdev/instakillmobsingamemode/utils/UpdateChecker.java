package net.tonimatasdev.instakillmobsingamemode.utils;

import net.tonimatasdev.instakillmobsingamemode.InstaKillMobsInGameMode;
import net.tonimatasdev.instakillmobsingamemode.storage.PluginDescription;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateChecker {
    public static void updateChecker() {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("https://api.spigotmc.org/legacy/update.php?resource=96185").openConnection();
            int timed_out = 1250;

            connection.setConnectTimeout(timed_out);
            connection.setReadTimeout(timed_out);

            String latestVersion = (new BufferedReader(new InputStreamReader(connection.getInputStream()))).readLine();

            int latestVersionNumbers = Integer.parseInt(latestVersion.replaceAll("\\.", ""));
            int pluginVersion = Integer.parseInt(InstaKillMobsInGameMode.getInstance().getDescription().getVersion().replaceAll("\\.", ""));

            if (latestVersionNumbers > pluginVersion) {
                Bukkit.getConsoleSender().sendMessage(PluginDescription.getPrefixNegative() + " There is a new version available. " + ChatColor.YELLOW + "(" + ChatColor.GRAY + latestVersion + ChatColor.YELLOW + ")");
                Bukkit.getConsoleSender().sendMessage(PluginDescription.getPrefixNegative() + " You can download it at: " + ChatColor.WHITE + "https://www.spigotmc.org/resources/instakillmobsgamemode.96185");
            }
        } catch (Exception var3) {
            Bukkit.getConsoleSender().sendMessage(PluginDescription.getPrefixNegative() + " Error while checking update.");
        }
    }
}
