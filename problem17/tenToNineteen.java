package problem17;

public enum tenToNineteen {
	
	TEN(3),
	ELEVEN(6),
	TWELVE(6),
	THIRTEEN(8),
	FOURTEEN(8),
	FIFTEEN(7),
	SIXTEEN(7),
	SEVENTEEN(9),
	EIGHTEEN(8),
	NINETEEN(8);
	
	private int value;

	private tenToNineteen(int val) {
		this.value = val;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public String toString() {
		switch(this) {
		case TEN:
			return "TEN (" + value + ") ";
		case ELEVEN:
			return "ELEVEN (" + value + ") ";
		case TWELVE:
			return "TWELVE (" + value + ") ";
		case THIRTEEN:
			return "THIRTEEN (" + value + ") ";
		case FOURTEEN:
			return "FOURTEEN (" + value + ") ";
		case FIFTEEN:
			return "FIFTEEN (" + value + ") ";
		case SIXTEEN:
			return "SIXTEEN (" + value + ") ";
		case SEVENTEEN:
			return "SEVENTEEN (" + value + ") ";
		case EIGHTEEN:
			return "EIGHTEEN (" + value + ") ";
		case NINETEEN:
			return "NINETEEN (" + value + ") ";
		default:
			return "";
		}
	}
}
