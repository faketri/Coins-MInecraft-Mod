package net.faketri.testmods.app.manager.blocks;

import net.faketri.testmods.TestMods;
import net.faketri.testmods.app.manager.items.RegistrationItemsManager;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class RegistrationBlocksManager {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TestMods.MODID);

    public static final RegistryObject<Block> CUSTOM_BLOCK = BLOCKS.register("custom_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
