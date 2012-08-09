package puzzles.twostacks.matrix;

import static puzzles.twostacks.matrix.BasicOperations.add;

public class DCMatrixMul extends SquaredMultiplier {

	public ISquarMatrix squareMatrixMultiply(MatrixSplit as, MatrixSplit bs) {

		ISquarMatrix leftTop = add(
				squareMatrixMultiply(as.leftTop(), bs.leftTop()),
				squareMatrixMultiply(as.rightTop(), bs.leftBottom()));
		ISquarMatrix rightTop = add(
				squareMatrixMultiply(as.leftTop(), bs.rightTop()),
				squareMatrixMultiply(as.rightTop(), bs.rightBottom()));
		ISquarMatrix leftBottom = add(
				squareMatrixMultiply(as.leftBottom(), bs.leftTop()),
				squareMatrixMultiply(as.rightBottom(), bs.leftBottom()));
		ISquarMatrix rightBottom = add(
				squareMatrixMultiply(as.leftBottom(), bs.rightTop()),
				squareMatrixMultiply(as.rightBottom(), bs.rightBottom()));
		MatrixSplit cs = new MatrixSplit().setLeftBottom(leftBottom)
				.setLeftTop(leftTop).setRightBottom(rightBottom)
				.setRightTop(rightTop);
		return cs.create();
	}

}
