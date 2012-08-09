package puzzles.twostacks.matrix;

public abstract class SquaredMultiplier implements MatrixArithmetic {

	@Override
	public IMatrix multiply(IMatrix a, IMatrix b) {
		ISquarMatrix squaredA = SquarMatixOfPowerOf2.getSquaredMatrix(a);
		ISquarMatrix squaredB = SquarMatixOfPowerOf2.getSquaredMatrix(b);
		ISquarMatrix result = squareMatrixMultiply(squaredA, squaredB);
		return Utils.getSubMatrix(result, new Position(0, 0),
				new Span(a.getRowCount(), b.getColumnCount()));
	}

	protected ISquarMatrix squareMatrixMultiply(ISquarMatrix squaredA,
			ISquarMatrix squaredB) {
		if (squaredA.getSize() == 1) {
			return new SquareMatrix(
					new int[][] { { squaredA.getValue(new Position(0, 0))
							* squaredB.getValue(new Position(0, 0)) } });
		}
		MatrixSplit as = new MatrixSplit(squaredA);
		MatrixSplit bs = new MatrixSplit(squaredB);
		return squareMatrixMultiply(as, bs);
	}

	abstract protected ISquarMatrix squareMatrixMultiply(MatrixSplit squaredA,
			MatrixSplit squaredB);

}
