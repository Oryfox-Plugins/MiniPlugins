package de.oryfox;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class UndoPath extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK
                && event.getItem() != null
                && event.getItem().getType().name().contains("SHOVEL")
                && event.getClickedBlock() != null
                && event.getClickedBlock().getType() == Material.DIRT_PATH) {
            event.getClickedBlock().setType(Material.DIRT);
        }
    }
}