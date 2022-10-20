package fr.ziedelth.uhcrandoum.utils

import org.bukkit.Bukkit
import org.bukkit.GameRule
import org.bukkit.Material
import org.bukkit.World

object WorldSettings {
    private val DISABLED_RULES = listOf(
        GameRule.NATURAL_REGENERATION,
        GameRule.DISABLE_RAIDS,
        GameRule.DO_INSOMNIA,
        GameRule.DO_DAYLIGHT_CYCLE,
        GameRule.DO_PATROL_SPAWNING,
        GameRule.DO_WEATHER_CYCLE,
    )
    private val ENABLED_RULES = listOf(
        GameRule.DO_IMMEDIATE_RESPAWN,
        GameRule.ANNOUNCE_ADVANCEMENTS,
    )
    private const val BORDER_START_SIZE = 1250.0

    /**
     * It sets the time to day, disables PVP, and sets the world border to a certain size
     */
    fun initWorlds() {
        Bukkit.getWorlds().forEach { world ->
            with(world) {
                time = 6000
                pvp = false

                DISABLED_RULES.forEach { setGameRule(it, false) }
                ENABLED_RULES.forEach { setGameRule(it, true) }

                val worldBorder = world.worldBorder
                worldBorder.setCenter(0.0, 0.0)
                worldBorder.size = BORDER_START_SIZE * 2
            }
        }
    }

    fun World.setLobby(material: Material, size: Int, y: Int = 200) {
        for (x in -size..size) {
            for (z in -size..size) {
                val block = getBlockAt(x, y, z)
                block.type = material
            }

            for (w in 1..5) {
                val i = y + w

                getBlockAt(x, i, -size).type = material
                getBlockAt(x, i, size).type = material
                getBlockAt(-size, i, x).type = material
                getBlockAt(size, i, x).type = material
            }
        }
    }
}