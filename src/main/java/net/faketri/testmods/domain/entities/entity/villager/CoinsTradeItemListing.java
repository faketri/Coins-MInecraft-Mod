package net.faketri.testmods.domain.entities.entity.villager;

import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import org.jetbrains.annotations.Nullable;

public class CoinsTradeItemListing implements VillagerTrades.ItemListing {
    private final ItemStack price;
    private final ItemStack forSale;
    private final int maxUses;
    private final int experience;
    private final float priceMultiplier;

    public CoinsTradeItemListing(ItemStack price, ItemStack forSale, int maxUses, int experience, float priceMultiplier) {
        this.price = price;
        this.forSale = forSale;
        this.maxUses = maxUses;
        this.experience = experience;
        this.priceMultiplier = priceMultiplier;
    }

    @Nullable
    @Override
    public MerchantOffer getOffer(Entity entity, RandomSource randomSource) {
        return new MerchantOffer(price, forSale, maxUses, experience, priceMultiplier);
    }
}
