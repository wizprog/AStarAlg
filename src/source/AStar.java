package source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;




public class AStar {

	private PriorityQueue<Node> open_list;
	private HashMap<Point, Node> closed_list;
	private int lastCost;
	private int expandedCounter;
	Node finish;
	int global_map[][];
	
	
	
	ArrayList<Node> result = new ArrayList<Node>();
	
	
	public AStar(PriorityQueue<Node> paths, HashMap<Point, Node> mindists, int lastCost, int expandedCounter) {
		super();
		this.open_list = paths;
		this.closed_list = mindists;
		this.lastCost = lastCost;
		this.expandedCounter = expandedCounter;
		
	}
	
	public AStar() {
		super();
		open_list = new PriorityQueue<Node>();
		closed_list = new HashMap<Point, Node>();
		expandedCounter = 0;
		lastCost = 0;
	}
	
	public boolean execute(int[][] map, Point str , Point fns) {
		
		Node current = null;
		LinkedList<Node> lcl = new LinkedList<Node>();
		
		this.global_map = map;
		Node start = new Node();
		start.x = str.getX();
		start.y = str.getY();
		
		this.finish.x = fns.getX();
		this.finish.y = fns.getY();
		
		open_list.add(start);
		
		while(open_list.size() != 0) {
			current = this.open_list.poll();
			if (this.isDone(current)) { construct_path(this.finish); return true; }
			else {
				this.closed_list.put(new Point(current.x,current.y), current);
				lcl = this.neighbors(current);
				
			}
		}
		
			
		return false;
	}
	
	private void construct_path(Node finish2) {
		
		
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
				if (o.y != 0 ) if (this.global_map[o.x][o.y-1] != 1) { 
				//	open_list.add(new Node(new Point(o.x, o.y-1), o, this.finish ));
					local.add(new Node(new Point(o.x, o.y-1), o, this.finish ));
					}   
				break; 
			case 1:
				if (o.y != this.global_map.length-1 ) if (this.global_map[o.x][o.y+1] != 1) {
				//	open_list.add(new Node(new Point(o.x, o.y+1), o, this.finish ));
					local.add(new Node(new Point(o.x, o.y+1), o, this.finish ));
				}
				break;
			case 2:
				if (o.x != 0 ) if (this.global_map[o.x-1][o.y] != 1) {
				//	open_list.add(new Node(new Point(o.x-1, o.y), o, this.finish ));
					local.add(new Node(new Point(o.x-1, o.y), o, this.finish ));
				}
				break;
			case 3:
				if (o.x != this.global_map.length-1 ) if (this.global_map[o.x+1][o.y] != 1) {
				//	open_list.add(new Node(new Point(o.x+1, o.y), o, this.finish ));
					local.add(new Node(new Point(o.x+1, o.y), o, this.finish ));
					
				}
			}			
		}
		
		
		 return local;
	}
	
	
	
	
	
}
