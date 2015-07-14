import java.math.BigInteger;

/* ~ ~ ~ QUESTION PROMPT ~ ~ ~
 * 
 * n! means n * (n-1) * ... * 3 * 2 * 1
 * 
 * For Example, 10! = 10 * 9 * ... * 3 * 2 * 1 = 362880
 * and the sum of the digits in the numer 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 */

/*
 * My Notes:
 * This was another program that was made easy by using the BigInteger class.
 * the max value of a long is too small to hold this number, but BigInteger
 * worked. 
 */

public class Problem20 {

	private static BigInteger findFactorialSum(int num) {
		BigInteger solution = new BigInteger("1");
		
		for(long i=num; i>1; i--) {
			BigInteger temp = BigInteger.valueOf(i);
			System.out.println(solution + " * " + i + " = " + (solution.multiply(temp)));
			solution = solution.multiply(temp);
		}
		return solution;
	}
	
	private static long countSumDigits(BigInteger b) {
		long sum = 0;
		String n = b.toString();
		
		for(char ch : n.toCharArray()) {
			sum += (ch - '0');
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(countSumDigits(findFactorialSum(100)));

	}

}
