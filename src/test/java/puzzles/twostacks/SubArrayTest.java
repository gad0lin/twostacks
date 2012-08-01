package puzzles.twostacks;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import static puzzles.twostacks.Utils.getArrayWithConecutiveNumbers;

public class SubArrayTest {

	@Test
	public void testSubArrayIntArrayIntInt() {
		SubArray sa = new SubArray(new int[] { 1, 2, 3 }, 1, 2);
		int median;
		median = sa.getMedian();
		assertTrue(median == 2 || median == 3);
		sa = new SubArray(new int[] { 1, 2 }, 1, 1);
		median = sa.getMedian();
		assertTrue(median == 2);
		sa = new SubArray(new int[] { 1, 2 }, 0, 0);
		median = sa.getMedian();
		assertTrue(median == 1);
		sa = new SubArray(new int[] { 1, 2 }, 0, 1);
		median = sa.getMedian();
		assertTrue(median == 1 || median == 2);
		sa = new SubArray(new int[] { 1, 2, 3 }, 2, 2);
		median = sa.getMedian();
		assertTrue(median == 3);
		sa = new SubArray(new int[] { 1, 2, 3 }, 0, 0);
		median = sa.getMedian();
		assertTrue(median == 1);
		sa = new SubArray(new int[] { 1, 2, 3 }, 1, 1);
		median = sa.getMedian();
		assertTrue(median == 2);
	}

	@Test
	public void testSubArrayIntArray() {
		SubArray sa = new SubArray(new int[] { 3 });
		assertTrue(sa.getMedian() == 3);
		sa = new SubArray(new int[] { 1, 2 });
		assertTrue(sa.getMedian() == 1 || sa.getMedian() == 2);
		sa = new SubArray(new int[] { 1, 2, 3 });
		assertTrue(sa.getMedian() == 2);
		sa = new SubArray(new int[] { 1, 2, 3, 4 });
		assertTrue(sa.getMedian() == 2 || sa.getMedian() == 3);
		sa = new SubArray(new int[] { 1, 2, 3, 4, 5 });
		assertTrue(sa.getMedian() == 2 || sa.getMedian() == 3);
	}

	@Test
	public void shouldSplitWhenNotMoreThen5elements() {
		
		new Splitter(1).verifySplit();
		new Splitter(2).verifySplit();
		new Splitter(3).verifySplit();
		new Splitter(4).verifySplit();
		new Splitter(5).verifySplit();
	}

	@Test
	public void testGetShrinkedStartingAt() {
		int[] arr = getArrayWithConecutiveNumbers(1, 10);
		SubArray sa = new SubArray(arr);
		compare(arr, 0, sa.getShrinkedStartingAt(0));
		compare(arr, 9, sa.getShrinkedStartingAt(9));

	}

	@Test
	public void testGetShrinkedEndingAt() {
		int[] arr = getArrayWithConecutiveNumbers(1, 10);
		SubArray sa = new SubArray(arr);
		compare(new int[] { 1, 2 }, 0, sa.getShrinkedEndingAt(1));
		compare(new int[] { 1, 2, 3 }, 0, sa.getShrinkedEndingAt(2));
		compare(arr, 0, sa.getShrinkedEndingAt(9));
	}

	class Splitter {
		int[] arr;

		public Splitter(int elNumber) {
			arr = getArrayWithConecutiveNumbers(1, elNumber);
		}

		public void verifySplit() {
			SubArray sa = new SubArray(arr);
			java.util.List<SubArray> split = sa.getSplit();
			assertTrue(split.size() == (arr.length + 4) / 5);
			for (int i = 0; i < split.size(); i++) {
				compare(arr, i * 5, split.get(i));
			}
		}

	}

	private void compare(int[] arr, int startIndex, SubArray sa) {
		int index = startIndex;
		Iterator<Integer> iterator = sa.iterator();
		while (iterator.hasNext()) {
			assertTrue(arr[index++] == iterator.next());
		}
	}

}
