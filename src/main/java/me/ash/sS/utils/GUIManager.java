package me.ash.sS.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class GUIManager implements Listener {

    public static void openFreezeGUI(Player player) {
        // Create the GUI
        Inventory gui = Bukkit.createInventory(null, 9, Component.text("Screenshare Menu", NamedTextColor.RED));

        // Item 1: Steps to Screenshare
        ItemStack steps = createItem(Material.BOOK, "§6Steps to Screenshare",
                List.of(
                        "§7➤ §aJoin our §bDiscord §aserver:",
                        "   §ehttps://discord.gg/yourserver",
                        "§7➤ §aJoin the §dScreenshare VC.",
                        "§7➤ §aShare your screen.",
                        "§7➤ §aDownload §6AnyDesk §aif asked."
                ));
        gui.setItem(2, steps);

        // Item 2: Reasons for Freeze
        ItemStack reasons = createItem(Material.PAPER, "§6Reasons for Freeze",
                List.of(
                        "§7➤ §cSuspicious movement detected.",
                        "§7➤ §cUnusual activity flagged by alerts.",
                        "§7➤ §cReports from other players."
                ));
        gui.setItem(4, reasons);

        // Item 3: Policy Details
        ItemStack policy = createItem(Material.BARRIER, "§6Policy Details",
                List.of(
                        "§7➤ §eDo not leave the game while frozen.",
                        "§7➤ §eDownload our Minecraft scanner.",
                        "§7➤ §eFollow required commands.",
                        "§7➤ §eRefusal results in a ban.",
                        "§7➤ §eFollow staff instructions."
                ));
        gui.setItem(6, policy);

        // Open the GUI
        player.openInventory(gui);
    }

    private static ItemStack createItem(Material material, String name, List<String> lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.displayName(Component.text(name));
            meta.lore(lore.stream()
                    .map(Component::text)
                    .collect(Collectors.toList()));
            item.setItemMeta(meta);
        }
        return item;
    }

    @EventHandler
    public static void handleGUIClick(@NotNull InventoryClickEvent event) {
        // Ensure this is the Screenshare Menu
        if (event.getView().title().equals(Component.text("Screenshare Menu"))) {
            // Cancel the event to prevent item movement, dragging, or taking items
            event.setCancelled(true);

            // Check if the current item is not null or AIR
            if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) {
                return;
            }

            Player player = (Player) event.getWhoClicked();
            switch (event.getCurrentItem().getType()) {
                case BOOK -> {
                    player.closeInventory();
                    player.sendMessage("§6Steps to Screenshare:");
                    player.sendMessage("§7➤ §aJoin our §bDiscord §aserver:");
                    player.sendMessage("   §ehttps://discord.gg/yourserver");
                    player.sendMessage("§7➤ §aJoin the §dScreenshare VC.");
                    player.sendMessage("§7➤ §aShare your screen.");
                    player.sendMessage("§7➤ §aDownload §6AnyDesk §aif asked.");
                }
                case PAPER -> {
                    player.closeInventory();
                    player.sendMessage("§6Reasons for Freeze:");
                    player.sendMessage("§7➤ §cSuspicious movement detected.");
                    player.sendMessage("§7➤ §cUnusual activity flagged by alerts.");
                    player.sendMessage("§7➤ §cReports from other players.");
                }
                case BARRIER -> {
                    player.closeInventory();
                    player.sendMessage("§6Policy Details:");
                    player.sendMessage("§7➤ §eDo not leave the game while frozen.");
                    player.sendMessage("§7➤ §eDownload our Minecraft scanner.");
                    player.sendMessage("§7➤ §eFollow required commands.");
                    player.sendMessage("§7➤ §eRefusal results in a ban.");
                    player.sendMessage("§7➤ §eFollow staff instructions.");
                }
                default -> {
                    // No break needed here, just cancel
                }
            }
        }
    }
}
