package source;

import java.util.LinkedList;

public class Path {
	
	LinkedList<Node> path;

	public Path(LinkedList<Node> path) {
		super();
		this.path = path;
	}
	
	public Path() {
		path = new LinkedList<Node>();
	}
	
	public LinkedList<Node> getList(){
		return path;
	}
	
	public Node getNode() {
		return path.getLast();
	}
	
	public void insertNode(Node o) {
		path.add(o);
	}
	
	
	

}
