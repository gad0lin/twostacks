package puzzles.twostacks;

import org.junit.Test;

public class NaiveMatrixArithmeticTest {

	
	@Test
	public void testMul() {
		NaiveMatrixArithmetic nma = new NaiveMatrixArithmetic();
		int[][] in = new int[][] {{1,0},{0,1}};
		in.equals(nma.multiply(new Matrix(in), new Matrix(in)));
		
		
	}

}
