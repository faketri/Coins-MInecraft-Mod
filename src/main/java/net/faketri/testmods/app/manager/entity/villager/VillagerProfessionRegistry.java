package net.faketri.testmods.app.manager.entity.villager;

import com.google.common.collect.ImmutableSet;
import com.mojang.logging.LogUtils;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.faketri.testmods.TestMods;
import net.faketri.testmods.app.manager.items.RegistrationItemsManager;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.List;

public class VillagerProfessionRegistry {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TestMods.MODID);
    public static final RegistryObject<VillagerProfession> CUSTOM_PROFESSION =
            PROFESSIONS.register("coins_profession",
                    () -> new VillagerProfession(
                            "coins_profession",
                            holder -> {
                                boolean result = holder.get() == RegistrationPoiTypesManager.COINS_POI_TYPE.get();
                                LOGGER.info("Checking POI type for custom profession: " + result);
                                return result;
                            },
                            holder -> holder.get() == RegistrationPoiTypesManager.COINS_POI_TYPE.get(),
                            ImmutableSet.of(),
                            ImmutableSet.of(),
                            SoundEvents.VILLAGER_WORK_ARMORER
                    )
            );

    public static void register(IEventBus modEventBus) {
        PROFESSIONS.register(modEventBus);
        LOGGER.info("Registered villager profession: coins_profession");
    }

}
