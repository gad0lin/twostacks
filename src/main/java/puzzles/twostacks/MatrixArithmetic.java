package puzzles.twostacks;

abstract public class MatrixArithmetic {

	public boolean canBeMultiplied(Matrix a, Matrix b) {
		return a.getColumnCount() == b.getRowCount();
	}

	public boolean canBeAdded(Matrix a, Matrix b) {
		return a.getColumnCount() == b.getColumnCount()
				&& a.getRowCount() == b.getRowCount();
	}

	public Matrix add(Matrix a, Matrix b) {
		int[][] sum = null;
		if (canBeAdded(a, b)) {
			sum = new int[a.getRowCount()][a.getColumnCount()];
			for (int i = 0; i < a.getRowCount(); i++) {
				for (int j = 0; j < a.getColumnCount(); j++) {
					sum[i][j] = a.getElement(i, j) + b.getElement(i, j);
				}
			}
		} else {
			throw new IllegalArgumentException();
		}
		return new Matrix(sum);
	}

	abstract Matrix multiply(Matrix a, Matrix b);
}
