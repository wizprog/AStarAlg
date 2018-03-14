package source;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File file = null;
		Scanner scanner = null;
		Scanner scanner1 = null; 
		Scanner gitTest = null;
	 // int[][] matrix = new int[2 * (int) Math.pow(10, 6)][2 * (int) Math.pow(10, 6)];
		byte[][] matrix = new byte[30000][30000];
		
	/*	for (int i=0; i<60; i++){
			for (int j=0; j<60; j++)
				matrix[i][j] = 1;
		}  */
		 
		 int minM = 0;
		 int maxM = 0;
		 int minmax = 0;

		int x1, y1, x2, y2, x3, y3;
		int numOfObstacles;
		
		int pX, pY;
		int kX, kY;

			file = new File("input_2.txt");
			try {
				scanner = new Scanner(file);
				scanner1 = new Scanner(file);
				gitTest = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			pX = scanner.nextInt();	 if (pX < minM) minM = pX;  if (pX > maxM) maxM = pX;
			pY = scanner.nextInt();  if (pY < minM) minM = pY;  if (pY > maxM) maxM = pY;
			kX = scanner.nextInt();  if (kX < minM) minM = kX;  if (kX > maxM) maxM = kX;
			kY = scanner.nextInt();  if (kY < minM) minM = kY;  if (kY > maxM) maxM = kY;

			numOfObstacles = scanner.nextInt();

			for (int i = 0; i <6 * numOfObstacles; i++) {
				x1 = scanner.nextInt();
				if (x1 < minM) minM = x1;
				if (x1 > maxM) maxM = x1;
			}
			
			minmax = Math.max(Math.abs(minM), maxM);
			
	/*		for (int i=0; i<2*minmax+1; i++){
				for (int j=0; j<2*minmax+1; j++)
					matrix[i][j] = 1;
			}*/
			
			
			int X1 = scanner1.nextInt();
			int Y1 = scanner1.nextInt();
			int X2 = scanner1.nextInt();
			int Y2 = scanner1.nextInt();
			
			
			pX = minmax - Y1;
			pY = X1 +  minmax;
			kX =  minmax - Y2;
			kY = X2 +  minmax;

			numOfObstacles = scanner1.nextInt();

			Point[] array1 = new Point[numOfObstacles];
			Point[] array2 = new Point[numOfObstacles];
			Point[] array3 = new Point[numOfObstacles];

			for (int i = 0; i <numOfObstacles; i++) {
				x1 = scanner1.nextInt();
				y1 = scanner1.nextInt();
				x2 = scanner1.nextInt();
				y2 = scanner1.nextInt();
				x3 = scanner1.nextInt();
				y3 = scanner1.nextInt();

				array1[i] = new Point( minmax - y1, minmax + x1);
				array2[i] = new Point( minmax - y2, minmax + x2);
				array3[i] = new Point( minmax - y3, minmax + x3);

				check(array1[i], array2[i], array3[i], matrix);
			}
		
	/*
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
			
	};  */
		
		Point start = new Point(pX,pY);
		Point finish = new Point(kX,kY);
		
		for(int i = 0; i < matrix.length; i++){
				for(int j = 0; j < matrix[0].length; j++)
						System.out.print(matrix[i][j] + " ");
				System.out.println();
		}   
		
		
		try {
			File fileOut = new File("output_1.txt");
			PrintWriter printWriter = new PrintWriter (fileOut);
			AStar zvezdica = new AStar();
			if (zvezdica.execute(matrix, start, finish, printWriter)) System.out.println("DONE");
			else System.out.println("NO PATH");
			printWriter.close ();  
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	static void check(Point p1, Point p2, Point p3, byte matrix[][]) {
		int xMax = Math.max(Math.max(p1.getX(), p2.getX()), p3.getX());
		int yMax = Math.max(Math.max(p1.getY(), p2.getY()), p3.getY());
		int xMin = Math.min(Math.min(p1.getX(), p2.getX()), p3.getX());
		int yMin = Math.min(Math.min(p1.getY(), p2.getY()), p3.getY());

		for (int i = xMin; i <= xMax; i++) {
			for (int j = yMin; j <= yMax; j++) {
				if (inside(new Point(i, j), p1, p2, p3)) {
					matrix[(int) i][(int) j] = 0; // if point is in the triangle we set the value of that field to 0
				}
			}
		}

	}
	
	static double area (Point a, Point b, Point c) {
		
		return Math.abs((a.x*(b.y-c.y) + b.x*(c.y-a.y)+ c.x*(a.y-b.y))/2.0);
	}
	
	static boolean inside (Point s, Point a, Point b, Point c) {
		
		if (area(s,a,b) + area(s,a,c) + area(s,b,c) == area(a,b,c)) return true;
		else return false;
	}

}
