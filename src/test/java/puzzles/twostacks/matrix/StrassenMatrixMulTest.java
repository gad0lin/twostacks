package puzzles.twostacks.matrix;

public class StrassenMatrixMulTest extends MatrixMulTest {

	public StrassenMatrixMulTest(int size) {
		super(size);
	}

	@Override
	protected MatrixArithmetic createMulProvider() {
		return new StrassenAlgorithm();
	}

}
