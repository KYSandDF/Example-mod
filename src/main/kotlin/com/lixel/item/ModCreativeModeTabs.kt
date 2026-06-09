package com.lixel.item

import com.lixel.ExampleMod
import com.lixel.block.ModBlocks
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.Identifier
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.ItemStack
import net.minecraft.network.chat.Component
import net.minecraft.world.item.Items
import net.minecraft.core.Registry


class ModCreativeModeTabs {
    companion object {
        val TUTORIAL_TAB = ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(),
            Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, "example")
        )
        val TUTORIAL = FabricCreativeModeTab.builder()
            .icon{ ItemStack(ModItems.SUSPICIOUS_SUBSTANCE) }
            .title(Component.translatable("itemGroup.example"))
            .displayItems { parameters, output ->
                output.accept(ModItems.SUSPICIOUS_SUBSTANCE)
                output.accept(Items.DIAMOND)
                output.accept(ModBlocks.DEEP_DARK_DIRT_BLOCK)
                output.accept(ModBlocks.DEEP_DARK_DIRT_ORE)
            }.build()
        fun register(){
            ExampleMod.LOGGER.info("Creative Mod Items")
            Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TUTORIAL_TAB, TUTORIAL)
        }
    }
}