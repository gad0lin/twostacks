package puzzles.twostacks;
import static puzzles.twostacks.Utils.getAllMax;


/**
 * Maximum subarray problem.
 * @author krzysztofbarczynski
 *
 */
public class MaxSubarray {

	Solution getMaxSubArray(int[] arr) {
		return getMaxSubArray(arr, new Range(0, arr.length - 1));
	}

	private Solution getMaxSubArray(int[] arr, Range range) {

		if (range.getSize() == 1) {
			return new Solution(range, arr[range.getLeft()]);
		}

		Solution maxLeft = getMaxSubArray(arr, range.getLeftRange());
		Solution maxRight = getMaxSubArray(arr, range.getRightRange());
		Solution maxMidle = getMidleMax(arr, range);

		return getAllMax(maxLeft, maxRight, maxMidle);
	}

	private Solution getMidleMax(int[] arr, Range range) {
		int left = range.getLeft();
		int right = range.getRight();
		int mid = range.getMid();

		int maxLeftSubSum = arr[mid];
		int maxLeftSubSumStart = mid;
		int sum = maxLeftSubSum;
		for (int i = mid - 1; i >= left; i--) {
			sum += arr[i];
			if (sum > maxLeftSubSum) {
				maxLeftSubSum = sum;
				maxLeftSubSumStart = i;
			}
		}

		int maxRightSubSum = arr[mid + 1];
		int maxRightSubSumEnd = mid + 1;
		sum = maxRightSubSum;
		for (int i = mid + 2; i <= right; i++) {
			sum += arr[i];
			if (sum > maxRightSubSum) {
				maxRightSubSum = sum;
				maxRightSubSumEnd = i;
			}
		}

		return new Solution(new Range(maxLeftSubSumStart, maxRightSubSumEnd),
				maxRightSubSum + maxLeftSubSum);
	}

	public static class Solution implements Comparable<Solution> {
		int sum;
		Range range;

		public Solution(Range r, int sum) {
			this.sum = sum;
			this.range = r;
		}

		@Override
		public int compareTo(Solution o) {
			return Integer.compare(sum, o.sum);
		}
		@Override
		public String toString() {
			return "{" + sum + " - " + range;
		}
	}

	class Range {

		private int left, right;

		public Range(int left, int right) {
			super();
			this.left = left;
			this.right = right;
		}

		public int getLeft() {
			return left;
		}

		public int getRight() {
			return right;
		}

		int getMid() {
			return left + (right - left) / 2;
		}

		Range getLeftRange() {
			return new Range(left, getMid());
		}

		Range getRightRange() {
			return new Range(getMid() + 1, right);
		}

		private int getSize() {
			return right - left + 1;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[" + left + "," + right + "]";
		}
	}
}
