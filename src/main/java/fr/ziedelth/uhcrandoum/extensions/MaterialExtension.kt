package fr.ziedelth.uhcrandoum.extensions

import fr.ziedelth.uhcrandoum.utils.Submod
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

/**
 * It's creating a list of all materials without legacy materials.
 */
fun withoutLegacy() = Material.values().filter { !it.name.startsWith("LEGACY") }

/**
 * It's creating a map of all materials without legacy materials and associate them with a random material.
 */
fun randomMaterial(): Map<Material, Material> {
    val list = withoutLegacy()

    return list.associateWith {
        var newMaterial: Material

        do {
            newMaterial = list.random()
        } while (
            newMaterial == it ||
            (Submod.isSubmod(Submod.RANDOM_LOOT) && newMaterial.isNotValidLoot) ||
            (Submod.isSubmod(Submod.RANDOM_CRAFT) && newMaterial.isNotValidCraft)
        )

        newMaterial
    }
}

fun Material.toItemStack(): ItemStack = ItemStack(this, 1)

/**
 * It's checking if the material is not valid loot.
 */
val Material.isNotValidLoot: Boolean
    get() = isAir ||
            isSpawnEgg ||
            isPotion ||
            isDisc ||
            isCommandBlock ||
            isHead ||
            isBannerPattern ||
            isPottedPlant ||
            isAttached ||
            when (this) {
                Material.NETHER_PORTAL,
                Material.END_PORTAL,
                Material.END_PORTAL_FRAME,
                Material.ENCHANTED_BOOK,
                Material.DEBUG_STICK,
                Material.TOTEM_OF_UNDYING,
                Material.NETHER_STAR,
                Material.ENCHANTED_GOLDEN_APPLE,
                Material.SPAWNER,
                Material.KNOWLEDGE_BOOK,
                Material.BEDROCK,
                Material.BARRIER,
                Material.TIPPED_ARROW,
                Material.END_CRYSTAL,
                Material.JIGSAW,
                Material.DRAGON_EGG,
                Material.PETRIFIED_OAK_SLAB,
                Material.WATER,
                Material.LAVA,
                Material.CARROTS,
                Material.POTATOES,
                Material.BEETROOTS,
                Material.FIRE,
                Material.BUBBLE_COLUMN,
                Material.TALL_SEAGRASS,
                Material.END_GATEWAY,
                Material.MOVING_PISTON,
                Material.MELON_STEM,
                Material.PUMPKIN_STEM,
                Material.FROSTED_ICE,
                Material.SWEET_BERRY_BUSH,
                Material.KELP_PLANT,
                Material.COCOA,
                Material.REDSTONE_WIRE -> true

                else -> false
            }

/**
 * It's checking if the material is not valid craft.
 */
val Material.isNotValidCraft: Boolean
    // TODO: Make a list of all materials that can't be crafted
    get() = isNotValidLoot

fun getWools() = withoutLegacy().filter { it.isWool }

val Material.isSpawnEgg: Boolean
    get() = this.name.startsWith("SPAWN_EGG")

val Material.isPotion: Boolean
    get() = when (this) {
        Material.POTION, Material.SPLASH_POTION, Material.LINGERING_POTION -> true
        else -> false
    }

val Material.isDisc: Boolean
    get() = this.name.startsWith("MUSIC_DISC")

val Material.isCommandBlock: Boolean
    get() = this.name.startsWith("COMMAND_BLOCK")

val Material.isHead: Boolean
    get() = this.name.contains("_HEAD") || this.name.contains("_SKULL")

val Material.isBannerPattern: Boolean
    get() = this.name.contains("BANNER_PATTERN")

val Material.isPottedPlant: Boolean
    get() = this.name.contains("POTTED")

val Material.isAttached: Boolean
    get() = this.name.contains("ATTACHED")

val Material.isWool: Boolean
    get() = this.name.contains("WOOL")