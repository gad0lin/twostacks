package puzzles.twostacks;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

	@Test
	public void testElements() {
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
		Matrix m = new Matrix(arr);
		assertTrue(m.getElement(0, 0) == 1);
		assertTrue(m.getElement(0, 1) == 2);
		assertTrue(m.getElement(0, 2) == 3);
		assertTrue(m.getElement(1, 0) == 4);
		assertTrue(m.getElement(1, 1) == 5);
		assertTrue(m.getElement(1, 2) == 6);
		assertTrue(m.getRowCount() == 2);
		assertTrue(m.getColumnCount() == 3);
	}

	@Test
	public void shouldExecuteEqual() {
		int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };
		Matrix m = new Matrix(arr);

		assertTrue(m.equals(m));

	}
}
