package me.khave.minigame.listeners;


import me.khave.minigame.ArenaManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if (ArenaManager.getInstance().getArena(e.getPlayer()) == null) return;
        e.setCancelled(true);
    }
}