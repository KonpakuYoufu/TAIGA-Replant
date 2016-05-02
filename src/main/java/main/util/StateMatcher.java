package main.util;

import com.google.common.base.Predicate;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class StateMatcher implements Predicate<IBlockState> {
    private final IBlockState state;
    private final IProperty property;
    private final Comparable value;

    private StateMatcher(IBlockState state, IProperty property, Comparable value) {
        this.state = state;
        this.property = property;
        this.value = value;
    }

    public static StateMatcher forState(IBlockState state, IProperty property, Comparable value) {
        return new StateMatcher(state, property, value);
    }

    public boolean apply(IBlockState state, BlockPos pos, World world) {
        if (state != null) {
            if (property != null && value != null) {
                if (checkLayerForBlocks(pos.getX(), pos.getZ(), pos.getY() - 1, world, pos) ||
                        checkLayerForBlocks(pos.getX(), pos.getZ(), pos.getY(), world, pos) ||
                        checkLayerForBlocks(pos.getX(), pos.getZ(), pos.getY() + 1, world, pos))
                    return true;

            } else
                return state.getBlock() == this.state.getBlock();
        }
        return false;
    }

    @Override
    public boolean apply(IBlockState input) {
        if (state != null) {
            if (property != null && value != null) {
                return state.getBlock() == this.state.getBlock() && state.getValue(property) == value;
            } else
                return state.getBlock() == this.state.getBlock();
        }
        return false;
    }

    private boolean checkLayerForBlocks(int X, int Z, int Y, World world, BlockPos origin) {
        int x = 0, z = 0, dx = 0, dz = -1;
        int t = Math.max(X, Z);
        int maxI = t * t;

        for (int i = 0; i < maxI; i++) {
            if ((-X / 2 <= x) && (x <= X / 2) && (-Z / 2 <= z) && (z <= Z / 2)) {
                System.out.println(x + "," + z);
                if (new BlockPos(x, Y, z) == origin)
                    continue;

                IBlockState bState = world.getBlockState(new BlockPos(x, Y, z));
                if (bState.getBlock() == this.state.getBlock() && bState.getValue(property) == value) {
                    return true;
                }
            }

            if ((x == z) || ((x < 0) && (x == -z)) || ((x > 0) && (x == 1 - z))) {
                t = dx;
                dx = -dz;
                dz = t;
            }
            x += dx;
            z += dz;
        }

        return false;
    }
}