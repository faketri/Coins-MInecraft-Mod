package net.faketri.testmods.app.manager.entity;

import net.faketri.testmods.TestMods;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistrationEntityManager {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TestMods.MODID);

    public static void register(IEventBus modEventBus) {
        ENTITIES.register(modEventBus);
    }
}
