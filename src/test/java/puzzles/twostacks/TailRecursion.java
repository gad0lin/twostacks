package puzzles.twostacks;

public class TailRecursion {
	
	public static void main(String[] args) {
		new TailRecursion().tail(10);
	}
	void tail(int n) {
		if(n < 0) {
			return;
		} else {
			tail (--n);
		}
	}
}
