package puzzles.twostacks.matrix;

public class Span {
	private int columnSpan;
	private int rowSpan;

	public Span(int columnWidth, int rowHeight) {
		this.columnSpan = columnWidth;
		this.rowSpan = rowHeight;
	}

	public Span(int size) {
		this.columnSpan = size;
		this.rowSpan = size;
	}

	public int getColumnSpan() {
		return columnSpan;
	}

	public int getRowSpan() {
		return rowSpan;
	}

}
