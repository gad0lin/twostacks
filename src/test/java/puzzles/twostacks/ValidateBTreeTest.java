package puzzles.twostacks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ValidateBTreeTest {
	
	ValidateBTree vbt = new  ValidateBTree();
	BTree one = new BTree(1);
	BTree two = new BTree(2);
	BTree three = new BTree(3);
	BTree four = new BTree(4);
	BTree five = new BTree(5);
	
	@Test
	public void shouldValidateNullOk() {
		assertTrue(vbt.validateBTree(null));
	}

	@Test
	public void shouldValidateOneOk() {
		assertTrue(vbt.validateBTree(new BTree(null, null, 1)));
	}
	@Test
	public void shouldValidate2Ok() {
		assertTrue(vbt.validateBTree(new BTree(one, null, 2)));
		assertTrue(vbt.validateBTree(new BTree(two, null, 2)));
		
		assertTrue(vbt.validateBTree(new BTree(null, three, 2)));
		assertTrue(vbt.validateBTree(new BTree(null, two, 2)));
		
		assertFalse(vbt.validateBTree(new BTree(new BTree(3), null, 2)));
		assertFalse(vbt.validateBTree(new BTree(null, new BTree(1), 2)));
	}
	
	@Test
	public void shouldValidate3Ok() {
		assertTrue(vbt.validateBTree(new BTree(one, three, 2)));
		assertFalse(vbt.validateBTree(new BTree(three, one, 2)));
		assertTrue(vbt.validateBTree(new BTree(two, two, 2)));
	}
	
	@Test
	public void shouldValidate4Ok() {
		assertTrue(vbt.validateBTree(new BTree(new BTree(one, three, 2), null,4)));
		assertFalse(vbt.validateBTree(new BTree(new BTree(one, five, 2), null,4)));
		//assertFalse(vbt.validateBTree(new BTree(three, one, 2)));
		//assertTrue(vbt.validateBTree(new BTree(two, two, 2)));
	}
	
}
