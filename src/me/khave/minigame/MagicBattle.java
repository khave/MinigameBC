package me.khave.minigame;

import me.khave.minigame.listeners.BlockBreak;
import me.khave.minigame.listeners.PlayerDeath;
import me.khave.minigame.listeners.PlayerInteract;
import me.khave.minigame.listeners.PlayerLeave;
import me.khave.minigame.listeners.PlayerLoseHunger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MagicBattle extends JavaPlugin {

    public void onEnable() {
//        Bukkit.getServer().getPluginManager().registerEvents(new SignManager(), this);

        ArenaManager.getInstance().setupArenas();

        getCommand("magicbattle").setExecutor(new CommandManager());

        PluginManager pm = Bukkit.getServer().getPluginManager();
        pm.registerEvents(new BlockBreak(), this);
        pm.registerEvents(new PlayerDeath(), this);
        pm.registerEvents(new PlayerInteract(), this);
        pm.registerEvents(new PlayerLeave(), this);
        pm.registerEvents(new PlayerLoseHunger(), this);
    }

    public static Plugin getPlugin() {
        return Bukkit.getServer().getPluginManager().getPlugin("MagicBattle");
    }
}