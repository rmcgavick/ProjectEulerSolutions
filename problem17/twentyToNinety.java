package problem17;

public enum twentyToNinety {
	
	TWENTY(6), 
	THIRTY(6), 
	FORTY(5), 
	FIFTY(5), 
	SIXTY(5), 
	SEVENTY(7), 
	EIGHTY(6), 
	NINETY(6);
	
	private int value;

	private twentyToNinety(int val) {
		this.value = val;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String toString() {
		switch(this) {
		case TWENTY:
			return "TWENTY (" + value + ") ";
		case THIRTY:
			return "THIRTY (" + value + ") ";
		case FORTY:
			return "FORTY (" + value + ") ";
		case FIFTY:
			return "FIFTY (" + value + ") ";
		case SIXTY:
			return "SIXTY (" + value + ") ";
		case SEVENTY:
			return "SEVENTY (" + value + ") ";
		case EIGHTY:
			return "EIGHTY (" + value + ") ";
		case NINETY:
			return "NINETY (" + value + ") ";
		default:
			return "";
		}
	}
}
