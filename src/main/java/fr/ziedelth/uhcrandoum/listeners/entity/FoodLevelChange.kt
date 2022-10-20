package fr.ziedelth.uhcrandoum.listeners.entity

import fr.ziedelth.uhcrandoum.utils.GameManager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.FoodLevelChangeEvent

class FoodLevelChange : Listener {
    @EventHandler
    fun onFoodLevelChange(event: FoodLevelChangeEvent) {
        if (GameManager.isStarted) return

        event.foodLevel = 20
        event.isCancelled = true
    }
}
