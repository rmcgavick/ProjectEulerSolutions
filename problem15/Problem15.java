package problem15;
/*
 *  ~~~~~~~~~~ question prompt ~~~~~~~~~~~
 * Starting in the top left corner of a 2×2 grid, and only being able to move 
 * to the right and down, there are exactly 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20x20 grid?
 * 
 * My solution:
 * Because we can only move right or down (we can't go backwards), we know that
 * each path will have to be of exactly length 40.
 *
 */

public class Problem15 {
	
	static long startTime = System.nanoTime();
	private static GridTile[][] tiles;
	private static int gridX;
	private static int gridY;
	
	public static void populateGrid(int gridxSize, int gridySize) {
		int idNum = 0;
		gridX = gridxSize;
		gridY = gridySize;
		tiles = new GridTile[gridY][gridX];

		for(int x=0; x<gridY; x++) {
			for(int y=0; y<gridX; y++) {
				
				if(x == gridX-1 && y == gridY-1)
					tiles[y][x] = new GridTile(x, y, ++idNum, true, true);
				else if(y == gridX-1)
					tiles[y][x] = new GridTile(x, y, ++idNum, true, false);
				else if(x == gridY-1)
					tiles[y][x] = new GridTile(x, y, ++idNum, false, true);
				else
					tiles[y][x] = new GridTile(x, y, ++idNum, false, false);
			}
		}
		
		for(int i=0; i<gridY; i++) {
			for(int j=0; j<gridX; j++) {
				System.out.printf("%-16s ", tiles[j][i]);
			}
			System.out.println();
		}
		return;
	}	

	public static int findPaths() {
		int solution = 0;
		
		/*
		 * Sudo-code
		 * create bool array to represent path  - a true can be down and a false can be right, for example
		 * create endtile -> id == 400 in this case
		 * create sum var to keep track of number of paths
		 * 
		 * while there are still un-traversed paths left:
		 * 
		 * start at tile id#1:
		 * while currentTile != endTile:
		 * while currentTile != isVertEdge && != tileVisited: move right (NOTE: isVisited is not a good name for this variable... should be something like "isRemovedFromPossiblePath"... (instead of having isVisitedFlag, change that tiles isVertEdge variable to true! Once you do this, you can remove isVisited altogether))
		 * 		else move down 1 - try to go right again
		 * (each move adds to the bool array)
		 * 
		 * 
		 * 
		 */
		
		
		return solution;
	}
	
	public static void main(String[] args) {
		populateGrid(20, 20);
		
	// just some gridtile test code ------------------------------------------------------------
		System.out.println(tiles[19][0].isHorzEdge() + " " + tiles[19][10].isVertEdge());
		System.out.println(tiles[17][19].isHorzEdge() + " " + tiles[5][19].isVertEdge());
		System.out.println(tiles[19][19].isHorzEdge() + " " + tiles[19][19].isVertEdge());
	// -----------------------------------------------------------------------------------------
		
		long endTime = System.nanoTime();
		System.out.println("\nTook "+ ((endTime - startTime) / 1000000000.0) + " seconds");
	}
}
