/* ~ ~ ~ QUESTION PROMPT ~ ~ ~ 
 * 
 * The number 3797 has an interesting property. Being prime itself, it is possible to continuously 
 * remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. 
 * 
 * Similarly we can work from right to left: 3797, 379, 37, and 3.
 * Find the sum of the only eleven primes that are both truncatable from left to right and right 
 * to left.
 * 
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 * 
 * My notes: I solved this with a simple isPrime() method, that just uses the brute force
 * method of checking for prime numbers, and the checkIfTruncate() method that parses each
 * prime number from left to right and right to left, making a call to isPrime() after each
 * truncation.
 * 
 * The biggest problem I had to overcome to finish this solution was that my isPrime() method
 * was returning true when the truncated prime equals 1. I had to add in an extra check for when the
 * truncated prime == 1, and the solution works, in almost exactly 1 minute.
 */

public class Problem37 {
	private static long startTime = System.nanoTime();
	private static int[]  trunctPrimes = new int [11];
	private static int sum = 0;
	
	/* This method finds all primes starting at 11, and then checks to see
	 * if they are trunctable (by calling another method - checkIfTruncatable() below).
	 * It runs until it has found the 11 truncatable prime numbers.
	 */
	private static int[] findTruncatablePrimes() {
		int[] solution = new int[11];
		
		// we know there are exactly 11 of these truncatable prime numbers,
		// and that it can't be a single digit number - so we start at 11
		for (int i = 11, count = 0; count < 11; i++) {
			if(isPrime(i)) {
				if(checkIfTruncatable(i)) {
					System.out.println("Found!" + i);
					solution[count++] = i;
				}
			}
		}
		
		return solution;
	}
	
	// method that returns true if n is prime
	private static boolean isPrime(int n) {
		for( int j = 2; j < n; j++) {	
			if((n % j == 0)) {
				return false;
			}
		}
		return true;
	}
	
	/* Truncates n, both from left to right then from right to left, 
	 * checking to see if the new number that results from the truncation 
	 * is also prime. If the truncated number is prime, this method returns
	 * false. Otherwise, it returns true;
	 */
	private static boolean checkIfTruncatable(int n) {
		String numString = "" + n;
		Integer temp;
		
		// first check from left to right
		for(int i = 1; i < numString.length(); i++) {
			temp = Integer.valueOf(numString.substring(i, numString.length()));
			if(!isPrime(temp) || temp == 1) {
				return false;
			}
		}
		
		// now check from right to left
		for(int i = numString.length()-1; i > 0; i--) {
			temp = Integer.valueOf(numString.substring(0, i));
			if(!isPrime(temp) || temp == 1) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {

		trunctPrimes = findTruncatablePrimes();
		
		for(int i = 0; i < trunctPrimes.length; i++) {
			sum += trunctPrimes[i];
			System.out.println("Sum += i - " + sum + " += " + trunctPrimes[i]);
		}
		
		long endTime = System.nanoTime();
		System.out.println("\nTook " + ((endTime - startTime) / 1000000000.0)
				+ " seconds.");
	}
}
