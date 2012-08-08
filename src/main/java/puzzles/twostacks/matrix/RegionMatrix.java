package puzzles.twostacks.matrix;

public class RegionMatrix implements IMatrix, ISquarMatrix {
	private Position start;
	private Span span;
	private IMatrix matrix;

	public RegionMatrix(IMatrix m, Position start, Span end) {
		this.matrix = m;
		this.start = start;
		this.span = end;
	}

	public RegionMatrix(IMatrix m) {
		this(m, new Position(0, 0), new Span(m.getRowCount(),
				m.getColumnCount()));
	}

	public int getValue(Position p) {
		if (isValid(p)) {
			return matrix.getValue(getShiftedPosition(p));
		}
		throw new IllegalArgumentException("Invalid getValue Passed (" + p.toString() + ") ");
	}

	private boolean isValid(Position p) {
		return isValidColumn(p.getColumn()) && isValidRow(p.getRow());
	}

	private boolean isValidColumn(int column) {
		return (span.getColumnSpan() > column && column >= 0);
	}

	private boolean isValidRow(int row) {
		return (span.getRowSpan() > row && row >= 0);
	}

	public void setValue(Position p, int value) {
		matrix.setValue(getShiftedPosition(p), value);
	}

	private Position getShiftedPosition(Position p) {
		return new Position(getShiftedRow(p.getRow()),
				getShiftedColumn(p.getColumn()));
	}

	private int getShiftedRow(int row) {
		return start.getRow() + row;
	}

	private int getShiftedColumn(int column) {
		return start.getColumn() + column;
	}

	@Override
	public void setValues(int[][] values) {
		matrix.setValues(values);
	}

	@Override
	public int getRowCount() {
		return span.getRowSpan();
	}

	@Override
	public int getColumnCount() {
		return span.getColumnSpan();
	}

	@Override
	public int getSize() {
		return span.getColumnSpan();
	}

	@Override
	public String toString() {
		return Utils.toString(this);
	}

}
