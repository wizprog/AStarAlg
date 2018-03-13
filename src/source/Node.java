package source;

public class Node implements Comparable<Node> {
	
	public int x;
	public int y;
	int gScore;
	int fScore;
	Node parent;
	
	
	
	public Node(Point p, Node parent , Node finish) {
		super();
		this.x = p.getX();
		this.y = p.getY();
		this.gScore = parent.getgScore() + 1;
		this.fScore = this.gScore + this.manhattanDistance(finish);
		this.parent = parent;
	}
	
	public Node() {
		super();
		this.x = 0;
		this.y = 0;
		this.gScore = 0;
		this.fScore = 0;
		this.parent = null;
	}
	
	
	public int getgScore() {
		return gScore;
	}

	public void setgScore(int gScore) {
		this.gScore = gScore;
	}

	public int getfScore() {
		return fScore;
	}

	public void setScore(int hScore) {
		this.fScore = hScore;
	}
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public void setfScore(int fScore) {
		this.fScore = fScore;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.fScore, o.getfScore());
	}
	
	public int calculateF(Node finish) {
		fScore = this.gScore + this.manhattanDistance(finish);
		return fScore;
	}
	
	public int manhattanDistance(Node o) {
		return Math.abs(this.x - o.x ) + Math.abs(this.y - o.y);
	}

	@Override
	public String toString() {
		return  x + " " + y;
	}
	
	
}
