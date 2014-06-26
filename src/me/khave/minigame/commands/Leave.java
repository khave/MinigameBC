package me.khave.minigame.commands;

import me.khave.minigame.ArenaManager;
import me.khave.minigame.MessageManager;
import org.bukkit.entity.Player;

public class Leave extends MagicCommand {

    public void onCommand(Player p, String[] args) {
        if (ArenaManager.getInstance().getArena(p) == null) {
            MessageManager.getInstance().msg(p, MessageManager.MessageType.BAD, "You are not already in an arena!");
            return;
        }

        ArenaManager.getInstance().getArena(p).removePlayer(p);
    }

    public Leave() {
        super("Leave an arena.", "", "l");
    }
}