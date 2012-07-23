package puzzles.twostacks;

public class MergeSort {

	public void sort(int[] arr) {
		sort(arr, 0, arr.length-1);
	}

	public void sort(int[] arr, int start, int end) {
		if (start == end) {
			return;
		}
		sort(arr, start, end / 2);
		sort(arr, end / 2 + 1, end);
		merge(arr, start, end / 2, end / 2 + 1, end);
	}

	private void merge(int[] arr, int leftStart, int leftEnd, int rightStart,
			int rightEnd) {
		int rightIndex = rightStart;
		int[] tmpArr = new int[rightEnd - leftStart +1];
		int tmpArrIndex = 0;
		int leftIndex = leftStart;
		for (; leftIndex <= leftEnd && rightIndex <= rightEnd; leftIndex++) {
			int leftValue = arr[leftIndex];
			int shift = 0;
			while (rightIndex + shift <= rightEnd && leftValue >= arr[rightIndex + shift] ) {
				shift++;
			}
			while (shift-- > 0) {
				tmpArr[tmpArrIndex++] = arr[rightIndex++];
			}
			tmpArr[tmpArrIndex++] = arr[leftIndex];
		}
		while (leftIndex <= leftEnd) {
			tmpArr[tmpArrIndex++] = arr[leftIndex++];
		}
		while (rightIndex <= rightEnd) {
			tmpArr[tmpArrIndex++] = arr[rightIndex++];
		}
		for (int i = leftStart; i <= rightEnd; i++) {
			arr[i] = tmpArr[i - leftStart];
		}
	}
}
