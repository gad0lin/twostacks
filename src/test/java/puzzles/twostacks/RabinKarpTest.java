package puzzles.twostacks;

import static org.junit.Assert.*;

import org.junit.Test;

public class RabinKarpTest {

	@Test
	public void shouldFindSingleCharPattern() {
		RabinKarp rk = new RabinKarp("a", "a");
		assertTrue(rk.getPatternIndex() == 0);
	}

	@Test
	public void shouldFindDoubleCharPatternAtWhenAt0() {
		RabinKarp rk = new RabinKarp("aa", "aa");
		assertTrue(rk.getPatternIndex() == 0);
	}

	@Test
	public void shouldFindDoubleCharPatternAtWhenAt1() {
		RabinKarp rk = new RabinKarp("baa", "aa");
		assertTrue(rk.getPatternIndex() == 1);
	}

	@Test
	public void shouldFindThreeCharPatternAtWhenAt1() {
		RabinKarp rk = new RabinKarp("baaa", "aaa");
		assertTrue(rk.getPatternIndex() == 1);
	}

	@Test
	public void shouldFindThreeCharPatternAtWhenDifferentChars() {
		RabinKarp rk = new RabinKarp("bababc", "abc");
		assertTrue(rk.getPatternIndex() == 3);
	}
	
	@Test
	public void shouldFindFourCharPatternAtWhenDifferentChars() {
		RabinKarp rk = new RabinKarp("bababc", "babc");
		assertTrue(rk.getPatternIndex() == 2);
	}
}
