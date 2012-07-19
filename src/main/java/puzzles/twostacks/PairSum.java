package puzzles.twostacks;

import java.util.HashMap;
import java.util.Map;

public class PairSum {
	public void printPairs(int[] arr, int target) {
		Map<Integer, Integer> elementCount = new HashMap<Integer, Integer>();
		for (int el : arr) {
			increaseElementCount(el,elementCount);
		}

		for (int el : arr) {
			Integer count = elementCount.get(target - el);
			if (count != null && count > 0) {
				int matchingPairs = count;
				if (isHalf(el, target)) {
					matchingPairs--;
				}
				for (int i = 0; i < matchingPairs; i++) {
					System.out.println("(" + el + "," + (target - el)+")");
				}
				int numberOfEl = elementCount.get(el);
				elementCount.put(el, --numberOfEl);
			}
		}
	}

	private void increaseElementCount(int el, Map<Integer,Integer> map) {
		Integer count = map.get(el);
		if (count == null) {
			count = 0;
		}
		map.put(el, ++count);
		
	}

	private boolean isHalf(int el, int target) {
		return (target == 2 * el);
	}
	public static void main(String[] args) {
		new PairSum().printPairs(new int[]{1, 2, 3, 4, 5,3}, 6);
	}
}
