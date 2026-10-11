package bayhasoft.mattock.item;

import bayhasoft.mattock.Mattock;
import bayhasoft.mattock.item.custom.MattockItem;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;

import java.util.function.Function;

public class ModItems {

    public static final Item WOODEN_MATTOCK = registerItem("wooden_mattock", properties -> new MattockItem(ToolMaterial.WOOD, properties));
    public static final Item STONE_MATTOCK = registerItem("stone_mattock", properties -> new MattockItem(ToolMaterial.STONE, properties));
    public static final Item Copper_MATTOCK = registerItem("copper_mattock", properties -> new MattockItem(ToolMaterial.COPPER, properties));
    public static final Item IRON_MATTOCK = registerItem("iron_mattock", properties -> new MattockItem(ToolMaterial.IRON, properties));
    public static final Item GOLDEN_MATTOCK = registerItem("golden_mattock", properties -> new MattockItem(ToolMaterial.GOLD, properties));
    public static final Item DIAMOND_MATTOCK = registerItem("diamond_mattock", properties -> new MattockItem(ToolMaterial.DIAMOND, properties));
    public static final Item NETHERITE_MATTOCK = registerItem("netherite_mattock", properties -> new MattockItem(ToolMaterial.NETHERITE, properties));


    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Mattock.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Mattock.MOD_ID, name)))));
    }

    public static void addItemsToItemGroup() {
        addToItemGroup(CreativeModeTabs.TOOLS_AND_UTILITIES, Copper_MATTOCK);
        addToItemGroup(CreativeModeTabs.TOOLS_AND_UTILITIES, IRON_MATTOCK);
        addToItemGroup(CreativeModeTabs.TOOLS_AND_UTILITIES, GOLDEN_MATTOCK);
        addToItemGroup(CreativeModeTabs.TOOLS_AND_UTILITIES, DIAMOND_MATTOCK);
        addToItemGroup(CreativeModeTabs.TOOLS_AND_UTILITIES, NETHERITE_MATTOCK);

    }

    private static void addToItemGroup(ResourceKey<CreativeModeTab> group, Item item) {
        CreativeModeTabEvents.modifyOutputEvent(group).register(entries -> entries.accept(item));
    }

    public static void registerModItems() {
        Mattock.LOGGER.info("Registering items for " + Mattock.MOD_ID);

        addItemsToItemGroup();
    }
}
