package com.pengegg.journeys.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class SunBlastedSandBlock extends FallingBlock {

    public SunBlastedSandBlock(Properties p_53205_) {
        super(p_53205_);
    }

    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(20) == 0) {
            Direction direction = Direction.getRandom(randomSource);
                BlockPos blockpos = blockPos.relative(direction);
                BlockState blockstate = level.getBlockState(blockpos);
                if (!blockState.canOcclude() || !blockstate.isFaceSturdy(level, blockpos, direction.getOpposite())) {
                    double deltaX = direction.getStepX() == 0 ? randomSource.nextDouble() : 0.5D + (double)direction.getStepX() * 0.6D;
                    double deltaY = direction.getStepY() == 0 ? randomSource.nextDouble() : 0.5D + (double)direction.getStepY() * 0.6D;
                    double deltaZ = direction.getStepZ() == 0 ? randomSource.nextDouble() : 0.5D + (double)direction.getStepZ() * 0.6D;
                    level.addParticle(ParticleTypes.WAX_OFF, (double)blockPos.getX() + deltaX, (double)blockPos.getY() + deltaY, (double)blockPos.getZ() + deltaZ, 0.5D, 0.5D, 0.0D);
                }
        }
    }

}
