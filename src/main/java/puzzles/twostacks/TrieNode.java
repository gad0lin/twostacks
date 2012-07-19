package puzzles.twostacks;

import java.util.HashMap;
import java.util.Map.Entry;

public class TrieNode {
	private HashMap<Character, TrieNode> childrens = new HashMap<Character, TrieNode>();

	private static TrieNode LEAF = new TrieNode();

	public TrieNode() {
	}

	public boolean contains(String word) {
		if (word.equals("")) return true;
		return contain(childrens, word.toCharArray(), 0);
	}
	private boolean contain(HashMap<Character, TrieNode> childrens2, char[] word,
			int index) {
		if (childrens2 == null) {
			return false;
		} else if (word.length == index) {
			return childrens2.get("") != null;
		}
		TrieNode matchingNode = childrens2.get(word[index]);
		if (matchingNode == null) {
			return false;
		} else {
			contain(matchingNode.childrens, word, index++);
		}
		return false;
	}

	public void addWord(String word) {
	
		addWord(this.childrens, word.toCharArray(), 0);
	}

	public void addWord(HashMap<Character, TrieNode> childrens2, char[] word,
			int index) {
		if (index == word.length) {
			if (!childrens2.containsKey(null)) {
				childrens2.put(null, null);
				return;
			}
		}
		TrieNode match = childrens2.get(word[index]);
		if (match == null) {
			match = new TrieNode();
			childrens2.put(word[index], match);
		}
		addWord(match.childrens, word, index+1);
	}
	
	public void print() {
		print("", this);
	}
	public void print(String prefix, TrieNode node) {
		if (node == null){
			System.out.println(prefix);
		}
		else {
			for (Entry<Character, TrieNode> node2 : node.childrens.entrySet()){
				if(node2.getKey() == null) {
					System.out.println(prefix);
				} else
				{
					print(prefix + node2.getKey(), node2.getValue());
				}
			}
			
		}
	}

}
