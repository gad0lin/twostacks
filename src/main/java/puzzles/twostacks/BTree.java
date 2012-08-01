package puzzles.twostacks;

public class BTree {
	private BTree left;
	private BTree right;
	private Integer value;
	
	private PrintMe printMe;
	public BTree(BTree left, BTree right) {
		this(left,right, null);
	}
	public BTree(BTree left, BTree right, Integer value) {
		this.left = left;
		this.right = right;
		this.value = value;
	}

	public BTree(Integer value) {
		this(null,null,value);
	}
	
	public BTree() {
		this(null,null,null);
	}

	public BTree getLeft() {
		return left;
	}

	public BTree getRight() {
		return right;
	}
	
	public Integer getValue() {
		return value;
	}
	
	
	public void print() {
		printMe.print(this);
	}
	
	public void setPrintMe(PrintMe printMe) {
		this.printMe = printMe;
	}
}
