// This prog finds the pythagorean triplet (a^2 + b^2 = c^2)
// such that a+b+c = 1000. There is only one such triplet.

public class PythagoreanTriplet {
	public static int a;
	public static int b;
	public static int c;
	public static int solution = 0;
	
	public static void findPythTriplet() {
		//while (solution != 12) {
			for(a = 1; a<500; a++) {
				for(b = a+1; b<501; b++) {
					for(c = b+1; c<502; c++) {
						if((a*a) + (b*b) == (c*c)){
							solution = a + b + c;
							//printSolution();
							if(solution == 1000)
								return;
						}
					}
				}
			}
		//}
	}
	
	public static void printSolution() {
		System.out.println("a = " + a + ", b = " + b + ", c = " + c + " \n a + b + c = " + solution);
		System.out.println("a * b * c = " + a*b*c);
	}
	
	public static void main(String[] args) {
		findPythTriplet();
		printSolution();
		
	}

}
