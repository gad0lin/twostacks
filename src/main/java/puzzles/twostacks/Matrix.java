package puzzles.twostacks;

public class Matrix {

	private int[][] matrix;

	public Matrix(int[][] matrix) {
		this.matrix = matrix;
	}

	public Matrix mul(Matrix b) {
		return null;
	}

	public int getElement(int row, int column) {
		return matrix[row][column];
	}

	public int getRowCount() {
		return matrix.length;
	}

	public int getColumnCount() {
		return matrix[0].length;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Matrix) {
			Matrix m = (Matrix) obj;
			if (m.getColumnCount() == getColumnCount()
					&& m.getRowCount() == getRowCount()) {
				return areEqual(m);
			}
		}
		return false;
	}

	private boolean areEqual(Matrix m) {
		for (int i = 0; i < getRowCount(); i++) {
			for (int j = 0; j < getRowCount(); j++) {
				if (getElement(i, j) != m.getElement(i, j)) {
					return false;
				}
			}
		}
		return true;
	}

}
