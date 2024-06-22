package net.faketri.testmods.domain.entities.entity.villager;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.Level;

public class CoinsVillager extends Villager {
    public CoinsVillager(EntityType<? extends Villager> type, Level level) {
        super(type, level, VillagerType.PLAINS);
    }
}
