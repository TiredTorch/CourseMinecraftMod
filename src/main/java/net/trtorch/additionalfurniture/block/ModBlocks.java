package net.trtorch.additionalfurniture.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.*;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*    ;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.trtorch.additionalfurniture.AdditionalFurniture;
import net.trtorch.additionalfurniture.block.custom.ModFlammableRotatedPillarBlock;
import net.trtorch.additionalfurniture.item.ModCreativeModeTab;
import net.trtorch.additionalfurniture.item.ModItems;
import net.trtorch.additionalfurniture.world.feature.tree.BaobabTreeGrower;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, AdditionalFurniture.MOD_ID);

    public static final RegistryObject<Block> BAOBAB_LOG = registerBlock("baobab_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)),
            ModCreativeModeTab.ADDFUR_TAB);

    public static final RegistryObject<Block> BAOBAB_WOOD = registerBlock("baobab_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)),
            ModCreativeModeTab.ADDFUR_TAB);

    public static final RegistryObject<Block> STRIPPED_BAOBAB_LOG = registerBlock("stripped_baobab_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)),
            ModCreativeModeTab.ADDFUR_TAB);

    public static final RegistryObject<Block> STRIPPED_BAOBAB_WOOD = registerBlock("stripped_baobab_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)),
            ModCreativeModeTab.ADDFUR_TAB);

    public static final RegistryObject<Block> BAOBAB_PLANKS = registerBlock("baobab_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }
            }, ModCreativeModeTab.ADDFUR_TAB);

    public static final RegistryObject<Block> BAOBAB_LEAVES = registerBlock("baobab_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }
            }, ModCreativeModeTab.ADDFUR_TAB);


    public static final RegistryObject<Block> BAOBAB_SAPLING = registerBlock("baobab_sapling",
            () -> new SaplingBlock(new BaobabTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.ADDFUR_TAB);

    public static final RegistryObject<Block> BAOBAB_STAIRS = registerBlock("baobab_stairs",
            () -> new StairBlock(() -> ModBlocks.BAOBAB_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.WOOD).strength(5f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.ADDFUR_TAB);
    public static final RegistryObject<Block> BAOBAB_SLAB = registerBlock("baobab_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.ADDFUR_TAB);
    public static final RegistryObject<Block> BAOBAB_FENCE = registerBlock("baobab_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.ADDFUR_TAB);
    public static final RegistryObject<Block> BAOBAB_FENCE_GATE = registerBlock("baobab_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(5f).requiresCorrectToolForDrops()), ModCreativeModeTab.ADDFUR_TAB);

    //Registration methods
    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
