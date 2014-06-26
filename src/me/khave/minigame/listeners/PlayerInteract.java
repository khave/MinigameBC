package me.khave.minigame.listeners;

import me.khave.minigame.Arena;
import me.khave.minigame.ArenaManager;
import me.khave.minigame.MessageManager;
import me.khave.minigame.Wand;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        if (ArenaManager.getInstance().getArena(e.getPlayer()) == null) return;
        if (!(e.getAction() == Action.RIGHT_CLICK_AIR) && !(e.getAction() == Action.RIGHT_CLICK_BLOCK)) return;
        if (!(e.getPlayer().getItemInHand().getType() == Material.STICK)) return;

        ItemMeta stickMeta = e.getItem().getItemMeta();

        for (Wand w : Wand.values()) {
            if (stickMeta.getDisplayName().equals(w.getFullName())) {
                if (ArenaManager.getInstance().getArena(e.getPlayer()).getState() != Arena.ArenaState.STARTED) {
                    MessageManager.getInstance().msg(e.getPlayer(), MessageManager.MessageType.BAD, "You can't use your wand until the battle starts.");
                }
                e.setCancelled(true);
                w.run(e);
            }
        }
    }
}