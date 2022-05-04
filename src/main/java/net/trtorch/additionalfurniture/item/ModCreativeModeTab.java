package net.trtorch.additionalfurniture.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.trtorch.additionalfurniture.block.ModBlocks;

public class ModCreativeModeTab {
    public static final CreativeModeTab ADDFUR_TAB = new CreativeModeTab("main_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.BAOBAB_LOG.get());
        }
    };
}
