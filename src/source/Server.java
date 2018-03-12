package source;


import java.util.HashMap;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] map = new int[][]{
			{1, 1, 1, 1},
			{0, 1, 0, 0},
			{1, 1, 1, 1},
			{1, 1, 1, 1}
	};
		
		Point start = new Point(0,0);
		Point finish = new Point(3,3);
		
		AStar zvezdica = new AStar();
		zvezdica.execute(map, start, finish);
		
/*		HashMap<Integer, Node> closed_list = new HashMap<Integer, Node>();
		
		Node str = new Node();
		
		Point p = new Point(str.x , str.y);
		closed_list.put(str.x*map.length + str.y, str);
		
		int x = map.length;
		
		System.out.println(closed_list.get(str.x*map.length + str.y));  */
	}

}
