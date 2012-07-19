package puzzles.twostacks;

import static org.junit.Assert.*;

import org.junit.Test;

public class GraphPrintTest {

	GraphPrint printer = new GraphPrint();
	
	@Test
	public void test() {
		printer.print(new BTree(3));
	}
	@Test
	public void test2() {
		printer.print(new BTree(new BTree(3), null,4));
	}
	
	@Test
	public void test3() {
		printer.print(new BTree(new BTree(30), new BTree(50),40));
	}
	@Test
	public void test4() {
		printer.print(new BTree(new BTree(new BTree(25), new BTree(35),30), new BTree(new BTree(45), new BTree(55),50),40));
	}

}
