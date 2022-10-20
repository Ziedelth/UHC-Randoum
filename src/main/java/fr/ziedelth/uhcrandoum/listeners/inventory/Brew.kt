package fr.ziedelth.uhcrandoum.listeners.inventory

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.BrewEvent

class Brew : Listener {
    @EventHandler
    fun onBrew(event: BrewEvent) {
        val ingredient = event.contents.ingredient?.type ?: return
        if (ingredient.isAir) return

        when (ingredient) {
            Material.GHAST_TEAR, Material.GLISTERING_MELON_SLICE, Material.GLOWSTONE_DUST -> {
                event.isCancelled = true
            }

            else -> return
        }
    }
}
