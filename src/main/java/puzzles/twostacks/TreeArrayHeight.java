package puzzles.twostacks;

public class TreeArrayHeight {

	int getAndSetHeight(int[] array, int index) {

		if (array[index] == -1) {
			return 1;
		}
		if (array[index] >= 0) {
			array[index] = -(getAndSetHeight(array, array[index]) + 1);
		}
		return -array[index];
	}

	public void getMaxHeight(int[] array) {
		for (int i = 0; i < array.length; i++) {
			getAndSetHeight(array, i);
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			min = Math.min(min, array[i]);
		}
		System.out.println(-min-1);
	}
	
	public static void main(String[] args) {
		new TreeArrayHeight().getMaxHeight(new int[]{-1,0,1,2,3,4});
	}
}
