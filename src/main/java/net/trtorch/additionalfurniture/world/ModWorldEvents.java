package net.trtorch.additionalfurniture.world;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.trtorch.additionalfurniture.AdditionalFurniture;
import net.trtorch.additionalfurniture.world.gen.ModTreeGeneration;

@Mod.EventBusSubscriber(modid = AdditionalFurniture.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModTreeGeneration.generateTrees(event);
    }
}
