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
		eq(sn,first,second);
		sn.invert();
		eq(sn,second,first);
		sn.invert();
		eq(sn,first,second);
		sn.invertWithoutXOR();
		eq(sn,second,first);
		sn.invertWithoutXOR();
		eq(sn,first,second);
	}
	
	private void eq(SwapNumbers sn, int first, int second) {
		assertTrue(sn.getFirst() == first);
		assertTrue(sn.getSecond() == second);
	}
}
