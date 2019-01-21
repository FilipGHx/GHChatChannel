package me.filipgh_.GHChatChannel;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class GHChatChannel extends JavaPlugin implements Listener {

    ArrayList<Player> global = new ArrayList<Player>();
    ArrayList<Player> staff = new ArrayList<Player>();

    @Override
    public void onEnable() {
        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(this, this);
        getLogger().info("[GHChatChannel] GHChatChannel has been ENABLED!");

        Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {

            public void run() {
                for(Player p : Bukkit.getOnlinePlayers()){
                    if(global.contains(p)){

                    }

                }

            }
        });
    }

    @Override
    public void onDisable() {
        getLogger().info("[GHChatChannel] GHChatChannel has been DISABLED!");
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if(global.contains(p)){

            e.setCancelled(true);

            for(Player global : global){
                global.sendMessage("<GLOBAL> " + "<" + p.getName() + "> " + e.getMessage());
            }

            return;
        }

        if(staff.contains(p)){

            e.setCancelled(true);

            for(Player global : global){
                global.sendMessage("<GLOBAL> " + "<" + p.getName() + "> " + e.getMessage());

            return;
        }

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        Player p = (Player) sender;

        if (commandLabel.equalsIgnoreCase("")){

        }

        return false;

    }

}
