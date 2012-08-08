package puzzles.twostacks.matrix;

public class Matrix implements IMatrix {

	private int[][] matrix;

	public Matrix() {

	}

	public Matrix(int[][] matrix) {
		this.matrix = matrix;
	}

	protected int[][] getValues() {
		return matrix;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see puzzles.twostacks.matrix.IMatrix#getElement(int, int)
	 */
	@Override
	public int getValue(Position p) {
		return matrix[p.getRow()][p.getColumn()];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see puzzles.twostacks.matrix.IMatrix#setValue(int[][])
	 */
	@Override
	public void setValues(int[][] values) {
		matrix = values;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see puzzles.twostacks.matrix.IMatrix#setValue(int, int, int)
	 */
	@Override
	public void setValue(Position p, int value) {
		matrix[p.getRow()][p.getColumn()] = value;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see puzzles.twostacks.matrix.IMatrix#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return matrix.length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see puzzles.twostacks.matrix.IMatrix#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return matrix[0].length;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof IMatrix)) {
			return false;
		}
		return Utils.matrixEq(this, (IMatrix) obj);
	}

	@Override
	public String toString() {
		return Utils.toString(this);
	}
}
