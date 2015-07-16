package problem18;

public class TriangleNode {

	private final int nodeID;
	private final int row;
	private final int index;
	private final int value;
	private final boolean isBottomRow;
	
	public TriangleNode(int id, int r, int i, int val, boolean b) {
		nodeID = id;
		row = r;
		index = i;
		value = val;
		isBottomRow = b;
		
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public boolean isBottomRow() {
		return this.isBottomRow;
	}
}
