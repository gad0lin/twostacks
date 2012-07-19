package puzzles.twostacks;

public class CompareBSTs {
	
	public boolean areEqual(BTree one, BTree two) {
		
		if(one == null && two == null) {
			return true;
		}
		if (one == null && two != null) {
			return false;
		}
		if (two == null && one != null) {
			return false;
		}
		
		if(one.getValue() != two.getValue()) {
			return false;
		}
		return areEqual(one.getLeft(), two.getLeft()) && areEqual(one.getRight(), two.getRight());
	}
}
