package fr.ziedelth.uhcrandoum.utils

import fr.ziedelth.uhcrandoum.extensions.randomMaterial
import org.bukkit.inventory.ItemStack

object GameManager {
    var isStarted = false
    val drops = mutableListOf<ItemStack>()
    val materials = randomMaterial()
}