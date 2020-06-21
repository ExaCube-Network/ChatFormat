package be.exacu.Spigot;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.query.QueryOptions;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        final Player p = e.getPlayer();
        final LuckPerms api = ChatFormat.getLuckPermsApi();
        final User user = api.getUserManager().getUser(p.getUniqueId());
        final QueryOptions queryOptions = api.getContextManager().getQueryOptions(p);
        e.setFormat(ChatColor.translateAlternateColorCodes('&', String.format(
                "%s&7%s&7: &f%s", user.getCachedData().getMetaData(queryOptions).getPrefix(), p.getDisplayName(), e.getMessage()
        )));
    }

}
