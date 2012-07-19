package puzzles.twostacks;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class InOrderPrintTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	InOrderPrint printer = new InOrderPrint();
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@Test
	public void testNull() {
		printer.print(null);
		assertTrue(outEquals(""));
	}
	
	@Test
	public void test1() {
		printer.print(new BTree(3));
		assertTrue(outEquals("()3()"));
	}
	
	@Test
	public void test2() {
		printer.print(new BTree(new BTree(2), null, 3));
		assertTrue(outEquals("(()2())3()"));
	}
	
	public void test2a() {
		printer.print(new BTree(null,new BTree(4), 3));
		assertTrue(outEquals("()3(()4())"));
	}
	
	boolean outEquals(String what) {
		String out = outContent.toString();
		return out.equals(what);
	}

}
