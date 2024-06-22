package net.faketri.testmods.app.manager.items;

import com.mojang.logging.LogUtils;
import net.faketri.testmods.TestMods;
import net.faketri.testmods.domain.entities.items.Bitcoin;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;


public class RegistrationItemsManager {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TestMods.MODID);
    public static final RegistryObject<Item> BITCOIN_ITEM = ITEMS.register("bitcoin", Bitcoin::new);
}