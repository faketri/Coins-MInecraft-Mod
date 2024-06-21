package net.faketri.testmods;

import com.mojang.logging.LogUtils;
import net.faketri.testmods.infastructure.manager.RegistrationItemsManager;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(TestMods.MODID)
public class TestMods {

    public static final String MODID = "testmods";
    private static final Logger LOGGER = LogUtils.getLogger();

    public TestMods() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        RegistrationItemsManager.ITEMS.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS)
            event.accept(RegistrationItemsManager.BITCOIN_ITEM);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }
}
