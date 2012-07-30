package puzzles.twostacks;

import static org.junit.Assert.*;

import org.junit.Test;

public class RandomizedSelectTest {

	@Test
	public void shouldFindIthElementWhenOneElement() {
		RandomizedSelect rs = new RandomizedSelect(new int[] { 99 });
		assertTrue(rs.select(1) == 99);
	}

	@Test
	public void shouldFindIthElementWhenTwoElements() {
		RandomizedSelect rs = new RandomizedSelect(new int[] { 99, 11 });
		assertTrue(rs.select(1) == 99);
		assertTrue(rs.select(0) == 11);
	}

	@Test
	public void shouldFindIthElementWhenThreeElements() {
		RandomizedSelect rs = new RandomizedSelect(new int[] { 99, 11, 0 });
		assertTrue(rs.select(2) == 99);
		System.out.println(rs.select(1));
		assertTrue(rs.select(1) == 11);
		assertTrue(rs.select(0) == 0);
	}

}
