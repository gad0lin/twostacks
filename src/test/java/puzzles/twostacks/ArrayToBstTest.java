package puzzles.twostacks;


import org.hamcrest.core.IsNull;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static puzzles.twostacks.BTreeMatcher.isSameTreeAs;
import static org.junit.Assert.*;
public class ArrayToBstTest {

	ArrayToBst transform = new ArrayToBst();
	
	CountElements counter = new CountElements();
	
	PrintMe printMe = new InOrderPrint();
	
	ValidateBTree validate = new ValidateBTree();
	@Test
	public void shouldProcess1El() {
		BTree  b = transform.getTree(new int[]{1});
		assertTrue (counter.getElementsCount(b) == 1);
		assertThat(b, isSameTreeAs(new BTree(1)));
	}
	@Test
	public void shouldProcessNull() {
		BTree  b = transform.getTree(null);
		assertThat(null, nullValue());
		
//		BTreeMatcher m = isSameTreeAs(null);
//		assertTrue(m.matchesSafely(null));
		
		assertTrue (counter.getElementsCount(b) == 0);
	}
	@Test
	public void shouldProcess2() {
		BTree  b = transform.getTree(new int[] {1,2,3});
		assertTrue (counter.getElementsCount(b) == 3);
		validate(b);
	}
	
	@Test
	public void shouldProcess4() {
		BTree  b = transform.getTree(new int[] {1,2,3,4});
		assertTrue (counter.getElementsCount(b) == 4);
		validate(b);
		printMe(b);
	}
	
	private void printMe(BTree b) {
		printMe.print(b);
	}
	
	private void validate(BTree btree) {
		assertTrue(validate.validateBTree(btree));
	}

}
