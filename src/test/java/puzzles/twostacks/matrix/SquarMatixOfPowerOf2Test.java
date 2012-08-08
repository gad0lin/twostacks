package puzzles.twostacks.matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class SquarMatixOfPowerOf2Test {

	@Test
	public void shouldSqureMatrixWhen1() {
		IMatrix i1 = Utils.getIdentity(1);
		IMatrix result = SquarMatixOfPowerOf2.getSquaredMatrix(i1);
		Utils.matrixEq(i1, result);
	}

	@Test
	public void shouldSqureMatrixWhen2() {
		IMatrix matrix = Utils.getIdentity(2);
		IMatrix result = SquarMatixOfPowerOf2.getSquaredMatrix(matrix);
		Utils.matrixEq(matrix, result);
	}

	@Test
	public void shouldSqureMatrixWhen3() {
		IMatrix matrix = Utils.getIdentity(3);
		ISquarMatrix result = SquarMatixOfPowerOf2.getSquaredMatrix(matrix);

		assertTrue(result.getSize() == 4);
		Utils.matrixEq(
				new RegionMatrix(result, new Position(), new Span(4, 4)),
				result);
		Position p = new Position(0, 3);
		for (int row = 0; row < 4; row++) {
			p.setRow(row);
			assertTrue(result.getValue(p) == 0);
		}

		p = new Position(3, 0);
		for (int column = 0; column < 4; column++) {
			p.setColumn(column);
			assertTrue(result.getValue(p) == 0);
		}

	}

}
