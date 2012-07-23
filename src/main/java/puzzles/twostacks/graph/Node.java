package puzzles.twostacks.graph;

import java.util.HashSet;
import java.util.Set;

public class Node {
	private int id;
	private Set<Edge> edges = new HashSet<>();

	public Node(int i) {
		this.id = i;
	}

	public int getId() {
		return id;
	}

	public void addEdge(Node n) {
		edges.add(new Edge(this, n));
	}

	public Set<Edge> getEdges() {
		return new HashSet<>(edges);
	}

	public void removeEdge(Node n) {
		edges.remove(new Edge(this, n));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Node) {
			Node node = (Node) obj;
			return node.id == id;
		}
		return super.equals(obj);
	}

}
