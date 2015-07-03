package problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *  ~~~~~~~~~~ question prompt ~~~~~~~~~~~
 * Starting in the top left corner of a 2×2 grid, and only being able to move 
 * to the right and down, there are exactly 6 routes to the bottom right corner.
 * 
 * How many such routes are there through a 20x20 grid?
 */

public class Problem15 {
	
	static long startTime = System.nanoTime();
	private static GridTile[][] t;
	private static GridList tiles;
	private static int gridX;
	private static int gridY;
	
	public static void populateGrid(int gridxSize, int gridySize) {
		int idNum = 0;
		gridX = gridxSize;
		gridY = gridySize;
		t = new GridTile[gridY][gridX];

		for(int x=0; x<gridY; x++) {
			for(int y=0; y<gridX; y++) {
				
				if(x == gridX-1 && y == gridY-1)
					t[y][x] = new GridTile(x, y, idNum++, true, true);
				else if(y == gridX-1)
					t[y][x] = new GridTile(x, y, idNum++, true, false);
				else if(x == gridY-1)
					t[y][x] = new GridTile(x, y, idNum++, false, true);
				else
					t[y][x] = new GridTile(x, y, idNum++, false, false);
			}
		}
		
		tiles = new GridList();
		
		for(int i=0; i<gridY; i++) {
			for(int j=0; j<gridX; j++) {
				tiles.add(t[j][i]);
				System.out.printf("%-16s ", t[j][i]);
			}
			System.out.println();
		}
		return;
	}	

	public static int findPaths() {
		int numMoves;
		// each path is a boolean array representing the path: true = right, false = down
		// we know each path has to be of length 40, because there are 20x20 tiles
		ArrayList<boolean[]> paths = new ArrayList<boolean[]>();
		int currentTileID = 0;
		int endTileID = 399;
		GridTile currentTile = tiles.get(currentTileID);
		boolean flag;
		boolean exitFlag = false;
		
		// outer while loop that executes until there are no more traversed paths
		// exit condition is when currentTileID == 0 and currentTile.moveDown() == null
		while(!exitFlag) {
			boolean[] path = new boolean[40];
			currentTileID = 0;
			currentTile = tiles.get(currentTileID);
			flag = false;
			
			// inner while loop that finds one path. Each iteration through this loop
			// will only set the flag once, indicating that one tile has been removed
			// from the list of possible tiles each pass through the loop.
			//while(currentTileID != endTileID) {	
			for(numMoves = 0; currentTileID < endTileID; numMoves++) {
				if(tiles.moveRight(currentTile) != null) {
					currentTile = tiles.moveRight(currentTile);
					System.out.println("move right " + currentTile.getID());
					currentTileID = currentTile.getID();
					path[numMoves] = true;
				}
				else {
					if(!flag && currentTile.getY() != 0) {
						currentTile.tileVisited(true);
						flag = true;
					}
					currentTile = tiles.moveDown(currentTile);
					System.out.println("move down " + currentTile.getID());
					currentTileID = currentTile.getID();
					path[numMoves] = false;
				}
			}
			
			paths.add(path);
			if(paths.size() > 2 && Arrays.equals(paths.get(paths.size()-1), paths.get(paths.size()-2))) {
				System.out.println(paths.size());
				paths.remove(paths.size()-1);
				exitFlag = true;				
			}
			System.out.println(paths.size());
		}

		return paths.size();
	}
	
	public static void main(String[] args) {
		populateGrid(20, 20);
		System.out.println("Num paths = " + findPaths());
		
	/* just some gridtile test code ------------------------------------------------------------
		System.out.println(t[19][0].isHorzEdge() + " " + t[19][10].isVertEdge());
		System.out.println(t[17][19].isHorzEdge() + " " + t[5][19].isVertEdge());
		System.out.println(t[19][19].isHorzEdge() + " " + t[19][19].isVertEdge());
		
		System.out.println(tiles.get(1));
		System.out.println(tiles.get(19).isHorzEdge());
		System.out.println(tiles.get(0).isHorzEdge());
	// -----------------------------------------------------------------------------------------
	*/
		
		long endTime = System.nanoTime();
		System.out.println("\nTook "+ ((endTime - startTime) / 1000000000.0) + " seconds");
	}
}
