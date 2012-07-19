package puzzles.twostacks;

public class SecondMax {
	int[] arr = {Integer.MIN_VALUE, Integer.MIN_VALUE};
	public Integer getSecondMax(BTree tree) {
		if(tree == null){
			return null;
		}
		updateMax(tree.getValue());
		return null;
	}
	private void updateMax(Integer value) {
		
	}
	
	
}
