package puzzles.twostacks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class SubArray {
	int start;
	int end;
	int[] arr;

	public SubArray(int[] arr, int start, int end) {
		this.start = start;
		this.end = end;
		this.arr = arr;
	}

	public SubArray(int[] arr2) {
		this(arr2, 0, arr2.length - 1);
	}

	private void sort() {
		int[] tmpArr = Arrays.copyOfRange(arr, start, end);
		Arrays.sort(tmpArr);
		for (int i = 0; i < tmpArr.length; i++) {
			arr[start + i] = tmpArr[i];
		}
	}

	public int getMedian() {
		sort();
		return arr[start + (end - start) / 2];
	}

	public java.util.List<SubArray> getSplit() {
		java.util.List<SubArray> split = new LinkedList<>();
		if(size()<=5){
			split.add(this);
			return split;
		}
		for (int i = 0; i <= end / 5; i++) {
			int newEnd = (i*5 + 5) > end ? end : i*5 + 4;
			split.add(new SubArray(arr, i * 5, newEnd));
		}
		return split;
	}

	public SubArray getShrinkedStartingAt(int position) {
		return new SubArray(arr, position, end);
	}

	public SubArray getShrinkedEndingAt(int position) {
		return new SubArray(arr, start, position);
	}

	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			int position = start;

			@Override
			public boolean hasNext() {
				return position < end;
			}

			@Override
			public Integer next() {
				return arr[position++];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public String toString() {
		return start + ":" + end + ":" + Arrays.toString(arr);
	}

	public int getStart() {
		return start;
	}

	public int indexOf(int medianOfmedians) {
		return java.util.Arrays.asList(arr).indexOf(medianOfmedians);
	}

	public int size() {
		return end - start + 1;
	}
}