package puzzles.twostacks;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListTest {

	@Test
	public void shouldEncodeEmptyNumber() {
		List list = new List("");
		assertTrue(list.toString().equals(""));
	}
	
	@Test
	public void shouldEncode1Number() {
		List list = new List("1");
		assertTrue(list.toString().equals("1"));
	}
	
	@Test
	public void shouldEncodeInteger1Number() {
		List list = new List(1);
		assertTrue(list.toString().equals("1"));
	}
	
	@Test
	public void shouldEncode2DigitNum() {
		List list = new List("12");
		assertTrue(list.toString().equals("12"));
	}
	

}
