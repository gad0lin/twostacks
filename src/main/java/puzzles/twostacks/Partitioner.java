package puzzles.twostacks;

import java.util.Random;

public class Partitioner {

	private int[] arr;
	int leftBound;
	int rightBound;

	public Partitioner(int[] arr, int left, int right) {
		this.arr = arr;
		this.leftBound = left;
		this.rightBound = right;
	}

	public int partition() {
		int val = arr[leftBound];
		int left = leftBound;
		int right = rightBound;

		while (true) {
			while ((arr[right] >= val && left != right)) {
				right--;
			}
			if (left < right) {
				swapValues(left, right);
			}
			while (arr[left] <= val && left != right) {
				left++;
			}
			if (left < right) {
				swapValues(left, right);
			} else {
				return left;
			}
		}
	}

	public int randPartition() {
		int randomIndex = getRandomIndex(leftBound, rightBound);
		swapValues(randomIndex, leftBound);
		int partitionIndex = partition();
		return partitionIndex;
	}

	private int getRandomIndex(int leftBound, int rightBound) {
		return Rand.randInt(leftBound, rightBound);
	}

	private void swapValues(int indexA, int indexB) {
		if (indexA == indexB) {
			return;
		}
		arr[indexA] = arr[indexA] ^ arr[indexB];
		arr[indexB] = arr[indexB] ^ arr[indexA];
		arr[indexA] = arr[indexB] ^ arr[indexA];
	}
}
