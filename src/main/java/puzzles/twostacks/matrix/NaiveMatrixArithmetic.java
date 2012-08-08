package puzzles.twostacks.matrix;

public class NaiveMatrixArithmetic extends MatrixArithmetic {

	@Override
	IMatrix multiply(IMatrix a, IMatrix b) {
		Position left = new Position();
		Position right = new Position();
		int[][] res = new int[a.getRowCount()][b.getColumnCount()];
		for (int i = 0; i < a.getRowCount(); i++) {
			for (int j = 0; j < a.getColumnCount(); j++) {
				for (int k = 0; k < a.getColumnCount(); k++) {
					left.setRow(i).setColumn(k);
					right.setRow(k).setColumn(j);
					res[i][j] = res[i][j] + a.getValue(left)
							* b.getValue(right);
				}
			}
		}
		return new Matrix(res);
	}

}