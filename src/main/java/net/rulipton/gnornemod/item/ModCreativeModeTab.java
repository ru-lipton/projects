package net.rulipton.gnornemod.item;


import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.MossBlock;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.rulipton.gnornemod.GnorneMod;
import net.rulipton.gnornemod.block.ModBlocks;

public class ModCreativeModeTab {
        public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
                DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GnorneMod.MODID);

        public static final RegistryObject<CreativeModeTab> GNORNE_TAB = CREATIVE_MODE_TABS.register("gnorne_tab",
                () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.PHONK.get()))
                        .title(Component.translatable("creativetab.gnorne_tab"))
                        .displayItems((itemDisplayParameters, output) -> {
                            output.accept(ModItems.PHONK.get());
                            output.accept(ModBlocks.KOSTYA_BLOCK.get());
                        })
                        .build());

        public static void register(IEventBus eventBus) {
            CREATIVE_MODE_TABS.register(eventBus);
        }

}
