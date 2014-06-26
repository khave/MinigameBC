package me.khave.minigame.listeners;

import me.khave.minigame.Arena;
import me.khave.minigame.ArenaManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by hellehave on 24/06/14.
 */
public class PlayerLeave implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Arena a = ArenaManager.getInstance().getArena(e.getPlayer());
        if (a == null) return;
        a.removePlayer(e.getPlayer());
    }
}