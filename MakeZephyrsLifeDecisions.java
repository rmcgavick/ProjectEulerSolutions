import java.util.Random;

public class MakeZephyrsLifeDecisions {

	public static String makeDecision() {
		int min = 0;
		int max = 6;
	
		Random r = new Random();
		int decision = r.nextInt(max - min) + min;
		
		switch(decision) {
			case 0:
				return "Go rock climbing";
			case 1:
				return "Go running";
			case 2:
				return "Eat";
			case 3:
				return "Sleep";
			case 4:
				return "Watch TV";
			case 5:
				return "Sext";
			default:
				return "";
		}
	}
	
	public static void main(String[] args) {
		System.out.println(makeDecision());
	}

}
