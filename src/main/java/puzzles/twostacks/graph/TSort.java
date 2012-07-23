package puzzles.twostacks.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class TSort {

	public java.util.List<Node> tsort(Set<Node> set) {
		java.util.List<Node> sortedList = new LinkedList<>();
		Queue<Node> withoutIncommingEdges = getNodesWithoutIncommingEdges(set);

		while (withoutIncommingEdges.size() != 0) {
			Node n = withoutIncommingEdges.poll();
			sortedList.add(n);
			set.remove(n);
			withoutIncommingEdges = getNodesWithoutIncommingEdges(set);
		}
		return sortedList;
	}

	private LinkedList<Node> getNodesWithoutIncommingEdges(Set<Node> set) {
		Set<Node> result = new HashSet<>(set);
		for (Node n : set) {
			Set<Edge> outgoingEdges = n.getEdges();
			for (Edge e : outgoingEdges) {
				if (!e.getOrgin().equals(e.getTarget()))
					result.remove(e.getTarget());
			}
		}
		return new LinkedList<>(result);
	}

	public java.util.List<Node> tsortrec(Set<Node> set) {
		java.util.List<Node> sortedList = new LinkedList<>();

		LinkedList<Node> withoutOutgoing = getWithoutOutgoing(set);
		HashSet<Node> visited = new HashSet<>();
		for (Node n : withoutOutgoing) {
			visit(n, sortedList, visited, set);
		}
		return sortedList;
	}

	private java.util.List<Node> getNodesWithEdgeToNode(Node n, Set<Node> set) {
		Set<Node> result = new HashSet<>(set);
		for (Node node : set) {
			Set<Edge> outgoingEdges = node.getEdges();
			for (Edge e : outgoingEdges) {
				if (e.getTarget().equals(n)
						&& (!e.getOrgin().equals(e.getTarget())))
					result.remove(e.getTarget());
			}
		}
		return new LinkedList<>(result);

	}

	private void visit(Node n, java.util.List<Node> sortedList,
			Set<Node> visited, Set<Node> allNodes) {
		if (!visited.contains(n)) {
			visited.add(n);
			List<Node> pointing = getNodesWithEdgeToNode(n, allNodes);
			for (Node node : pointing) {
				visit(node, sortedList, visited, allNodes);
			}
			sortedList.add(n);
		}
	}

	private LinkedList<Node> getWithoutOutgoing(Set<Node> set) {
		Set<Node> result = new HashSet<>(set);
		for (Node n : set) {
			Set<Edge> outgoingEdges = n.getEdges();
			if (outgoingEdges.size() == 0
					|| (outgoingEdges.size() == 1 && outgoingEdges
							.contains(new Edge(n, n)))) {
				result.add(n);
			}
		}
		return new LinkedList<>(result);
	}
}
