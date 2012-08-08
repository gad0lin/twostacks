package puzzles.twostacks.matrix;


public class NaiveMatrixMulTest extends MatrixMulTest {

	public NaiveMatrixMulTest(int size) {
		super(size);
	}

	@Override
	protected NaiveMatrixArithmetic createMulProvider() {
		return new NaiveMatrixArithmetic();
	}

}
