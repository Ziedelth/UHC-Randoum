package fr.ziedelth.uhcrandoum

import fr.ziedelth.uhcrandoum.listeners.ListenerManager
import fr.ziedelth.uhcrandoum.utils.WorldSettings
import fr.ziedelth.uhcrandoum.utils.WorldSettings.setLobby
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.plugin.java.JavaPlugin

class UhcRandoum : JavaPlugin() {
    override fun onEnable() {
        WorldSettings.initWorlds()

        val world = Bukkit.getWorlds()[0]
        world.setLobby(Material.BARRIER, 10)

        ListenerManager(this)
    }
}