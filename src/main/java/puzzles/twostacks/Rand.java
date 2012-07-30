package puzzles.twostacks;

import java.util.Random;

public class Rand {
	private static int seed = 0;
	private static Random r = new Random(seed);

	public static int randInt(int left, int right) {
		return left + r.nextInt(right - left);
	}

	public static void setSeed(int seed) {
		Rand.seed = seed;
		Rand.r = new Random(seed);
	}
}
