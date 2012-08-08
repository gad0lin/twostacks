package puzzles.twostacks.matrix;

public class SquarMatixOfPowerOf2 {
	public static ISquarMatrix getSquaredMatrix(IMatrix source) {
		int greatesDimension = Math.max(source.getRowCount(),
				source.getColumnCount());
		if (isPowerOf2(greatesDimension)) {
			return new SquareMatrix(source);
		} else {
			int nearestPowerOf2 = getNearestPowerOf2(greatesDimension);
			int[][] squaredMatrixValue = new int[nearestPowerOf2][nearestPowerOf2];
			SquareMatrix target = new SquareMatrix(squaredMatrixValue);
			RegionMatrix targetRegion = new RegionMatrix(target);
			Utils.copyMatrix(new RegionMatrix(source), targetRegion);
			return targetRegion;
		}
	}

	private static int getNearestPowerOf2(int number) {
		int nearestPowerOf2 = 1;
		while (nearestPowerOf2 < number) {
			nearestPowerOf2 *= 2;
		}
		return nearestPowerOf2;
	}

	public static boolean isPowerOf2(int number) {
		return (number & (number - 1)) == 0;
	}

}
