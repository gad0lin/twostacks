package puzzles.twostacks.matrix;

class Position {
	int row;
	int column;

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}

	public Position() {
		this(0, 0);
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {

		return "row: " + row + ",column: " + column;
	}

	public Position setRow(int row) {
		this.row = row;
		return this;
	}
	
	public Position setColumn(int column) {
		this.column = column;
		return this;
	}
}