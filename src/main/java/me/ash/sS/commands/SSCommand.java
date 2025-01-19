package me.ash.sS.commands;

import me.ash.sS.utils.GUIManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SSCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player player) {
            // Open the Screenshare GUI for the player
            GUIManager.openFreezeGUI(player);
            return true;
        } else {
            sender.sendMessage("This command can only be executed by a player.");
            return false;
        }
    }
}
