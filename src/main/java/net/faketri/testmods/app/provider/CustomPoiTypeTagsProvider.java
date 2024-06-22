package net.faketri.testmods.app.provider;

import net.faketri.testmods.TestMods;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.PoiTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class CustomPoiTypeTagsProvider extends PoiTypeTagsProvider {
    public CustomPoiTypeTagsProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> providerCompletableFuture,
                                     @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, providerCompletableFuture, TestMods.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        tag(PoiTypeTags.ACQUIRABLE_JOB_SITE)
                .addOptional(new ResourceLocation(TestMods.MODID, "coins_poi_type"));
    }
}
