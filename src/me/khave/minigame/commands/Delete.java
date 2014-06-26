package me.khave.minigame.commands;

import me.khave.minigame.Arena;
import me.khave.minigame.ArenaManager;
import me.khave.minigame.MessageManager;
import me.khave.minigame.SettingsManager;
import org.bukkit.entity.Player;

public class Delete extends MagicCommand {

    public void onCommand(Player p, String[] args) {
        if (args.length == 0) {
            MessageManager.getInstance().msg(p, MessageManager.MessageType.BAD, "You must specify an arena number!");
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

        if (a.getState() == Arena.ArenaState.STARTED) {
            MessageManager.getInstance().msg(p, MessageManager.MessageType.BAD, "Arena " + id + " is ingame!");
            return;
        }

        SettingsManager.getArenas().set("arenas." + id + "", null);

        ArenaManager.getInstance().setupArenas();

        MessageManager.getInstance().msg(p, MessageManager.MessageType.GOOD, "Deleted arena " + id + "!");
    }

    public Delete() {
        super("Delete an arena.", "<id>", "d");
    }
}
