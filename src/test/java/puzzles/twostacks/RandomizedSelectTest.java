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
		assertTrue(rs.select(1) == 11);
		assertTrue(rs.select(0) == 0);
	}
	
	@Test
	public void shouldFindIthElementWhenFourElements() {
		RandomizedSelect rs = new RandomizedSelect(new int[] { 99, 11, 0,4 });
		assertTrue(rs.select(3) == 99);
		assertTrue(rs.select(2) == 11);
		assertTrue(rs.select(1) == 4);
		assertTrue(rs.select(0) == 0);
	}
	
	@Test
	public void shouldFindIthElementWhenFiveElements() {
		RandomizedSelect rs = new RandomizedSelect(new int[] { 99, 11, 0,4,1 });
		assertTrue(rs.select(4) == 99);
		assertTrue(rs.select(3) == 11);
		assertTrue(rs.select(2) == 4);
		assertTrue(rs.select(1) == 1);
		assertTrue(rs.select(0) == 0);
	}
	@Test
	public void shouldFindIthElementWhenSixElements() {
		RandomizedSelect rs = new RandomizedSelect(new int[] { 99, 11, 100,4,1,0,220});
		assertTrue(rs.select(6) == 220);
		assertTrue(rs.select(5) == 100);
		assertTrue(rs.select(4) == 99);
		assertTrue(rs.select(3) == 11);
		assertTrue(rs.select(2) == 4);
		assertTrue(rs.select(1) == 1);
		assertTrue(rs.select(0) == 0);
	}

}
