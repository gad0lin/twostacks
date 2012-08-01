package puzzles.twostacks;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public abstract class SelectorTest {

	@Test
	public void shouldFindIthElementWhenOneElement() {
		Selector rs = createSelector(new int[] { 99 });
		assertTrue(rs.select(0) == 99);
	}

	@Test
	public void shouldFindIthElementWhenTwoElements() {
		Selector rs = createSelector(new int[] { 99, 11 });
		assertTrue(rs.select(1) == 99);
		assertTrue(rs.select(0) == 11);
	}

	@Test
	public void shouldFindIthElementWhenThreeElements() {
		Selector rs = createSelector(new int[] { 99, 11, 0 });
		assertTrue(rs.select(2) == 99);
		assertTrue(rs.select(1) == 11);
		assertTrue(rs.select(0) == 0);
	}

	@Test
	public void shouldFindIthElementWhenFourElements() {
		Selector rs = createSelector(new int[] { 99, 11, 0, 4 });
		assertTrue(rs.select(3) == 99);
		assertTrue(rs.select(2) == 11);
		assertTrue(rs.select(1) == 4);
		assertTrue(rs.select(0) == 0);
	}

	@Test
	public void shouldFindIthElementWhenFiveElements() {
		Selector rs = createSelector(new int[] { 99, 11, 0, 4, 1 });
		assertTrue(rs.select(4) == 99);
		assertTrue(rs.select(3) == 11);
		assertTrue(rs.select(2) == 4);
		assertTrue(rs.select(1) == 1);
		assertTrue(rs.select(0) == 0);
	}

	@Test
	public void shouldFindIthElementWhenSevenElements() {
		Selector rs = createSelector(new int[] { 99, 11, 100, 4, 1, 0, 220 });
		assertTrue(rs.select(6) == 220);
		assertTrue(rs.select(5) == 100);
		assertTrue(rs.select(4) == 99);
		assertTrue(rs.select(3) == 11);
		assertTrue(rs.select(2) == 4);
		assertTrue(rs.select(1) == 1);
		assertTrue(rs.select(0) == 0);
	}
	
	@Test
	public void shouldFindIthElementWhenEightElements() {
		Selector rs = createSelector(new int[] {231, 99, 11, 100, 4, 1, 0, 220 });
		assertTrue(rs.select(7) == 231);
		assertTrue(rs.select(6) == 220);
		assertTrue(rs.select(5) == 100);
		assertTrue(rs.select(4) == 99);
		assertTrue(rs.select(3) == 11);
		assertTrue(rs.select(2) == 4);
		assertTrue(rs.select(1) == 1);
		assertTrue(rs.select(0) == 0);
	}

	abstract public Selector createSelector(int[] arr);
}
