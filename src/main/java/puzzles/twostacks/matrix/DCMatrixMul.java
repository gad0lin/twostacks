package puzzles.twostacks.matrix;

public class DCMatrixMul extends MatrixArithmetic {

	public ISquarMatrix squareMatrixMultiplyRecursive(ISquarMatrix a,
			ISquarMatrix b) {
		if (a.getSize() == 1) {
			return new SquareMatrix(new int[][] { { a.getValue(new Position(0,
					0)) * b.getValue(new Position(0, 0)) } });
		}
		MatrixSplit as = new MatrixSplit(a);
		MatrixSplit bs = new MatrixSplit(b);
		ISquarMatrix leftTop = add(
				squareMatrixMultiplyRecursive(as.leftTop(), bs.leftTop()),
				squareMatrixMultiplyRecursive(as.rightTop(), bs.leftBottom()));
		ISquarMatrix rightTop = add(
				squareMatrixMultiplyRecursive(as.leftTop(), bs.rightTop()),
				squareMatrixMultiplyRecursive(as.rightTop(), bs.rightBottom()));
		ISquarMatrix leftBottom = add(
				squareMatrixMultiplyRecursive(as.leftBottom(), bs.leftTop()),
				squareMatrixMultiplyRecursive(as.rightBottom(), bs.leftBottom()));
		ISquarMatrix rightBottom = add(
				squareMatrixMultiplyRecursive(as.leftBottom(), bs.rightTop()),
				squareMatrixMultiplyRecursive(as.rightBottom(),
						bs.rightBottom()));
		MatrixSplit cs = new MatrixSplit().setLeftBottom(leftBottom)
				.setLeftTop(leftTop).setRightBottom(rightBottom)
				.setRightTop(rightTop);
		return cs.create();
	}

	@Override
	IMatrix multiply(IMatrix a, IMatrix b) {
		ISquarMatrix squaredA = SquarMatixOfPowerOf2.getSquaredMatrix(a);
		ISquarMatrix squaredB = SquarMatixOfPowerOf2.getSquaredMatrix(b);
		ISquarMatrix result = squareMatrixMultiplyRecursive(squaredA, squaredB);
		return Utils.getSubMatrix(result, new Position(0, 0),
				new Span(a.getRowCount(), b.getColumnCount()));
	}
}
