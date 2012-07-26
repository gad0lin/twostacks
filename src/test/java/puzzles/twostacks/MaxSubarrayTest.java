package puzzles.twostacks;

import static org.junit.Assert.*;

import org.junit.Test;

import puzzles.twostacks.MaxSubarray;
import puzzles.twostacks.MaxSubarray.Solution;

public class MaxSubarrayTest {
	MaxSubarray ms = new MaxSubarray();

	@Test
	public void shouldSolveWhenOneElement() {
		Solution solution = ms.getMaxSubArray(new int[] { 1 });
		assertTrue(solution.sum == 1);
		solution = ms.getMaxSubArrayLin(new Integer[] { 1 });
		assertTrue(solution.sum == 1);
	}

	@Test
	public void shouldSolveWhenTwoElements() {
		Solution solution = ms.getMaxSubArray(new int[] { 1, 2 });
		assertTrue(solution.sum == 3);
		solution = ms.getMaxSubArrayLin(new Integer[] { 1, 2 });
		assertTrue(solution.sum == 3);
	}

	@Test
	public void shouldSolveWhenThreeElements() {
		Solution solution = ms.getMaxSubArray(new int[] { 1, 2, 3 });
		assertTrue(solution.sum == 6);
		ms.getMaxSubArrayLin(new Integer[] { 1, 2, 3 });
		assertTrue(solution.sum == 6);
	}

	@Test
	public void shouldSolveWhenThreeElementsWithNegative() {
		Solution solution = ms.getMaxSubArray(new int[] { 1, -2, 3 });
		assertTrue(solution.sum == 3);
		solution = ms.getMaxSubArrayLin(new Integer[] { 1, -2, 3 });
		assertTrue(solution.sum == 3);
	}

	@Test
	public void shouldSolveWhenFourElementsWithNegative() {
		Solution solution = ms.getMaxSubArray(new int[] { 1, -2, 3, 4 });
		assertTrue(solution.sum == 7);
		solution = ms.getMaxSubArrayLin(new Integer[] { 1, -2, 3, 4 });
		assertTrue(solution.sum == 7);
	}
}
