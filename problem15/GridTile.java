package problem15;

public class GridTile {
	private final int xVal;
	private final int yVal;
	private final int idNum;
	private final boolean isVertEdge;
	private final boolean isHorzEdge;
	private boolean visitedFlag;
	
	public GridTile(int x, int y, int id, boolean horzEdge, boolean vertEdge) {
		xVal = x;
		yVal = y;
		idNum = id;
		isVertEdge = vertEdge;
		isHorzEdge = horzEdge;
		visitedFlag = false;
	}
	
	public int getX() {
		return xVal;
	}
	
	public int getY() {
		return yVal;
	}
	
	public int getID() {
		return idNum;
	}
	
	public boolean isVertEdge() {
		return isVertEdge;
	}

	public boolean isHorzEdge() {
		return isHorzEdge;
	}
	
	public void tileVisited(boolean b) {
		visitedFlag = b;
	}
	
	public String toString() {
		return "[(" + xVal + ", " + yVal + ") " + "#" + idNum + "]";
	}
}
