package me.khave.minigame.commands;

import me.khave.minigame.ArenaManager;
import me.khave.minigame.MessageManager;
import org.bukkit.entity.Player;

public class Reload extends MagicCommand {

    public void onCommand(Player p, String[] args) {
        ArenaManager.getInstance().setupArenas();
        MessageManager.getInstance().msg(p, MessageManager.MessageType.GOOD, "Reloaded arenas!");
    }

    public Reload() {
        super("Reload the arenas.", "", "r");
    }
}