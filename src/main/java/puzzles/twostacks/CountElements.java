package puzzles.twostacks;

public class CountElements {
	
	
	int getElementsCount(BTree btree) {
		
		if(btree == null) {
			return 0;
		}
		return 1+ getElementsCount(btree.getLeft()) + getElementsCount(btree.getRight());
	}
}
