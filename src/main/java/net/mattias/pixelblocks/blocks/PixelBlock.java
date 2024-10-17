package net.mattias.pixelblocks.blocks;

import com.pixelmonmod.api.pokemon.PokemonSpecification;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.pokemon.PokemonFactory;
import com.pixelmonmod.pixelmon.api.pokemon.species.Species;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class PixelBlock extends Block {

    public PixelBlock() {
        super(Properties.create(Material.ROCK)
                .harvestLevel(0)
                .sound(SoundType.STONE));
    }


    public void onBlockRemoved(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!world.isRemote) {
            Random random = new Random();
            int luck = random.nextInt(100) - 50;
            PlayerEntity player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 10, false);

            if (luck > 20) {

                spawnPokemon((ServerWorld) world, pos, "rare", player);
            } else {

                spawnPokemon((ServerWorld) world, pos, "common", player);
            }
        }

        super.onReplaced(state, world, pos, newState, isMoving);
    }

    private void spawnPokemon(ServerWorld world, BlockPos pos, String luckType, PlayerEntity player) {
        Pokemon pokemon;
        switch (luckType) {
            case "rare":

                PokemonSpecification legendarySpec = PokemonSpecification.from("isLegendary");
                pokemon = PokemonFactory.create(legendarySpec);
                break;
            default:
                pokemon = PokemonFactory.create(Species.getRandom());
                break;
        }

        if (pokemon != null) {
            pokemon.getOrSpawnPixelmon(world, pos.getX(), pos.getY(), pos.getZ());
        }
    }
}
