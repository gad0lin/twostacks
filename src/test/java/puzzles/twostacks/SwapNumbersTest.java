package puzzles.twostacks;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SwapNumbersTest {

	@Test
	public void shouldInverWhen2nulls() {
		checkInvert(0, 0);
	}
	@Test
	public void shouldInverWhenOneAnd0() {
		checkInvert(1, 0);
	}
	@Test
	public void shouldInverWhenTwoAnd0() {
		checkInvert(2, 0);
	}
	@Test
	public void shouldInverWhenTwoAndOne() {
		checkInvert(2, 1);
	}
	@Test
	public void shouldInverWhenDiffersIn1sAndOs() {
		checkInvert(5, 3);
	}
	
	void checkInvert(int first, int second) {
		SwapNumbers sn = new SwapNumbers(first, second);
		assertTrue(sn.getFirst() == first);
		assertTrue(sn.getSecond() == second);
		sn.invert();
		assertTrue(sn.getFirst() == second);
		assertTrue(sn.getSecond() == first);
		sn.invert();
		assertTrue(sn.getFirst() == first);
		assertTrue(sn.getSecond() == second);
	}
}
