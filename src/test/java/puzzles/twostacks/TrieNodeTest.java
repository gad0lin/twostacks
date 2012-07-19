package puzzles.twostacks;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrieNodeTest {

	
	TrieNode tn = new TrieNode();
	@Test
	public void test() {
		tn.addWord("abcd");
		tn.addWord("abc");
		tn.addWord("abcf");
		tn.addWord("fa");
		tn.addWord("zzz");
		tn.print();
	}

}
