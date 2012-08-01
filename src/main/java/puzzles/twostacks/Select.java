package puzzles.twostacks;

import java.util.Iterator;

/**
 * Selection of ith element in linear time.
 * 
 * @author krzysztofbarczynski
 * 
 */
public class Select implements Selector {
	private int[] arr;

	public Select(int[] arr) {
		this.arr = arr;
	}

	public int select(int ithelement) {
		SubArray sa = new SubArray(arr.clone());
		return select(sa, ithelement);

	}

	private int select(SubArray subArray, int ithelement) {
		int medianOfmedians = getMedianOfMedians(subArray);
		int x = partition(subArray, medianOfmedians);
		int k = x - subArray.getStart();
		if (ithelement == k) {
			return subArray.arr[x];
		} else if (k < ithelement) {
			return select(subArray.getShrinkedStartingAt(x + 1), ithelement - k
					- 1);
		} else {
			return select(subArray.getShrinkedEndingAt(x - 1), ithelement);
		}
	}

	private int partition(SubArray subArray, int medianOfmedians) {
		return new Partitioner(subArray.arr, subArray.start, subArray.end)
				.partition(medianOfmedians);
	}

	private int getMedianOfMedians(SubArray sa) {
		int[] medians = getMediansArray(sa.getSplit());
		if (medians.length == 1) {
			return medians[0];
		}
		return getMedianOfMedians(new SubArray(medians));
	}

	private int[] getMediansArray(java.util.List<SubArray> split) {
		int[] medians = new int[split.size()];
		Iterator<SubArray> iterator = split.iterator();
		for (int i = 0; i < medians.length; i++) {
			medians[i] = iterator.next().getMedian();
		}
		return medians;
	}

}
