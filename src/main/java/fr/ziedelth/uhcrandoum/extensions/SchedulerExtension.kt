package fr.ziedelth.uhcrandoum.extensions

import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin

/**
 * `delay` is a function that takes a plugin, a delay, and an operation, and runs the operation after the delay
 *
 * @param plugin The plugin that is running the task.
 * @param delay The amount of time to wait before running the operation.
 * @param operation The operation to be executed.
 */
fun delay(plugin: Plugin, delay: Long = 1, operation: () -> Unit) {
    Bukkit.getScheduler().runTaskLater(plugin, operation, delay)
}