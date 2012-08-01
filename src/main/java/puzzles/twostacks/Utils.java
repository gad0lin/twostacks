package puzzles.twostacks;

public class Utils {

	public static <T extends Comparable<? super T>> T getMax(T left, T right) {
		if (left.compareTo(right) >= 0) {
			return left;
		} else {
			return right;
		}
	}

	@SafeVarargs
	public static <T extends Comparable<? super T>> T getAllMax(T... elements) {
		T max = null;
		if (elements.length > 0) {
			{
				max = elements[0];
				for (int i = 1; i < elements.length; i++) {
					max = getMax(max, elements[i]);
				}
			}
		}
		return max;
	}

	@SafeVarargs
	public static <T extends Comparable<? super T>> int indexOf(T elem,
			T... elements) {
		for (int i = 0; i < elements.length; i++) {
			if (elem.compareTo(elements[i]) == 0) {
				return i;
			}
		}
		return -1;
	}

	public static int[] getArrayWithConecutiveNumbers(int first, int last) {
		int[] arr = new int[last + 1];
		for (int k = 0; k < arr.length; k++) {
			arr[k] = first + k;
		}
		return arr;
	}

}
