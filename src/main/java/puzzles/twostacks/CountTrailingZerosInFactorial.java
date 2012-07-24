package puzzles.twostacks;

public class CountTrailingZerosInFactorial {

	public int getTrailingZerosCount(int n) {
		return count5s(n);
		
	}
	private int count5s(int n) {
		int divide = 5;
		int numberOf5 = 0;
		while (n / divide > 0) {
			numberOf5 += n / divide;
			divide *= 5;
		}
		return numberOf5;
	}
	
	
	
}
