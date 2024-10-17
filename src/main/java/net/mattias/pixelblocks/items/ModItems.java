package net.mattias.pixelblocks.items;


import net.mattias.pixelblocks.PixelBlocks;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PixelBlocks.MOD_ID);


    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst",
            () -> new Item(new Item.Properties().group(ModItemGroup.PIXEL_BLOCKS)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}