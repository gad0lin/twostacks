package puzzles.twostacks;

public class NaiveMatrixArithmetic extends MatrixArithmetic {

	@Override
	Matrix multiply(Matrix a, Matrix b) {
		int[][] res = new int[a.getRowCount()][b.getColumnCount()];
		for (int i = 0; i < a.getRowCount(); i++) {
			for (int j = 0; j < a.getColumnCount(); j++) {
				for (int k = 0; k < a.getColumnCount(); k++) {
					res[i][j] = res[i][j] + a.getElement(i, k)
							* a.getElement(k, j);
				}
			}
		}
		return new Matrix(res);
	}

}