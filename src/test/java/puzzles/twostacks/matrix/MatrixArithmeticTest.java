package puzzles.twostacks.matrix;

import org.junit.Test;

import puzzles.twostacks.matrix.Matrix;
import puzzles.twostacks.matrix.MatrixArithmetic;

public class MatrixArithmeticTest {

	MatrixArithmetic ma = new MatrixArithmetic() {
		@Override
		IMatrix multiply(IMatrix a, IMatrix b) {
			return null;
		}
	};

	@Test
	public void test() {
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] arr2 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] arr3 = new int[][] { { 2, 4, 6 }, { 8, 10, 12 } };
		Matrix m1 = new Matrix(arr);
		Matrix m2 = new Matrix(arr2);
		IMatrix m3 = new Matrix(arr3);
		m3.equals(MatrixArithmetic.add(m1, m2));
	}
}
