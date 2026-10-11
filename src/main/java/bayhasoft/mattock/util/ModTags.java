package bayhasoft.mattock.util;

import bayhasoft.mattock.Mattock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> MINEABLE_WITH_MATTOCK = createTag("mineable/mattock");
        public static final TagKey<Block> MINES_NONE = createTag("mineable/mines_none");


        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Mattock.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> MATTOCKS = createTag("mattocks");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Mattock.MOD_ID, name));
        }
    }
}
