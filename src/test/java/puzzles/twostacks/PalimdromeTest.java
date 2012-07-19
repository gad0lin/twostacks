package puzzles.twostacks;

import static org.junit.Assert.*;

import org.junit.Test;

public class PalimdromeTest {
	
	Palimdrome p = new Palimdrome();

	@Test
	public void testIsPalindromString() {
		assertTrue(p.isPalindrom("a"));
		assertTrue(p.isPalindrom(""));
		assertTrue(p.isPalindrom("aa"));
		assertTrue(p.isPalindrom("aaa"));
		assertFalse(p.isPalindrom("ab"));
		assertFalse(p.isPalindrom("abc"));
	}
}
