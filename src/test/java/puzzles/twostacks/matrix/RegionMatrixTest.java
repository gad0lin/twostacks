package puzzles.twostacks.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegionMatrixTest {

	@Test
	public void shouldHandleSquare1Matrix() {
		IMatrix i1 = Utils.getIdentity(1);
		testWriteInLeftTopCorner(i1);
	}

	@Test
	public void shouldHandleSquare2Matrix() {
		IMatrix matrix = Utils.getIdentity(2);
		testWriteInLeftTopCorner(matrix);

		matrix = asMatrix(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
		IMatrix subMatrix = asMatrix(new int[][] { { 5, 6 }, { 8, 9 } });
		Position p = new Position(1, 1);
		RegionMatrix rm = new RegionMatrix(matrix, p, new Span(2, 2));
		assertTrue(Utils.matrixEq(rm, subMatrix));
	}

	private IMatrix asMatrix(int[][] is) {
		return new Matrix(is);
	}

	public void testWriteInLeftTopCorner(IMatrix matrix) {
		RegionMatrix rm = new RegionMatrix(matrix, new Position(), new Span(1,
				1));
		Position p = new Position();
		p.setColumn(0).setRow(0);
		assertTrue(rm.getValue(p) == 1);
		assertTrue(rm.getRowCount() == 1);
		assertTrue(rm.getColumnCount() == 1);
		assertTrue(rm.getSize() == 1);
		rm.setValue(p, 2);
		assertTrue(matrix.getValue(p) == 2);
	}
}
