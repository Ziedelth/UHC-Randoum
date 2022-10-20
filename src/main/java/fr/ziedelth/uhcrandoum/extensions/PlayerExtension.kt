package fr.ziedelth.uhcrandoum.extensions

import fr.ziedelth.uhcrandoum.utils.Team
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Sound
import org.bukkit.entity.Player
import java.util.UUID

private val players = mutableMapOf<UUID, UHCPlayer>()

/**
 * Play a sound to all online players.
 *
 * @param sound The sound to play.
 * @param volume The volume of the sound.
 * @param pitch The pitch of the sound.
 */
fun playSound(sound: Sound, volume: Float = 1.0F, pitch: Float = 1.0F) {
    Bukkit.getOnlinePlayers().forEach { it.playSound(it.location, sound, volume, pitch) }
}

fun Player.getUHCPlayer() = players[this.uniqueId] ?: run {
    val newPlayer = UHCPlayer(this)
    players[this.uniqueId] = newPlayer
    newPlayer
}

class UHCPlayer(private val player: Player) {
    var isDead = false
    var deathLocation: Location? = null
    var kills = 0
    var team: Team? = null
}