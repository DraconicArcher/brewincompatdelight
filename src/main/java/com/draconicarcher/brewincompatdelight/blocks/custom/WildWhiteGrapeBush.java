package com.draconicarcher.brewincompatdelight.blocks.custom;

import com.draconicarcher.brewincompatdelight.items.BCDItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.gameevent.GameEvent;

public class WildWhiteGrapeBush extends SweetBerryBushBlock {

    // Reuse the AGE property from SweetBerryBushBlock
    public static final IntegerProperty AGE = SweetBerryBushBlock.AGE;

    public WildWhiteGrapeBush(Properties properties) {
        super(properties);
        // Set default state to age 0
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos,
                                 Player player, InteractionHand hand, BlockHitResult hit) {
        int age = state.getValue(AGE);
        boolean fullyGrown = age == 3;

        if (age > 1) {
            int count = 1 + level.random.nextInt(2) + (fullyGrown ? 1 : 0);

            // Drop custom red grapes
            popResource(level, pos, new ItemStack(BCDItems.WHITE_GRAPES.get(), count));

            // Play berry pick sound
            level.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES,
                    SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);

            // Reset age to 1 after harvest
            BlockState newState = state.setValue(AGE, 1);
            level.setBlock(pos, newState, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));

            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        return InteractionResult.PASS;
    }

    @Override
    public String getDescriptionId() {
        return "block.brewincompatdelight.wild_white_grape_bush";
    }



    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity
                && entity.getType() != EntityType.FOX
                && entity.getType() != EntityType.BEE) {
            entity.makeStuckInBlock(state, new Vec3(0.8F, 0.75D, 0.8F));
        }
    }
}
