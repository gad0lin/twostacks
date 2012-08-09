package puzzles.twostacks.matrix;

import static puzzles.twostacks.matrix.BasicOperations.substract;
import static puzzles.twostacks.matrix.BasicOperations.add;

public class StrassenAlgorithm extends SquaredMultiplier {

	@Override
	protected ISquarMatrix squareMatrixMultiply(MatrixSplit as, MatrixSplit bs) {
		ISquarMatrix a11 = as.leftTop();
		ISquarMatrix a12 = as.rightTop();
		ISquarMatrix a21 = as.leftBottom();
		ISquarMatrix a22 = as.rightBottom();

		ISquarMatrix b11 = bs.leftTop();
		ISquarMatrix b12 = bs.rightTop();
		ISquarMatrix b21 = bs.leftBottom();
		ISquarMatrix b22 = bs.rightBottom();

		ISquarMatrix s1 = substract(b12, b22);
		ISquarMatrix s2 = add(a11, a12);
		ISquarMatrix s3 = add(a21, a22);
		ISquarMatrix s4 = substract(b21, b11);
		ISquarMatrix s5 = add(a11, a22);
		ISquarMatrix s6 = add(b11, b22);
		ISquarMatrix s7 = substract(a12, a22);
		ISquarMatrix s8 = add(b21, b22);
		ISquarMatrix s9 = substract(a11, a21);
		ISquarMatrix s10 = add(b11, b12);

		ISquarMatrix p1 = squareMatrixMultiply(a11, s1);
		ISquarMatrix p2 = squareMatrixMultiply(s2, b22);
		ISquarMatrix p3 = squareMatrixMultiply(s3, b11);
		ISquarMatrix p4 = squareMatrixMultiply(a22, s4);
		ISquarMatrix p5 = squareMatrixMultiply(s5, s6);
		ISquarMatrix p6 = squareMatrixMultiply(s7, s8);
		ISquarMatrix p7 = squareMatrixMultiply(s9, s10);

		ISquarMatrix c11 = add(substract(add(p5, p4), p2), p6);
		ISquarMatrix c12 = add(p1, p2);
		ISquarMatrix c21 = add(p3, p4);
		ISquarMatrix c22 = substract(substract(add(p5, p1), p3), p7);

		return new MatrixSplit().setLeftTop(c11).setRightTop(c12)
				.setLeftBottom(c21).setRightBottom(c22).create();
	}

}
