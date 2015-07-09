package problem17;

public enum oneToNine {

	ZERO(0),
	ONE(3), 
	TWO(3), 
	THREE(5), 
	FOUR(4), 
	FIVE(4), 
	SIX(3), 
	SEVEN(5), 
	EIGHT(5), 
	NINE(4);
	
	private int value;

	private oneToNine(int val) {
		this.value = val;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String toString() {
		switch(this) {
		case ZERO:
			return "";
		case ONE:
			return "ONE (" + value + ") ";
		case TWO:
			return "TWO (" + value + ") ";
		case THREE:
			return "THREE (" + value + ") ";
		case FOUR:
			return "FOUR (" + value + ") ";
		case FIVE:
			return "FIVE (" + value + ") ";
		case SIX:
			return "SIX (" + value + ") ";
		case SEVEN:
			return "SEVEN (" + value + ") ";
		case EIGHT:
			return "EIGHT (" + value + ") ";
		case NINE:
			return "NINE (" + value + ") ";
		default:
			return "";
		}
	}
}
