package bayhasoft.mattock.datagen;

import bayhasoft.mattock.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider{
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, BootstrapContext<Recipe<?>> recipeContext, BootstrapContext<Advancement> advancementContext) {
        return new RecipeProvider(recipeContext, advancementContext) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);
                shaped(RecipeCategory.TOOLS, ModItems.Copper_MATTOCK)
                        .pattern("xxx")
                        .pattern("xs ")
                        .pattern(" s ")
                        .define('x', Items.COPPER_INGOT)
                        .define('s', Items.STICK)
                        .unlockedBy(getHasName(ModItems.Copper_MATTOCK), has(Items.COPPER_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.IRON_MATTOCK)
                        .pattern("xxx")
                        .pattern("xs ")
                        .pattern(" s ")
                        .define('x', Items.IRON_INGOT)
                        .define('s', Items.STICK)
                        .unlockedBy(getHasName(ModItems.IRON_MATTOCK), has(Items.IRON_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.GOLDEN_MATTOCK)
                        .pattern("xxx")
                        .pattern("xs ")
                        .pattern(" s ")
                        .define('x', Items.GOLD_INGOT)
                        .define('s', Items.STICK)
                        .unlockedBy(getHasName(ModItems.GOLDEN_MATTOCK), has(Items.GOLD_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_MATTOCK)
                        .pattern("xxx")
                        .pattern("xs ")
                        .pattern(" s ")
                        .define('x', Items.DIAMOND)
                        .define('s', Items.STICK)
                        .unlockedBy(getHasName(ModItems.DIAMOND_MATTOCK), has(Items.DIAMOND))
                        .save(output);

                netheriteSmithing(ModItems.DIAMOND_MATTOCK, RecipeCategory.TOOLS, ModItems.NETHERITE_MATTOCK);
            }
        };
    }




    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
