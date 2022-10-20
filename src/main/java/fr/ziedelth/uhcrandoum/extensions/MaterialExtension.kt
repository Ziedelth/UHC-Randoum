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
            this.name.startsWith("SPAWN_EGG") ||
            (this == Material.POTION || this == Material.SPLASH_POTION || this == Material.LINGERING_POTION) ||
            this.name.startsWith("MUSIC_DISC") ||
            this.name.startsWith("COMMAND_BLOCK") ||
            (this.name.contains("_HEAD") || this.name.contains("_SKULL")) ||
            this.name.contains("BANNER_PATTERN") ||
            this.name.contains("POTTED") ||
            this.name.contains("ATTACHED") ||
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
    get() = isNotValidLoot ||
            this.name.contains("GLASS_PANE") ||
            this.name.contains("BED") ||
            this.name.contains("FENCE") ||
            this.name.contains("BOAT") ||
            this.name.contains("SHULKER") ||
            this.name.contains("INFESTED") ||
            this.name.contains("SIGN") ||
            this.name.contains("CORAL") ||
            this.name.contains("SAPLING") ||
            this.name.contains("LEAVES") ||
            this.name.contains("CARPET") ||
            this.name.contains("WALL") ||
            this.name.contains("PRESSURE_PLATE") ||
            this.name.contains("BUTTON") ||
            this.name.contains("DOOR") ||
            this.name.contains("BANNER") ||
            this.name.contains("STAINED_GLASS") ||
            (this != Material.WHITE_WOOL && this.name.contains("WOOL")) ||
            (this != Material.TERRACOTTA && this.name.contains("TERRACOTTA")) ||
            this.name.contains("CONCRETE") ||
            when (this) {
                Material.BARREL,
                Material.CARTOGRAPHY_TABLE,
                Material.COMPOSTER,
                Material.FLETCHING_TABLE,
                Material.SMITHING_TABLE,
                Material.STONECUTTER,
                Material.LECTERN,
                Material.GRINDSTONE,
                Material.LOOM,
                Material.SMOKER,
                Material.BLAST_FURNACE,
                Material.PACKED_ICE,
                Material.SCAFFOLDING,
                Material.BEEHIVE,
                Material.BEE_NEST,
                Material.SEA_LANTERN,
                Material.MAGMA_BLOCK,
                Material.LADDER,
                Material.SNOW_BLOCK,
                Material.ENDER_CHEST,
                Material.CAULDRON,
                Material.TRAPPED_CHEST,
                Material.CAMPFIRE,
                Material.LANTERN,
                Material.DEAD_BUSH,
                Material.CHORUS_FLOWER,
                Material.CHORUS_PLANT,
                Material.CHORUS_FRUIT,
                Material.DISPENSER,
                Material.NOTE_BLOCK,
                Material.RAIL,
                Material.ACTIVATOR_RAIL,
                Material.DETECTOR_RAIL,
                Material.POWERED_RAIL,
                Material.STICKY_PISTON,
                Material.LEVER,
                Material.REDSTONE_LAMP,
                Material.TRIPWIRE,
                Material.TRIPWIRE_HOOK,
                Material.DAYLIGHT_DETECTOR,
                Material.DROPPER,
                Material.OBSERVER,
                Material.FARMLAND,
                Material.SEA_PICKLE,
                Material.COOKIE,
                Material.REPEATER,
                Material.ENDER_EYE,
                Material.WRITABLE_BOOK,
                Material.ITEM_FRAME,
                Material.CARROT_ON_A_STICK,
                Material.FIREWORK_ROCKET,
                Material.COMPARATOR,
                Material.ARMOR_STAND,
                Material.STRUCTURE_BLOCK,
                Material.STRUCTURE_VOID,
                Material.MAP,
                Material.FILLED_MAP,
                Material.IRON_AXE,
                Material.IRON_PICKAXE,
                Material.IRON_SHOVEL,
                Material.STONE_SWORD -> true

                else -> false
            }
