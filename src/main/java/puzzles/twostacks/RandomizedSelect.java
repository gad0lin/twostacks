package puzzles.twostacks;

public class RandomizedSelect implements Selector{

	private static final int NOT_FOUND = -1;
	private int[] array;

	public RandomizedSelect(int[] array) {
		this.array = array;
	}

	public int select(int ithElement) {
		if (ithElement > array.length) {
			return NOT_FOUND;
		}
		if (ithElement < 0) {
			return NOT_FOUND;
		}
		return randomizeSelect(array.clone(), 0, array.length - 1, ithElement);
	}

	private int randomizeSelect(int[] array, int leftBound, int rightBound,
			int ithElement) {
		if (leftBound == rightBound) {
			return array[leftBound];
		}
		int q = new Partitioner(array, leftBound, rightBound).randPartition();
		int k = q - leftBound;
		if (ithElement <= k) {
			return randomizeSelect(array, leftBound, q, ithElement);
		} else {
			return randomizeSelect(array, q + 1, rightBound, ithElement - k - 1);
		}
	}

}
