package puzzles.twostacks;

public class List {

	private Node head;

	public List(String number) {
		for (int i = number.length() - 1; i >= 0; i--) {
			char digit = number.charAt(i);
			insert(Integer.valueOf(digit)-48);
		}
	}
	public List(Integer number) {
		this(number.toString());
	}
	
	public Integer pull() {
		if (head == null) {
			return null;
		}
		Node retValue = head;
		head = head.next;
		return retValue.value;
	}
	
	public void insert(Integer value){
		head = new Node(value, head);
	}
	
	class Node {
		Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
		int value;
		Node next;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		Node traversal = head;
		while (traversal != null) {
			builder.append(traversal.value);
			traversal = traversal.next;
		}
		return builder.toString();
	}

}
