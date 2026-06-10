package com.lixel.block

import com.lixel.ExampleMod
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument
import net.minecraft.world.level.material.MapColor

object ModBlocks {

    val DEEP_DARK_DIRT_BLOCK = register(
        "deep_dark_dirt_block",
        BlockBehaviour.Properties.of()
            .strength(2.0f, 1000.0f)
            .mapColor(MapColor.DIRT),
        true
    )
    val DEEP_DARK_DIRT_ORE = register(
        "deep_dark_dirt_ore",
        BlockBehaviour.Properties.of()
            .strength(4.0f, 5.0f)
            .mapColor(MapColor.STONE)
            .instrument(NoteBlockInstrument.BASEDRUM)
            .requiresCorrectToolForDrops(),
        true
    )


    fun register(
        name: String,
        factory: (BlockBehaviour.Properties) -> Block,
        properties: BlockBehaviour.Properties,
        shouldRegisterItem: Boolean
    ): Block {
        val id = ResourceKey.create(
            Registries.BLOCK,
            Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, name)
        )
        val block = factory(properties.setId(id))

        if (shouldRegisterItem) registerBlockItem(name, block)

        return Registry.register(BuiltInRegistries.BLOCK, id, block)
    }

    fun register(name: String, properties: BlockBehaviour.Properties, shouldRegisterItem: Boolean): Block {
        return register(name, ::Block, properties, shouldRegisterItem)
    }

    fun registerBlockItem(name: String, block: Block) {

        val id = ResourceKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, name)
        )

        val blockItem = BlockItem(block, Item.Properties().setId(id).useBlockDescriptionPrefix())

        Registry.register(BuiltInRegistries.ITEM, id, blockItem)
    }

    fun initialize() = ExampleMod.LOGGER.info("ModBlocks initialized")
}