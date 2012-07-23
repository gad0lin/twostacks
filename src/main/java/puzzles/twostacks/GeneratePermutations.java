package puzzles.twostacks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GeneratePermutations {

	int size;
	java.util.List<Integer[]> permutations;

	public GeneratePermutations(int size) {
		this.size = size;
	}

	private LinkedHashSet<Integer> orderedSet(int n) {
		LinkedHashSet<Integer> set = new LinkedHashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(i);
		}
		return set;
	}

	private void generatePermuations(java.util.List<Integer> ordered,
			Set<Integer> unused) {
		if (unused.size() == 0) {
			pushPermutation(ordered);
		} else {
			for (Integer i : unused) {
				Set<Integer> newUnused = new HashSet<>(unused);
				List<Integer> newOrdered = new ArrayList<>(ordered);
				newOrdered.add(i);
				newUnused.remove(i);
				generatePermuations(newOrdered, newUnused);
			}
		}

	}

	private void pushPermutation(List<Integer> ordered) {
		Integer[] arr = ordered.toArray(new Integer[0]);
		permutations.add(arr);

	}

	private void generatePermutations(int size) {
		Set<Integer> orderedSet = orderedSet(size);
		generatePermuations(new ArrayList<Integer>(), orderedSet);
	}

	public java.util.List<Integer[]> getPermutations() {
		if (permutations == null) {
			permutations = new ArrayList<>();
			generatePermutations(size);
		}
		return permutations;
	}
}
