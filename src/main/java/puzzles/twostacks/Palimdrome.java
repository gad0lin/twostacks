package puzzles.twostacks;

public class Palimdrome {

	Node left = null;

	public boolean isPalindrom(String s) {
		List list = new List(s);
		left = list.tail;
		return isPalindrom(list.tail);
	}

	public boolean isPalindrom(Node right) {
		if (right == null) {
			return true;
		}

		boolean isPalimdrom = isPalindrom(right.next);
		if (!isPalimdrom) {
			return false;
		}

		if (left.value != right.value) {
			return false;
		}

		left = left.next;
		return true;
	}

	class List {
		Node tail;

		public List(String name) {
			for (char c : name.toCharArray()) {
				tail = new Node(c, tail);
			}
		}

	}

	class Node {
		Node(char value, Node next) {
			this.value = value;
			this.next = next;
		}

		char value;
		Node next;
	}

}
