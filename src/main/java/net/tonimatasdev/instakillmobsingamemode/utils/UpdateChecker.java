package net.tonimatasdev.instakillmobsingamemode.utils;

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
            HttpURLConnection con = (HttpURLConnection) new URL("https://api.spigotmc.org/legacy/update.php?resource=96185").openConnection();

            con.setConnectTimeout(1250);
            con.setReadTimeout(1250);

            String latestVersion = (new BufferedReader(new InputStreamReader(con.getInputStream()))).readLine();

            if (latestVersion.length() <= 7 && !PluginDescription.getVersion().equals(latestVersion)) {
                Bukkit.getConsoleSender().sendMessage(PluginDescription.getPrefixNegative() + " There is a new version available. " + ChatColor.YELLOW + "(" + ChatColor.GRAY + latestVersion + ChatColor.YELLOW + ")");
                Bukkit.getConsoleSender().sendMessage(PluginDescription.getPrefixNegative() + " You can download it at: " + ChatColor.WHITE + "https://www.spigotmc.org/resources/instakillmobsgamemode.96185");
            }
        } catch (Exception var3) {
            Bukkit.getConsoleSender().sendMessage(PluginDescription.getPrefixNegative() + " Error while checking update.");
        }
    }
}
