package fr.ziedelth.uhcrandoum.extensions

import org.bukkit.Material

fun Material.withoutLegacy(): List<Material> {
    return Material.values().filter { !it.name.startsWith("LEGACY") }
}

fun Material.randomMaterial(): Map<Material, Material> {
    val list = this.withoutLegacy()

    return list.associateWith {
        var newMaterial: Material

        do {
            newMaterial = list.random()
        } while (newMaterial == it)

        newMaterial
    }
}