package source;


import java.util.HashMap;
import java.util.PriorityQueue;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] map = new int[][]{
			{1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}  
			
	/*		{1,1,1,1},
			{1,1,1,1},
			{1,1,1,1},
			{1,1,1,1} */
			
	};
		
		Point start = new Point(23,0);
		Point finish = new Point(0,12);
		
		AStar zvezdica = new AStar();
		if (zvezdica.execute(map, start, finish)) System.out.println("DONE");
		else System.out.println("NO PATH");  
		
	/*	Node pom = new Node();
		pom.gScore = 0;
		Node finish2 = new Node();
		finish2.x = 10;
		finish2.y = 10;
	
		
		PriorityQueue<Node> open_list = new PriorityQueue<Node>();
		open_list.add(new Node(new Point(0,0),pom,finish2 ));
		open_list.add(new Node(new Point(2,5),pom,finish2 ));
		open_list.add(new Node(new Point(1,1),pom,finish2 ));
		open_list.add(new Node(new Point(5,9),pom,finish2 ));
		open_list.add(new Node(new Point(7,8),pom,finish2 ));
		
		for (int i=0; i<5 ; i++) System.out.println(open_list.poll());
/*		HashMap<Integer, Node> closed_list = new HashMap<Integer, Node>();
		
		Node str = new Node();
		
		Point p = new Point(str.x , str.y);
		closed_list.put(str.x*map.length + str.y, str);
		
		int x = map.length;
		
		System.out.println(closed_list.get(str.x*map.length + str.y));  */
	}

}
