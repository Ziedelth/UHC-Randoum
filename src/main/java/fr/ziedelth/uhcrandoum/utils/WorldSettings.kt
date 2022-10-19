package fr.ziedelth.uhcrandoum.utils

import org.bukkit.Bukkit
import org.bukkit.GameRule

object WorldSettings {
    val RULES = listOf(GameRule.NATURAL_REGENERATION, GameRule.DISABLE_RAIDS, GameRule.DO_INSOMNIA, GameRule.DO_DAYLIGHT_CYCLE, GameRule.DO_PATROL_SPAWNING, GameRule.DO_WEATHER_CYCLE, GameRule.DO_IMMEDIATE_RESPAWN, GameRule.ANNOUNCE_ADVANCEMENTS)
    const val BORDER_START_SIZE = 1250.0

    fun initWorlds() {
        Bukkit.getWorlds().forEach { world ->
            with(world) {
                time = 6000
                pvp = false

                RULES.forEach { rule ->
                    setGameRule(rule, false)
                }

                val worldBorder = world.worldBorder
                worldBorder.setCenter(0.0, 0.0)
                worldBorder.size = BORDER_START_SIZE * 2
            }
        }
    }
}