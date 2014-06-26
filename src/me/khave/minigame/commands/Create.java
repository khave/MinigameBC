package me.khave.minigame.commands;

import me.khave.minigame.ArenaManager;
import me.khave.minigame.MessageManager;
import me.khave.minigame.SettingsManager;
import org.bukkit.entity.Player;

public class Create extends MagicCommand {

    public void onCommand(Player p, String[] args) {
        int id = ArenaManager.getInstance().getArenas().size() + 1;

        SettingsManager.getArenas().createConfigurationSection("arenas." + id);
        SettingsManager.getArenas().set("arenas." + id + ".numPlayers", 10);

        MessageManager.getInstance().msg(p, MessageManager.MessageType.GOOD, "Created Arena " + id + "!");

        ArenaManager.getInstance().setupArenas();
    }

    public Create() {
        super("Create an arena, ", "", "c");
    }
}