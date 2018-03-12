package source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;




public class AStar {

	private PriorityQueue<Node> open_list;
	private HashMap<Integer, Node> closed_list;
	private int lastCost;
	private int expandedCounter;
	Node finish;
	int global_map[][];
	
	
	
	ArrayList<Node> result = new ArrayList<Node>();
	
	
	public AStar(PriorityQueue<Node> paths, HashMap<Integer, Node> mindists, int lastCost, int expandedCounter) {
		super();
		this.open_list = paths;
		this.closed_list = mindists;
		this.lastCost = lastCost;
		this.expandedCounter = expandedCounter;
		
	}
	
	public AStar() {
		super();
		this.finish = new Node();
		open_list = new PriorityQueue<Node>();
		closed_list = new HashMap<Integer, Node>();
		expandedCounter = 0;
		lastCost = 0;
	}
	
	public boolean execute(int[][] map, Point str , Point fns) {
		
		Node current = null;
		LinkedList<Node> lcl = new LinkedList<Node>();
		HashMap<Integer, Boolean> open_list_map = new HashMap<Integer, Boolean>();
		
		this.finish.x = fns.getX();
		this.finish.y = fns.getY();
		
		this.global_map = map;
		Node start = new Node();
		start.x = str.getX();
		start.y = str.getY();
		
		start.fScore = start.manhattanDistance(this.finish);

		int N = this.global_map.length;
		
		open_list.add(start);
		open_list_map.put(start.x * N + start.y, true);
		
		
		Node openN = null;
		LinkedList<Node> helpMe = new LinkedList<Node>();
		
		while(open_list.size() != 0) {
			current = this.open_list.poll();
			open_list_map.remove(current.x*N + current.y);
			if (this.isDone(current)) { construct_path(current); return true; }
			else {
				this.closed_list.put(current.x*N + current.y, current);
				lcl = this.neighbors(current);
				for (Node object : lcl) {
					if (!closed_list.containsKey( N*object.x +object.y)) {
						if (!open_list_map.containsKey( N*object.x +object.y)) {
							open_list.add(object);
							open_list_map.put(object.x * N +object.y, true);
							
						}
						else {
							Node m = open_list.poll();
							while (m.x != object.x && m.y != object.y) {
								helpMe.add(m);
								m = open_list.poll();
							}
							
							for (Node x : helpMe) open_list.add(x);

							if (object.getgScore() < m.getgScore()) open_list.add(object);
								else open_list.add(m);
							
						}
						
					}
				}
				
			}
		}
		
			
		return false;
	}
	
	private void construct_path(Node finish2) {
		
		Node pom = finish2;
		while (pom.getParent() != null) {
			System.out.println(pom);
			pom = pom.getParent();
		}
		
	}

	public boolean isDone(Node o) {
		if (o.x == finish.x && o.y == finish.y) return true;
			else return false;
	}
	
	
	public LinkedList<Node>  neighbors(Node o) {
		
		LinkedList<Node> local = new LinkedList<Node>();
		
		for (int i=0; i<4 ; i++) {
			switch(i) {
			case 0:
				if (o.y != 0 ) if (this.global_map[o.x][o.y-1] != 0) { 
					local.add(new Node(new Point(o.x, o.y-1), o, this.finish ));
					}   
				break; 
			case 1:
				if (o.y != this.global_map.length-1 ) if (this.global_map[o.x][o.y+1] != 0) {
					local.add(new Node(new Point(o.x, o.y+1), o, this.finish ));
				}
				break;
			case 2:
				if (o.x != 0 ) if (this.global_map[o.x-1][o.y] != 0) {
					local.add(new Node(new Point(o.x-1, o.y), o, this.finish ));
				}
				break;
			case 3:
				if (o.x != this.global_map.length-1 ) if (this.global_map[o.x+1][o.y] != 0) {
					local.add(new Node(new Point(o.x+1, o.y), o, this.finish ));
					
				}
			}			
		}
		
		
		 return local;
	}
	
	
	
	
	
}
