package puzzles.twostacks.graph;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class TSortTest {

	@Spy
	Node node = new Node(1);

	TSort tsort = new TSort();

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldCreateSortEmptySet() {
		TSort tsort = new TSort();
		java.util.List<Node> list = tsort.tsort(new HashSet<Node>());
		assertTrue(list.size() == 0);
		java.util.List<Node> list2 = tsort.tsort(new HashSet<Node>());
		assertTrue(list.size() == 0);
		assertTrue(list2.size() == 0);
	}

	@Test
	public void shouldSortOneElement() {

		// Given
		Node n = new Node(1);
		Set<Node> set = new HashSet<Node>();
		set.add(n);

		// when
		java.util.List<Node> list = tsort.tsort(new HashSet<Node>(set));
		// when
		java.util.List<Node> list2 = tsort.tsortrec(new HashSet<Node>(set));

		// then
		assertTrue(list.size() == 1);
		assertTrue(list.get(0).equals(n));
		assertTrue(list2.size() == 1);
		assertTrue(list2.get(0).equals(n));
	}

	@Test
	public void shouldSortOneElementWithSelfEdge() {

		// Given
		Node n = new Node(1);
		Set<Node> set = new HashSet<Node>();
		set.add(n);
		n.addEdge(n);

		// when
		java.util.List<Node> list = tsort.tsort(set);

		// then
		assertTrue(list.size() == 1);
		assertTrue(list.get(0).equals(n));
	}

	@Test
	public void shouldSortTwoElements() {

		// Given
		Node n = new Node(1);
		Node n1 = new Node(2);
		n.addEdge(n1);
		Set<Node> set = new HashSet<Node>();
		set.add(n);
		set.add(n1);

		// when
		java.util.List<Node> list = tsort.tsort(new HashSet<Node>(set));

		java.util.List<Node> list2 = tsort.tsortrec(new HashSet<Node>(set));

		// then
		assertTrue(list.size() == 2);
		assertTrue(list.get(0).equals(n));
		assertTrue(list.get(1).equals(n1));
		// then
		assertTrue(list2.size() == 2);
		assertTrue(list2.get(0).equals(n));
		assertTrue(list2.get(1).equals(n1));
	}

}
