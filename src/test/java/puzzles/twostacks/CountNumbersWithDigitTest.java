package puzzles.twostacks;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountNumbersWithDigitTest {

	CountNumbersWithDigit cnwd = new CountNumbersWithDigit(2);

	@Test
	public void shouldCountSingleDigitNo() {
		assertTrue(cnwd.count(1) == 0);
		for (int i = 2; i < 10; i++)
			assertTrue(cnwd.count(i) == 1);
	}

	@Test
	public void shouldCount2DigitNo() {
		assertInRange(10, 11, 1);
		assertInRange(12, 19, 2);
		assertInRange(20, 20, 3);
		assertInRange(21, 21, 4);
		assertInRange(99, 99, 19);
	}

	void assertInRange(int low, int up, int count) {
		for (int i = low; i < up; i++) {
			assertTrue(cnwd.count(i) == count);
		}

	}

}
