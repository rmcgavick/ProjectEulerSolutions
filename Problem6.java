
/* ~ ~ ~ QUESTION PROMPT ~ ~ ~
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + 3^2 +...+ 10^2 = 385
 * 
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + 3 +...+ 10)^2 = 3025
 * 
 * Hence the difference between the sum of the squares of the first 
 * ten natural numbers and the square of the sum is 3025 - 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one 
 * hundred natural numbers and the square of the sum.
 */

public class Problem6 {
	
	// this method finds the sum of the squares of the first
	// n natural numbers
	private static int sumOfSquares(int n) {
		int sum = 0;
		
		for(int i=1; i<=n; i++) {
			sum += i*i;
		}
		
		return sum;
	}
	
	// this method finds the square of the sum of the first 
	// n natural numbers
	private static int squareOfSums(int n) {
		double sum = 0;
		
		for(int i=1; i<=n; i++) {
			sum += i;
		}
		
		return (int)Math.pow(sum, 2.0);
	}
	
	public static void main(String[] args) {
		System.out.println(squareOfSums(100) - sumOfSquares(100));
	}
	
}
