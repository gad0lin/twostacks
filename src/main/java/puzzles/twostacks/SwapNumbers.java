package puzzles.twostacks;

/**
 * Swap two variables using XOR.
 * @author krzysztofbarczynski
 *
 */
public class SwapNumbers {

		private int first;
		private int second;

		public SwapNumbers(int first, int second) {
			this.first = first;
			this.second = second;
		}
		
		public void invert() {
			first = first ^ second;
			second = first ^ second;
			first = first ^ second;
		}

		public int getFirst() {
			return first;
		}

		public int getSecond() {
			return second;
		}

}
