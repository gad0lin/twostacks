package puzzles.twostacks;

import java.util.Stack;

public class GraphPrint implements PrintMe {

	Stack<String> indents = new Stack<String>();
	String indent = " ";
	public void print(BTree bTree) {
		if(bTree == null) {
			return;
		} else {
			printIndent();
			System.out.println(bTree.getValue());
			pushIndent();
			print(bTree.getLeft());
			print(bTree.getRight());
			popIndent();
		}
	}
	
	private void printIndent() {
		for (String s : indents) {
			System.out.print(s);
		}
	}
	
	private void popIndent() {
		indents.pop();
	}
	
	private void pushIndent() {
		indents.push(indent);
	}

	
	
}
