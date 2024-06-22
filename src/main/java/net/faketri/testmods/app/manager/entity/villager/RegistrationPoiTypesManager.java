package net.faketri.testmods.app.manager.entity.villager;

import com.google.common.collect.ImmutableSet;
import net.faketri.testmods.TestMods;
import net.faketri.testmods.app.manager.blocks.RegistrationBlocksManager;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegistrationPoiTypesManager {

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
    }
}
