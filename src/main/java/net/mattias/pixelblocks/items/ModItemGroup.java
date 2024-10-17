package net.mattias.pixelblocks.items;


import net.mattias.pixelblocks.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup PIXEL_BLOCKS = new ItemGroup("pixelblocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.PIXEL_BLOCK.get());
        }
    };

}