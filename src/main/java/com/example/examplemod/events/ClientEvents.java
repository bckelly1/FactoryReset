package com.example.examplemod.events;

import com.example.examplemod.ExampleMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExampleMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onJumpWithStick(PlayerInteractEvent.LeftClickBlock event) {
        LivingEntity player = event.getEntityLiving();
        if(player.getHeldItemMainhand().getItem() == Items.STICK) {
            World world = player.getEntityWorld();

            BlockPos blockPos = event.getPos();
            if(!world.isRemote()) {
                if(world.getBlockState(blockPos).getBlock().getDefaultState() == Blocks.GRASS_BLOCK.getDefaultState()) {
                    world.setBlockState(blockPos, Blocks.GRASS_PATH.getDefaultState());
                }
                else if(world.getBlockState(blockPos).getBlock().getDefaultState() == Blocks.COBBLESTONE.getDefaultState()) {
                    world.setBlockState(blockPos, Blocks.STONE.getDefaultState());
                }
                else if(world.getBlockState(blockPos).getBlock().getDefaultState() == Blocks.STONE.getDefaultState()) {
                    world.setBlockState(blockPos, Blocks.SAND.getDefaultState());
                }
            }
        }
    }
}
