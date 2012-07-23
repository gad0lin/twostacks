package puzzles.twostacks;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

public class MergeSortTest {

	MergeSort mergeSort = new MergeSort();

	@Test
	public void shouldSortOneElement() {
		int[] arr = new int[] { 1 };
		mergeSort.sort(arr);
		assert (arr[0] == 1);
	}

	@Test
	public void shouldSortTwoElements() {
		int[] arr = new int[] { 1, 2 };
		mergeSort.sort(arr);
		assert (arr[0] == 1);
		assert (arr[1] == 2);
		arr = new int[] { 2, 1 };
		mergeSort.sort(arr);
		assert (arr[0] == 1);
		assert (arr[1] == 2);

		arr = new int[] { 1, 1 };
		mergeSort.sort(arr);
		assert (arr[0] == 1);
		assert (arr[1] == 1);
	}

	@Test
	public void shouldSortThreeElement() {
		int[] sortedArray = new int[] { 0, 1, 2 };
		GeneratePermutations gp = new GeneratePermutations(3);
		for (int i = 0; i < gp.getPermutations().size(); i++) {
			int[] perm = ArrayUtils.toPrimitive(gp.getPermutations().get(i));
			mergeSort.sort(perm);
			assertTrue(Arrays.equals(sortedArray, perm));
		}
	}
}
