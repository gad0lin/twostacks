package puzzles.twostacks;

public class QueueOnStacks {

	private Object[] in;
	private Object[] out;
	private int out_size;
	private int in_size;

	public QueueOnStacks(int size) {
		in = new Object[size];
		out = new Object[size];
	}

	public boolean insert(Object string) {
		if (in_size == in.length) {
			if (out_size == 0) {
				moveInToOut();
			} else {
				return false;
			}
		}
		in[in_size++] = string;
		return true;

	}

	public Object pull() {
		if (out_size == 0) {
			if (in_size > 0) {
				moveInToOut();
			} else {
				return null;
			}
		}
		return out[--out_size];

	}

	public void moveInToOut() {
		int movedNumber = in_size;
		for (int i = 0; i < movedNumber; i++) {
			out[out_size++] = in[--in_size];
		}
	}

}
