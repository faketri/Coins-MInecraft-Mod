package net.faketri.testmods.utils.events;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.faketri.testmods.TestMods;
import net.faketri.testmods.app.manager.entity.villager.VillagerProfessionRegistry;
import net.faketri.testmods.app.manager.items.RegistrationItemsManager;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = TestMods.MODID)
public class CustomVillagerTradesEvent {
    @SubscribeEvent()
    public static void coinsTradeRegister(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfessionRegistry.CUSTOM_PROFESSION.get()) {
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
