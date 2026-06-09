package com.lixel

import com.lixel.block.ModBlocks
import com.lixel.item.ModCreativeModeTabs
import com.lixel.item.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory
import org.slf4j.Logger

object ExampleMod : ModInitializer {
	const val MOD_ID: String = "example-mod"
	val LOGGER: Logger = LoggerFactory.getLogger("example-mod")
	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Hello Fabric world!")
		ModCreativeModeTabs.register()
		ModItems.initialize()
		ModBlocks.initialize()
	}
}