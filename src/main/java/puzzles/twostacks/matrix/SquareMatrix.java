package puzzles.twostacks.matrix;

public class SquareMatrix extends Matrix implements ISquarMatrix {

	public SquareMatrix() {
		super();
	}

	public SquareMatrix(int squareSize) {
		super(new int[squareSize][squareSize]);
	}

	public SquareMatrix(int[][] val) {
		super(val);
	}

	public SquareMatrix(IMatrix b) {
		this(Utils.getValues(b));
	}

	public int getSize() {
		return getColumnCount();
	}

}
