package puzzles.twostacks;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountElementsTest {

	CountElements counter = new CountElements();
	@Test
	public void shouldCountNull() {
		assertTrue(counter.getElementsCount(null) == 0);
	}
	@Test
	public void shouldCount1() {
		assertTrue(counter.getElementsCount(new BTree()) == 1);
	}

	@Test
	public void shouldCount2() {
		assertTrue(counter.getElementsCount(new BTree(new BTree(),null)) == 2);
	}
}
