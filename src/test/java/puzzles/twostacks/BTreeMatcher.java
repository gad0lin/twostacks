package puzzles.twostacks;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class BTreeMatcher  extends TypeSafeMatcher<BTree>{
	
	private BTree btree;
	private CompareBSTs comparator = new CompareBSTs();
	InOrderPrint p = new InOrderPrint();
	
	
	public BTreeMatcher(BTree btree) {
		this.btree = btree;
	}

	public void describeTo(Description description) {
		description.appendText(p.printAsString(btree).toString());
	}

	@Override
	public boolean matchesSafely(BTree item) {
		System.out.println(item);
		return comparator.areEqual(btree, item);
	}

	public static BTreeMatcher isSameTreeAs(BTree tree) {
		return new BTreeMatcher(tree);
	}
}
