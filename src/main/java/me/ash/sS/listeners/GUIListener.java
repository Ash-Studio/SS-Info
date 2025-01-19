package me.ash.sS.listeners;

import me.ash.sS.utils.GUIManager;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().title().equals(Component.text("Screenshare Menu"))) {
            event.setCancelled(true);
            GUIManager.handleGUIClick(event);
        }
    }
}
