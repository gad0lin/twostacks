package puzzles.twostacks.graph;

public class Edge {
	
	private Node orgin;
	
	private Node target;

	public Edge(Node orgin, Node target) {
		super();
		this.orgin = orgin;
		this.target = target;
	}

	public Node getOrgin() {
		return orgin;
	}

	public Node getTarget() {
		return target;
	}
	
	@Override
	public int hashCode() {
		return orgin.hashCode()*7 + target.hashCode() * 11;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null != obj instanceof Edge) {
			Edge edge = (Edge) obj;
			return edge.orgin.equals(orgin) && edge.target.equals(target);
			
		}
		return super.equals(obj);
	}

}
