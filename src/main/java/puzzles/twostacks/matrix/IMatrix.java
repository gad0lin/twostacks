package puzzles.twostacks.matrix;

public interface IMatrix {

	public abstract int getValue(Position p);

	public abstract void setValues(int[][] values);
	
	public abstract void setValue(Position p, int value);

	public abstract int getRowCount();

	public abstract int getColumnCount();

}