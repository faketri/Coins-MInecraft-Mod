package net.faketri.testmods.app.manager.entity.villager;

import com.google.common.collect.ImmutableSet;
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

import java.util.List;

public class VillagerProfessionRegistry {
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TestMods.MODID);
    public static final RegistryObject<VillagerProfession> CUSTOM_PROFESSION =
            PROFESSIONS.register("coins_profession",
            () -> new VillagerProfession("coins_profession",
                    holder -> holder.get() == RegistrationPoiTypesManager.COINS_POI_TYPE.get(),
                    holder -> holder.get() == RegistrationPoiTypesManager.COINS_POI_TYPE.get(),
                    ImmutableSet.of(),
                    ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_ARMORER));

    public static void register(IEventBus modEventBus) {
        PROFESSIONS.register(modEventBus);
    }

    @SubscribeEvent
    public static void coinsTradeRegister(VillagerTradesEvent event) {
        if (event.getType() == CUSTOM_PROFESSION.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrade, pRandom) -> new MerchantOffer(
                    new ItemStack(RegistrationItemsManager.BITCOIN_ITEM.get(), 1),
                    new ItemStack(Items.APPLE, 5), 10, 2, 0.05F
            ));

            trades.get(2).add((pTrade, pRandom) -> new MerchantOffer(
                    new ItemStack(RegistrationItemsManager.BITCOIN_ITEM.get(), 32),
                    new ItemStack(Items.DIAMOND, 5), 10, 2, 0.05F
            ));
        };
    }
}
