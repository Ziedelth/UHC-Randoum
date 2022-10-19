package fr.ziedelth.uhcrandoum

import fr.ziedelth.uhcrandoum.utils.WorldSettings
import org.bukkit.plugin.java.JavaPlugin

class UhcRandoum : JavaPlugin() {
    override fun onEnable() {
        WorldSettings.initWorlds()
    }
}