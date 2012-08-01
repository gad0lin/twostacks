package puzzles.twostacks;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class GeneratePermutationsTest {
	@Test
	public void shouldFindOnePermutationForOneElement() {
		java.util.List<Integer[]> list = getPermutations(1);
		assertTrue(list.size() == 1);
		assertTrue(Arrays.equals(list.get(0), new Integer[] { 0 }));
	}

	@Test
	public void shouldFind2PermutationForTwoElements() {
		java.util.List<Integer[]> list = getPermutations(2);
		assertTrue(list.size() == 2);
		assertTrue(Arrays.equals(list.get(0), new Integer[] { 0, 1 }));
		assertTrue(Arrays.equals(list.get(1), new Integer[] { 1, 0 }));
	}

	@Test
	public void shouldFind6PermutationsFor3Element() {
		java.util.List<Integer[]> list = getPermutations(3);
		assertTrue(list.size() == 6);
		assertTrue(Arrays.equals(list.get(0), new Integer[] { 0, 1, 2 }));
		assertTrue(Arrays.equals(list.get(1), new Integer[] { 0, 2, 1 }));
		assertTrue(Arrays.equals(list.get(2), new Integer[] { 1, 0, 2 }));
		assertTrue(Arrays.equals(list.get(3), new Integer[] { 1, 2, 0 }));
		assertTrue(Arrays.equals(list.get(4), new Integer[] { 2, 0, 1 }));
		assertTrue(Arrays.equals(list.get(5), new Integer[] { 2, 1, 0 }));
	}

	java.util.List<Integer[]> getPermutations(int n) {
		GeneratePermutations gp = new GeneratePermutations(n);
		java.util.List<Integer[]> list = gp.getPermutations();
		return list;
	}

}
