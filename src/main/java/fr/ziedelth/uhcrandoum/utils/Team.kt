package fr.ziedelth.uhcrandoum.utils

import org.bukkit.ChatColor
import org.bukkit.DyeColor

enum class Team(val teamName: String, val chatColor: ChatColor, val prefix: String? = null, val dyeColor: DyeColor? = null) {
    BLACK("Noir", ChatColor.BLACK, dyeColor = DyeColor.BLACK),
    RED("Rouge", ChatColor.RED, dyeColor = DyeColor.RED),
    GREEN("Vert", ChatColor.GREEN, dyeColor = DyeColor.GREEN),
    BROWN("Marron", ChatColor.GOLD, dyeColor = DyeColor.BROWN),
    BLUE("Bleu", ChatColor.BLUE, dyeColor = DyeColor.BLUE),
    PURPLE("Violet", ChatColor.DARK_PURPLE, dyeColor = DyeColor.PURPLE),
    CYAN("Cyan", ChatColor.DARK_AQUA, dyeColor = DyeColor.CYAN),
    LIGHT_GRAY("Gris", ChatColor.GRAY, dyeColor = DyeColor.LIGHT_GRAY),
    GRAY("Gris foncé", ChatColor.DARK_GRAY, dyeColor = DyeColor.GRAY),
    PINK("Rose", ChatColor.LIGHT_PURPLE, dyeColor = DyeColor.PINK),
    LIME("Lime", ChatColor.GREEN, dyeColor = DyeColor.LIME),
    YELLOW("Jaune", ChatColor.YELLOW, dyeColor = DyeColor.YELLOW),
    LIGHT_BLUE("Bleu clair", ChatColor.AQUA, dyeColor = DyeColor.LIGHT_BLUE),
    MAGENTA("Magenta", ChatColor.DARK_PURPLE, dyeColor = DyeColor.MAGENTA, prefix = "♦ "),
    ORANGE("Orange", ChatColor.GOLD, dyeColor = DyeColor.ORANGE, prefix = "♦ "),
    WHITE("Blanc", ChatColor.WHITE, dyeColor = DyeColor.WHITE);
}