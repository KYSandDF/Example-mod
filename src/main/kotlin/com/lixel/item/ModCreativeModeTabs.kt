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


object ModCreativeModeTabs {
    val TUTORIAL_TAB = ResourceKey.create(
        //设定创建的对象：创造模式物品栏
        BuiltInRegistries.CREATIVE_MODE_TAB.key(),
        //将命名空间设为example-mod:example
        Identifier.fromNamespaceAndPath(ExampleMod.MOD_ID, "example")
    )

    //初始化创造模式物品栏
    val TUTORIAL = FabricCreativeModeTab.builder()
        //图标设置为suspicious_substance
        .icon { ItemStack(ModItems.SUSPICIOUS_SUBSTANCE) }
        //将翻译文件所用的路径设为itemGroup.example
        .title(Component.translatable("itemGroup.example"))
        //设定所添加的物品
        .displayItems { parameters, output ->
            output.accept{ ModItems.AUTHOR }
            output.accept(ModItems.SUSPICIOUS_SUBSTANCE)
            output.accept( Items.DIAMOND )
            output.accept(ModBlocks.DEEP_DARK_DIRT_BLOCK)
            output.accept(ModBlocks.DEEP_DARK_DIRT_ORE)
        }.build()

    fun register() {
        ExampleMod.LOGGER.info("Creative Mod Items")
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TUTORIAL_TAB, TUTORIAL)
    }
}