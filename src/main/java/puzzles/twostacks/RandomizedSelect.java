package puzzles.twostacks;

import java.util.Random;

public class RandomizedSelect {

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
		int q = randomizedPartition(array, leftBound, rightBound);
		int k = q - leftBound;
		if (ithElement <= k) {
			return randomizeSelect(array, leftBound, q, ithElement);
		} else {
			return randomizeSelect(array, q + 1, rightBound, k);
		}
	}

	private int randomizedPartition(int[] array2, int leftBound, int rightBound) {
		int randomIndex = getRandomIndex(leftBound, rightBound);
		swapValues(array2, randomIndex, leftBound);
		int partitionIndex = partition(array2, leftBound, rightBound);
		return partitionIndex;
	}

	private int getRandomIndex(int leftBound, int rightBound) {
		return leftBound
				+ new Random(System.currentTimeMillis()).nextInt(rightBound
						- leftBound);
	}

	private void swapValues(int[] array2, int indexA, int indexB) {
		if (indexA == indexB) {
			return;
		}
		array2[indexA] = array2[indexA] ^ array2[indexB];
		array2[indexB] = array2[indexB] ^ array2[indexA];
		array2[indexA] = array2[indexB] ^ array2[indexA];
	}

	private int partition(int[] array2, int leftBound, int rightBound) {
		int val = array2[leftBound];
		int left = leftBound;
		int right = rightBound;

		while (true) {
			while ((array2[right] >= val && left != right)) {
				right--;
			}
			if (left < right) {
				swapValues(array2, left, right);
			}
			while (array2[left] <= val && left != right) {
				left++;
			}
			if (left < right) {
				swapValues(array2, left, right);
			} else {
				return left;
			}
		}
	}
}
