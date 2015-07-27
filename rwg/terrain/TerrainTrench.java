package rwg.terrain;

import rwg.util.CellNoise;
import rwg.util.LogHelper;
import rwg.util.PerlinNoise;

/**
 * Created by james.healey on 21/07/2015.
 */
public class TerrainTrench extends TerrainBase
{
	private float[] height;
	private int heightLength;
	private float strength;
	private float cWidth;
	private float cHeigth;
	private float cStrength;
	private float base;

	/*
	 * Example parameters:

	 *
	 * canyon jump heights
	 * heightArray = new float[]{2.0f, 0.5f, 6.5f, 0.5f, 14.0f, 0.5f, 19.0f, 0.5f}
	 *
	 * strength of canyon jump heights
	 * heightStrength = 35f
	 *
	 * canyon width (cliff to cliff)
	 * canyonWidth = 160f
	 *
	 * canyon heigth (total heigth)
	 * canyonHeight = 60f
	 *
	 * canyon strength
	 * canyonStrength = 40f
	 *
	 */
	public TerrainTrench(float heightStrength, /*float canyonWidth, float canyonHeight, float canyonStrength, */float baseHeight)
	{
		height = new float[]{10.0f, 0.5f, 30.5f, 0.5f};
		strength = heightStrength;
		heightLength = height.length;
		//cWidth = canyonWidth;
		//cHeigth = canyonHeight;
		//cStrength = canyonStrength;
		base = baseHeight;
	}

	@Override
	public float generateNoise(PerlinNoise perlin, CellNoise cell, int x, int z, float ocean, float border, float river)
	{
		float h = perlin.noise2(x / 200, z / 200);

		if ( h > 0.5f ) {
			float t = (perlin.noise2(x / 120f, z / 20f) * 0.5f) + 0.5f;

			h = (t * 50f);
		}

		return 70f - h;
	}

}
