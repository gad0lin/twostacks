package puzzles.twostacks;

public class ValidateBTree {
	
	
	public boolean validateBTree(BTree btree) {
		return validate(btree, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean validate(BTree btree, int minValue, int maxValue) {
		if (btree == null) {
			return true;
		}
		int value = btree.getValue();
		return isWithinInterval(value, minValue, maxValue) && validate(btree.getLeft(), minValue, value) && validate(btree.getRight(), value, maxValue);
	}

	private boolean isWithinInterval(Integer value, int minValue, int maxValue) {
		return value >= minValue && maxValue >= value;
	}
	
	
}
