package me.khave.minigame.listeners;

import me.khave.minigame.ArenaManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by hellehave on 24/06/14.
 */
public class PlayerDeath implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        if (ArenaManager.getInstance().getArena(e.getEntity()) == null) return;
        ArenaManager.getInstance().getArena(e.getEntity()).removePlayer(e.getEntity());
    }
}