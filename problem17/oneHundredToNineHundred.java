package problem17;

public enum oneHundredToNineHundred {
	
	ZERO(0),
	ONEHUNDREDAND(13), 
	TWOHUNDREDAND(13), 
	THREEHUNDREDAND(15), 
	FOURHUNDREDAND(14), 
	FIVEHUNDREDAND(14), 
	SIXHUNDREDAND(13), 
	SEVENHUNDREDAND(15), 
	EIGHTHUNDREDAND(15),
	NINEHUNDREDAND(14);

	
	private int value;

	private oneHundredToNineHundred(int val) {
		this.value = val;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String toString() {
		switch(this) {
		case ZERO:
			return "";
		case ONEHUNDREDAND:
			return "ONE HUNDRED AND (" + value + ") ";
		case TWOHUNDREDAND:
			return "TWO HUNDRED AND (" + value + ") ";
		case THREEHUNDREDAND:
			return "THREE HUNDRED AND (" + value + ") ";
		case FOURHUNDREDAND:
			return "FOUR HUNDRED AND (" + value + ") ";
		case FIVEHUNDREDAND:
			return "FIVE HUNDRED AND (" + value + ") ";
		case SIXHUNDREDAND:
			return "SIX HUNDRED AND (" + value + ") ";
		case SEVENHUNDREDAND:
			return "SEVEN HUNDRED AND (" + value + ") ";
		case EIGHTHUNDREDAND:
			return "EIGHT HUNDRED AND (" + value + ") ";
		case NINEHUNDREDAND:
			return "NINE HUNDRED AND (" + value + ") ";
		default:
			return "";
		}
	}
}
