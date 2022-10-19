package fr.ziedelth.uhcrandoum.utils

enum class Submod {
    NORMAL,
    RANDOM_LOOT,
    RANDOM_CRAFT,
    ;

    companion object {
        private val submod = NORMAL

        fun isSubmod(submod: Submod): Boolean {
            return this.submod == submod
        }
    }
}