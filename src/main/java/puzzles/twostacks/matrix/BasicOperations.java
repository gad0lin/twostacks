package puzzles.twostacks.matrix;

import puzzles.twostacks.matrix.elementoperations.AddIntegerOperation;
import puzzles.twostacks.matrix.elementoperations.IntegerOperation;
import puzzles.twostacks.matrix.elementoperations.SubstactIntegerOperation;

public class BasicOperations {
	public static boolean canBeMultiplied(IMatrix a, IMatrix b) {
		return a.getColumnCount() == b.getRowCount();
	}

	public static boolean canBeAdded(IMatrix a, IMatrix b) {
		return a.getColumnCount() == b.getColumnCount()
				&& a.getRowCount() == b.getRowCount();
	}

	@SuppressWarnings("unchecked")
	public static <K extends IMatrix> K add(K a, K b) {
		return arithmeticOperation(a, b, new AddIntegerOperation());
	}

	@SuppressWarnings("unchecked")
	public static <K extends IMatrix> K substract(K a, K b) {
		return arithmeticOperation(a, b, new SubstactIntegerOperation());
	}

	@SuppressWarnings("unchecked")
	public static <K extends IMatrix> K arithmeticOperation(K a, K b, IntegerOperation operation) {
		int[][] sum = null;
		if (canBeAdded(a, b)) {
			Position p = new Position();
			sum = new int[a.getRowCount()][a.getColumnCount()];
			for (int row = 0; row < a.getRowCount(); row++) {
				for (int column = 0; column < a.getColumnCount(); column++) {
					p.setRow(row).setColumn(column);
					sum[row][column] = operation.execute(a.getValue(p),
							b.getValue(p));
				}
			}
		} else {
			throw new IllegalArgumentException();
		}
		K result;
		try {
			result = ((K) (a.getClass().newInstance()));
			result.setValues(sum);
			return result;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
