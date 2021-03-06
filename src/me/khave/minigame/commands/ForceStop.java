package me.khave.minigame.commands;

import me.khave.minigame.Arena;
import me.khave.minigame.ArenaManager;
import me.khave.minigame.MessageManager;
import org.bukkit.entity.Player;

public class ForceStop extends MagicCommand {

    public void onCommand(Player p, String[] args) {
        if (args.length == 0) {
            MessageManager.getInstance().msg(p, MessageManager.MessageType.BAD, "You must specify an arena ID.");
            return;
        }

        int id = -1;

        try { id = Integer.parseInt(args[0]); }
        catch (Exception e) {
            MessageManager.getInstance().msg(p, MessageManager.MessageType.BAD, args[0] + " is not a valid number!");
            return;
        }

        Arena a = ArenaManager.getInstance().getArena(id);

        if (a == null) {
            MessageManager.getInstance().msg(p, MessageManager.MessageType.BAD, "There is no arena with ID " + id + "!");
            return;
        }

        if (a.getState() != Arena.ArenaState.STARTED) {
            MessageManager.getInstance().msg(p, MessageManager.MessageType.BAD, "Arena " + id + " is not running!");
            return;
        }

        a.stop();
        MessageManager.getInstance().msg(p, MessageManager.MessageType.GOOD, "Force stopped arena " + a.getID() + "!");
    }

    public ForceStop() {
        super("Force start an arena.", "<id>", "fstop", "stop");
    }
}