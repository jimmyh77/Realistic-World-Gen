package rwg.biomes.realistic.ocean;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import rwg.api.RWGBiomes;
import rwg.biomes.realistic.RealisticBiomeBase;
import rwg.terrain.TerrainBase;
import rwg.terrain.TerrainTrench;
import rwg.util.CellNoise;
import rwg.util.PerlinNoise;

import java.util.Random;

/**
 * Created by james.healey on 21/07/2015.
 */
public class RealisticBiomeOceanTrench extends RealisticBiomeBase
{
	private TerrainBase terrain;

	public RealisticBiomeOceanTrench()
	{
		super(0, RWGBiomes.baseOceanTemperate, "rwg_OceanTrench");

		terrain = new TerrainTrench(-20f, 11f);
	}

	@Override
	public void rDecorate(World world, Random rand, int chunkX, int chunkY, PerlinNoise perlin, CellNoise cell, float strength, float river)
	{
	}

	@Override
	public float rNoise(PerlinNoise perlin, CellNoise cell, int x, int y, float ocean, float border, float river)
	{
		return terrain.generateNoise(perlin, cell, x, y, ocean, border, river);

		//return 45f;
	}

	@Override
	public void rReplace(Block[] blocks, byte[] metadata, int i, int j, int x, int y, int depth, World world, Random rand, PerlinNoise perlin, CellNoise cell, float[] noise, float river, BiomeGenBase[] base)
	{
		Block b;
		for(int k = 255; k > -1; k--)
		{
			b = blocks[(y * 16 + x) * 256 + k];
			if(b == Blocks.air)
			{
				depth = -1;
			}
			else if(b == Blocks.stone)
			{
				depth++;

				if(depth == 0)
				{
					if(k < 62)
					{
						blocks[(y * 16 + x) * 256 + k] = Blocks.sand;
					}
					else
					{
						blocks[(y * 16 + x) * 256 + k] = Blocks.sand;
					}
				}
        		/*else if(depth < 2)
        		{
        			blocks[(y * 16 + x) * 256 + k] = Blocks.sand;
        		}*/
			}
		}
	}
}
