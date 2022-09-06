package net.tonimatasdev.instakillmobsingamemode.manager;

public class UnregisterManager {
    public static void unregister() {
        MessageManager.stop();
        YMLManager.unregister();
    }
}
