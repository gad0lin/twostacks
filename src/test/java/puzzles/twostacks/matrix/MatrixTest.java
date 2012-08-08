package puzzles.twostacks.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.twostacks.matrix.Matrix;

public class MatrixTest {

	@Test
	public void testElements() {
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
		IMatrix m = new Matrix(arr);
		Position p = new Position(0, 0);
		for (int row = 0; row < arr.length; row++) {
			for (int column = 0; column < arr[0].length; column++) {
				p.setRow(row).setColumn(column);
				assertTrue(m.getValue(p) == arr[row][column]);
			}
		}
		assertTrue(m.getRowCount() == 2);
		assertTrue(m.getColumnCount() == 3);
	}

	@Test
	public void shouldExecuteEqual() {
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
		IMatrix m = new Matrix(arr);

		assertTrue(m.equals(m));

	}
}
