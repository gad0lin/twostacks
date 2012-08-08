package puzzles.twostacks.matrix;

class MatrixSplit {
	ISquarMatrix[][] split = new ISquarMatrix[2][2];

	public MatrixSplit(ISquarMatrix a) {
		int subSize = a.getSize() / 2;
		Span span = new Span(subSize);
		setLeftTop(Utils.getSubMatrix(a, new Position(0, 0), span));
		setRightTop(Utils.getSubMatrix(a, new Position(0, subSize), span));
		setLeftBottom(Utils.getSubMatrix(a, new Position(subSize, 0), span));
		setRightBottom(Utils.getSubMatrix(a, new Position(subSize, subSize),
				span));
	}

	public MatrixSplit() {
	}

	ISquarMatrix leftBottom() {
		return split[1][0];
	}

	ISquarMatrix leftTop() {
		return split[0][0];
	}

	ISquarMatrix rightTop() {
		return split[0][1];
	}

	ISquarMatrix rightBottom() {
		return split[1][1];
	}

	MatrixSplit setLeftTop(ISquarMatrix m) {
		split[0][0] = m;
		return this;
	}

	MatrixSplit setLeftBottom(ISquarMatrix m) {
		split[1][0] = m;
		return this;
	}

	MatrixSplit setRightBottom(ISquarMatrix m) {
		split[1][1] = m;
		return this;
	}

	MatrixSplit setRightTop(ISquarMatrix m) {
		split[0][1] = m;
		return this;
	}

	ISquarMatrix create() {
		int size = getSize();
		ISquarMatrix m = new SquareMatrix(size * 2);
		Span span = new Span(size);
		Utils.copyMatrix(new RegionMatrix(leftTop()), new RegionMatrix(m,
				new Position(0, 0), span));
		Utils.copyMatrix(new RegionMatrix(rightTop()), new RegionMatrix(m,
				new Position(0, size), span));
		Utils.copyMatrix(new RegionMatrix(rightBottom()), new RegionMatrix(m,
				new Position(size, size), span));
		Utils.copyMatrix(new RegionMatrix(leftBottom()), new RegionMatrix(m,
				new Position(size, 0), span));
		return m;
	}

	private int getSize() {
		return split[0][0].getColumnCount();
	}

}