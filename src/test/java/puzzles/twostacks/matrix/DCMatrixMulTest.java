package puzzles.twostacks.matrix;


public class DCMatrixMulTest extends MatrixMulTest {


	public DCMatrixMulTest(int size) {
		super(size);
	}

	@Override
	protected MatrixArithmetic createMulProvider() {
		return new DCMatrixMul();
	}

}
