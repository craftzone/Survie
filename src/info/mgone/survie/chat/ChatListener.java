package info.mgone.survie.chat;

import info.mgone.survie.Survie;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class ChatListener implements org.bukkit.event.Listener  {
	
	String Guide = "§a[Guide]§f";
	String Modo = "§d[Modo]§f";
	String ModoSup = "§5[Modo-Sup§f";
	

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (event.isCancelled()) {
            return;
        }

        final Player player = event.getPlayer();

        String message = Survie.plugin.getConfig().getString("message-format");
        String chatMessage = event.getMessage();
        

        message = replacePlayerPlaceholders(player, message);
        message = colorize(message);
        
        if(!player.hasPermission("chat.k")) {
            message.replaceAll("&k", "");
        }

        if (player.hasPermission("chat.color")) {
            chatMessage = colorize(chatMessage);
        }

        message = message.replace("%message", "%2$s");

        event.setFormat(message);

        event.setMessage(chatMessage);
        

    }
	
	
    public String colorize(String string) {
        if (string == null) {
            return "";
        }
        
        return string.replaceAll("&([a-z0-9])", "\u00A7$1");
    }
	
    
    public String replacePlayerPlaceholders(Player p, String format) {
        	
        	if(p.isOp())  return format.replaceAll("%prefix", Survie.chat.getPlayerPrefix(p))
                    .replaceAll("%suffix", Survie.chat.getPlayerSuffix(p))
                    .replaceAll("%player", p.getName())
                    .replaceAll("%displayname", p.getDisplayName())
                    .replaceAll("%group", Survie.chat.getPrimaryGroup(p));
        	
        	if(p.hasPermission("grade.Guide")) return format.replaceAll("%prefix", Guide).replaceAll("%player", p.getName());
        	else if(p.hasPermission("grade.Modo")) return format.replaceAll("%prefix", Modo).replaceAll("%player", p.getName());
        	else if(p.hasPermission("grade.ModoSup")) return format.replaceAll("%prefix", ModoSup).replaceAll("%player", p.getName());

        	else return format.replaceAll("%prefix", Survie.chat.getPlayerPrefix(p))
                    .replaceAll("%suffix", Survie.chat.getPlayerSuffix(p))
                    .replaceAll("%player", p.getName())
                    .replaceAll("%displayname", p.getDisplayName())
                    .replaceAll("%group", Survie.chat.getPrimaryGroup(p));


    }

    
 

}
