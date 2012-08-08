package puzzles.twostacks.matrix;

public class Utils {
	static void copyMatrix(RegionMatrix sourceRegion, RegionMatrix targetRegion) {
		int rowWidth = sourceRegion.getRowCount();
		int colWidth = sourceRegion.getColumnCount();
		Position p = new Position();
		for (int row = 0; row < rowWidth; row++) {
			for (int column = 0; column < colWidth; column++) {
				p.setRow(row).setColumn(column);
				targetRegion.setValue(p, sourceRegion.getValue(p));
			}
		}
	}

	public static ISquarMatrix getSubMatrix(ISquarMatrix a, Position start,
			Span span) {
		return new RegionMatrix(a, start, span);
	}

	public static String toString(IMatrix matrix) {
		String v = "";
		v += "[\n";
		Position p = new Position();
		for (int row = 0; row < matrix.getRowCount(); row++) {
			for (int column = 0; column < matrix.getColumnCount(); column++) {
				p.setRow(row).setColumn(column);
				v += matrix.getValue(p) + " ";
			}
			v += "\n";
		}
		v += "]";
		return v;
	}

	public static boolean matrixEq(IMatrix a, IMatrix b) {
		return haveSameSize(a, b) && haveSameElements(a, b);
	}

	private static boolean haveSameElements(IMatrix a, IMatrix b) {
		Position p = new Position();
		for (int row = 0; row < a.getRowCount(); row++) {
			for (int column = 0; column < a.getColumnCount(); column++) {
				p.setRow(row).setColumn(column);
				if (a.getValue(p) != b.getValue(p)) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean haveSameSize(IMatrix a, IMatrix b) {
		return a.getColumnCount() == b.getColumnCount()
				&& a.getRowCount() == b.getRowCount();
	}

	public static int[][] getValues(IMatrix a) {
		int[][] values = new int[a.getRowCount()][a.getColumnCount()];
		Position p = new Position();
		for (int row = 0; row < a.getRowCount(); row++) {
			for (int column = 0; column < a.getColumnCount(); column++) {
				p.setRow(row).setColumn(column);
				values[row][column] = a.getValue(p);
			}
		}
		return values;
	}

	public static ISquarMatrix getIdentity(int size) {
		int[][] values = new int[size][size];
		for (int i = 0; i < size; i++) {
			values[i][i] = 1;
		}
		return new SquareMatrix(values);
	}

	public static ISquarMatrix getZero(int size) {
		int[][] values = new int[size][size];
		return new SquareMatrix(values);
	}

	public static ISquarMatrix getZero(int row, int columns) {
		int[][] values = new int[row][columns];
		return new SquareMatrix(values);
	}

}
