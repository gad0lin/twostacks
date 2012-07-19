package puzzles.twostacks;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FindDiameterTest {

	FindDiameter findDiameter;
	
	@Before
	public void init() {
		findDiameter = new FindDiameter();
	}
	
	@Test
	public void shouldReturn0forLeaf() {
		assertTrue(-1 == findDiameter.findDemeter(null));
	}
	
	@Test
	public void shouldReturn1forSingleNode() {
		BTree btree = new BTree();
		assertTrue(0 == findDiameter.findDemeter(btree));
	}
	
	@Test
	public void shouldReturn2for2Nodes() {
		BTree btree = new BTree(new BTree(),null);
		System.out.println(findDiameter.findDemeter(btree));
		assertTrue(1 == findDiameter.findDemeter(btree));
	}
	
	@Test
	public void shouldReturn3for2Nodes() {
		BTree btree = new BTree(new BTree(new BTree(),null),null);
		System.out.println(findDiameter.findDemeter(btree));
		assertTrue(2 == findDiameter.findDemeter(btree));
	}
	
	@Test
	public void shouldReturn3for2NodesBalanced() {
		BTree btree = new BTree(new BTree(),new BTree());
		System.out.println(findDiameter.findDemeter(btree));
		assertTrue(2 == findDiameter.findDemeter(btree));
	}
	
	@Test
	public void shouldReturn4when5NodesWithDiameterInChild() {
		BTree btree = new BTree(new BTree(new BTree(new BTree(), null),new BTree(new BTree(),null)),null);
		System.out.println(findDiameter.findDemeter(btree));
		assertTrue(4 == findDiameter.findDemeter(btree));
	}
	
	
	

}
