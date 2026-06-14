package com.lixel.item

import com.lixel.ExampleMod
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.Item

object ModItems {

    val SUSPICIOUS_SUBSTANCE = register("suspicious_substance")


    fun register(name: String): Item {
        return register(name, ::Item, Item.Properties())
    }

    fun <T : Item> register(
        name: String,
        itemFactory: (Item.Properties) -> T,
        settings: Item.Properties
    ): T {
        // Create the item key.
        val itemKey: ResourceKey<Item> =
            ResourceKey.create(
                Registries.ITEM,
                Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, name)
            )

        // Create the item instance.
        val item: T = itemFactory(settings.setId(itemKey))

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item)

        return item
    }


    fun initialize() = ExampleMod.LOGGER.info("ModItems Initialized")
}