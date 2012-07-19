package puzzles.twostacks;

import java.util.Set;

public class QueenProblem {

	public static void main(String[] args) {
		Integer z = 0;
		z++;
		System.out.println(z);
		for (int i = 0; i < 10; i++)
			System.out.println(new QueenProblem().calculate(i));
	}

	public int calculate(int size) {
		return calculate(new int[size], 0);

	}

	int calculate(int columns[], int column) {
		int res = 0;
		if (column == columns.length) {
			return 1;
		}
		for (int i = 0; i < columns.length; i++) {
			columns[column] = i;
			if (doesnotCollide(columns, column)) {
				res += calculate(columns, column + 1);
			}
		}
		return res;
	}

	private boolean doesnotCollide(int[] columns, int column) {
		for (int i = 0; i < column; i++) {
			if (collide(columns, column, i)) {
				return false;
			}
		}
		return true;
	}

	private boolean collide(int[] columns, int column, int i) {
		return columns[column] == columns[i] || onDiagonal(columns, i, column);
	}

	private boolean onDiagonal(int[] columns, int i, int column) {
		return columns[i] + (column - i) == columns[column]
				|| columns[i] - (column - i) == columns[column];
	}

	private void placeZeros(int[] columns, int column) {
		for (int i = column; i < columns.length; i++) {
			columns[column] = 0;
		}
	}

}
