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
}
