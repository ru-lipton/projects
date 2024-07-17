package net.rulipton.gnornemod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rulipton.gnornemod.GnorneMod;
import net.rulipton.gnornemod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, GnorneMod.MODID);

    public static final RegistryObject<Block> KOSTYA_BLOCK = registerBlock("kostya_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T>  block) {
     RegistryObject<T> toReturn = BLOCKS.register(name, block);
     registerBlockItem(name, toReturn);
     return toReturn;   
    }

    public static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void  register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
