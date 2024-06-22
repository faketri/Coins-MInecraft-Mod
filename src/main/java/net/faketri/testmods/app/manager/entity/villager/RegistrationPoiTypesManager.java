package net.faketri.testmods.app.manager.entity.villager;

import com.google.common.collect.ImmutableSet;
import com.mojang.logging.LogUtils;
import net.faketri.testmods.TestMods;
import net.faketri.testmods.app.manager.blocks.RegistrationBlocksManager;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RegistrationPoiTypesManager {

    private static final Logger LOGGER = LogUtils.getLogger();
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, TestMods.MODID);

    public static final RegistryObject<PoiType> COINS_POI_TYPE =
            POI_TYPES.register("coins_poi_type",
                    () -> new PoiType(
                            ImmutableSet.copyOf(
                                    RegistrationBlocksManager.CUSTOM_BLOCK.get()
                                    .getStateDefinition().getPossibleStates()
                            ),
                            1,
                            1
                    ));

    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        LOGGER.info("Registered villager poi: coins_poi_type");
    }
}
