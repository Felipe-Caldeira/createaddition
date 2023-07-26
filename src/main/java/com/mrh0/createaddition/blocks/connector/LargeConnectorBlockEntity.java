package com.mrh0.createaddition.blocks.connector;

import com.mrh0.createaddition.blocks.connector.base.AbstractConnectorBlock;
import com.mrh0.createaddition.blocks.connector.base.AbstractConnectorBlockEntity;
import com.mrh0.createaddition.config.Config;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class LargeConnectorBlockEntity extends AbstractConnectorBlockEntity {

    public static float OFFSET_HEIGHT = 1f;
    public static Vec3 OFFSET_DOWN = new Vec3(0f, -OFFSET_HEIGHT/16f, 0f);
    public static Vec3 OFFSET_UP = new Vec3(0f, OFFSET_HEIGHT/16f, 0f);
    public static Vec3 OFFSET_NORTH = new Vec3(0f, 0f, -OFFSET_HEIGHT/16f);
    public static Vec3 OFFSET_WEST = new Vec3(-OFFSET_HEIGHT/16f, 0f, 0f);
    public static Vec3 OFFSET_SOUTH = new Vec3(0f, 0f, OFFSET_HEIGHT/16f);
    public static Vec3 OFFSET_EAST = new Vec3(OFFSET_HEIGHT/16f, 0f, 0f);

    public LargeConnectorBlockEntity(BlockEntityType<?> blockEntityTypeIn, BlockPos pos, BlockState state) {
        super(blockEntityTypeIn, pos, state);
    }

    @Override
    public int getCapacity() {
        return Config.CONNECTOR_CAPACITY.get();
    }

    @Override
    public int getMaxIn() {
        return Config.CONNECTOR_MAX_INPUT.get();
    }

    @Override
    public int getMaxOut() {
        return Config.CONNECTOR_MAX_OUTPUT.get();
    }

    @Override
    public int getNodeCount() {
        return 4;
    }

    @Override
    public Vec3 getNodeOffset(int node) {
        return switch (getBlockState().getValue(AbstractConnectorBlock.FACING)) {
            case DOWN -> OFFSET_DOWN;
            case UP -> OFFSET_UP;
            case NORTH -> OFFSET_NORTH;
            case WEST -> OFFSET_WEST;
            case SOUTH -> OFFSET_SOUTH;
            case EAST -> OFFSET_EAST;
        };
    }
}
