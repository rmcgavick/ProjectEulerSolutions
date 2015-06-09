package problem11;
// This class is used to solve problem 11. It just stores all the data
// for an object in a 2d grid of ints, like its value as well as its relative x and y position

public class GridObj {

	private int val;
	private int xPos;
	private int yPos;
	
	public GridObj(int v, int x, int y) {
		val = v;
		xPos = x;
		yPos = y;
	}
	
	public GridObj(int v) {
		val = v;
		xPos = 0;
		yPos = 0;
	}
	
	public GridObj() {
		val = 0;
		xPos = 0;
		yPos = 0;
	}
	
	public int getVal() {
		return val;
	}
	
	public int getxPos() {
		return xPos;
	}
	
	public int getyPos() {
		return yPos;
	}
	
	public void setVal(int newVal) {
		val = newVal;
	}
	
	public void setXPos(int newX) {
		xPos = newX;
	}
	
	public void setYPos(int newY) {
		yPos = newY;
	}
	
	public String toString() {
		return ("Value = " + val + ", position = (" + xPos + ", " + yPos + ")");
	}
}
