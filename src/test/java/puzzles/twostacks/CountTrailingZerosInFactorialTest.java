package puzzles.twostacks;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Write an algorithm which computes the number of trailing zeros in n
 * factorial. EXAMPLE input: 11 output: 2 (11! = 39916800)
 * 
 * @author krzysztofbarczynski
 * 
 */
public class CountTrailingZerosInFactorialTest {

	CountTrailingZerosInFactorial counter = new CountTrailingZerosInFactorial();

	@Test
	public void shouldCountLessThen5() {
		for (int i = 0; i < 4; i++) {
			assertTrue(counter.getTrailingZerosCount(i) == 0);
		}
	}

	@Test
	public void shouldCountFactorial100() {
		assertTrue(counter.getTrailingZerosCount(100) == 24);
	}
}
