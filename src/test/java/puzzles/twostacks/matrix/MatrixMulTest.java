package puzzles.twostacks.matrix;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public abstract class MatrixMulTest {

	int size;
	MatrixArithmetic nma = createMulProvider();

	public MatrixMulTest(int size) {
		this.size = size;
	}

	@Test
	public void shouldMulBy0andIdentity() {

		IMatrix identity = Utils.getIdentity(size);
		IMatrix zero = Utils.getZero(size);

		// When
		IMatrix mulIdentity = nma.multiply(identity, identity);
		IMatrix mulByZero = nma.multiply(identity, zero);
		// Then
		assertTrue(Utils.matrixEq(identity, mulIdentity));
		assertTrue(Utils.matrixEq(mulByZero, zero));
	}

	abstract protected MatrixArithmetic createMulProvider();

	

	@Test
	public void shouldMulWhenSize2() {
		// Given
		int[][] m = new int[][] { { 1, 2 }, { 3, 4 } };
		int[][] expected = new int[][] { { 7, 10 }, { 15, 22 } };
		IMatrix mat = new Matrix(m);
		IMatrix extectedM = new Matrix(expected);
		// when
		IMatrix calcMat = nma.multiply(mat, mat);

		// Then
		assertTrue(Utils.matrixEq(calcMat,extectedM));
	}

	@Test
	public void shouldMulWhenSize3() {
		// Given
		int[][] expected = new int[][] { { 30, 36, 15 }, { 78, 96, 51 },
				{ 44, 61, 78 } };
		int[][] m1 = new int[][] { { 1, 2, 3 }, { 5, 6, 7 }, { 8, 9, 0 } };
		int[][] m2 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };
		IMatrix mat1 = new Matrix(m1);
		IMatrix mat2 = new Matrix(m2);
		IMatrix extectedM = new Matrix(expected);
		// when
		IMatrix calcMat = nma.multiply(mat1, mat2);

		// Then
		assertTrue(Utils.matrixEq(calcMat, extectedM));
	}

	@Parameters
	public static Collection data() {
		Object[][] data = new Object[][] { { 1 }, { 2 }, { 4 }, { 8 } };
		return Arrays.asList(data);
	}
}
