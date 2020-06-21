package be.exacu.Spigot;

import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatFormat extends JavaPlugin {

    private static LuckPerms luckPermsApi;

    public void onEnable(){

        RegisteredServiceProvider<LuckPerms> luckPermsProvider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        luckPermsApi = luckPermsProvider.getProvider();

        getServer().getPluginManager().registerEvents(new ChatListener(), this);

        getLogger().info("(!) ExaCube Network Chat Format Loaded");
    }

    public void onDisable(){
        getLogger().info("(!) ExaCube Network Chat Format Unloaded");
    }

    public static LuckPerms getLuckPermsApi() {
        return luckPermsApi;
    }

}
