package source;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] map = new int[][]{
			{1, 1, 1, 1, 1, 1, 1, 1, 1},
			{0, 0, 1, 0, 0, 0, 0, 0, 1},
			{1, 1, 1, 1, 0, 1, 1, 0, 1},
			{1, 1, 1, 1, 1, 1, 1, 0, 0},
			{1, 0, 0, 0, 0, 1, 0, 0, 0},
			{1, 1, 1, 1, 0, 1, 1, 1, 1},
			{1, 1, 1, 1, 0, 1, 0, 0, 1},
			{1, 1, 1, 1, 0, 1, 0, 0, 1},
			{1, 1, 1, 1, 0, 1, 0, 0, 1},
			{1, 1, 1, 1, 0, 1, 0, 0, 0},
			{1, 1, 1, 1, 0, 1, 1, 1, 1},
	};
		
		Point start = new Point(0,0);
		Point finish = new Point(9,8);
		
		AStar zvezdica = new AStar();
		zvezdica.execute(map, start, finish);
		

	}

}
