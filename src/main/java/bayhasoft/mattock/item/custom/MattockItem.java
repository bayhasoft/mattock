package bayhasoft.mattock.item.custom;

import bayhasoft.mattock.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.BlockTransformers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;


public class MattockItem extends Item {
    public MattockItem(ToolMaterial toolMaterial, Properties properties) {
        super(properties                        
                .tool(toolMaterial, ModTags.Blocks.MINEABLE_WITH_MATTOCK ,3, -2.9f, 1 )
                .delayedComponent(DataComponents.BLOCK_TRANSFORMER, (context) -> context.getOrThrow(BlockTransformers.SHOVEL))
                .durability(toolMaterial.durability()*2)
        );
    }

    @Override
    public boolean mineBlock(final ItemStack itemStack, final Level level, final BlockState state, final BlockPos pos, final LivingEntity owner) {
        Tool tool = (Tool)itemStack.get(DataComponents.TOOL);
        if (tool == null) {

            return false;

        } else if(state.is(BlockTags.LEAVES)){

            return false;

        } else {
            if (!level.isClientSide() && state.getDestroySpeed(level, pos) != 0.0F && tool.damagePerBlock() > 0) {
                itemStack.hurtAndBreak(tool.damagePerBlock(), owner, EquipmentSlot.MAINHAND);
            }

            return true;
        }
    }
}
