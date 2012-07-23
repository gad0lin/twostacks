package puzzles.twostacks;

public class TestOrder {
	int size = getCount(1);
	int z = getCount(size);

	private int getCount(int i) {
		System.out.println("get count");
		return 1;
	}

	public TestOrder() {
		System.out.println("Contructor");
	}

	public static void main(String[] args) {
		new TestOrder();
	}

}
