/*
 * For the question prompt, read the comments in Problem15.java in
 * the same package.
 * This is my second attempt at solving this problem, after doing
 * more research. It turns out that the number of lattice paths on 
 * an n*n grid are the central binomial coefficients, meaning they 
 * fall along the center line of Pascal's triangle:
 * 
 * 						1
 * 					1		1
 * 				1		2		1
 * 			1		3		3		1
 * 		1		4		6		4		1
 * 
 * etc...
 * So, the formula for this is simply (2n)!/n!^2,
 * so below is my solution using this algorithm. The code may look
 * confusing but it's only because I had to use BigInteger's
 * to do all the factorial math.
 */

package problem15;

import java.math.BigInteger;

public class NewProblem15 {

	private final static long startTime = System.nanoTime();
	private final static BigInteger gridSize = BigInteger.valueOf(20);
	private static final BigInteger ONE = BigInteger.valueOf(1);
	private static final BigInteger TWO = BigInteger.valueOf(2);
	private static final BigInteger ZERO = BigInteger.valueOf(0);
	
	// this method uses the formula (2n)!/n!^2
	private static BigInteger countLatticePaths(BigInteger n) {
		return ((factorial(n.multiply(TWO)).divide((factorial(n).pow(2)))));
	}
	
	private static BigInteger factorial(BigInteger n) {
		for(BigInteger i = n.subtract(ONE); 
			i.compareTo(ZERO)>0; 
			i = (i.subtract(ONE))) {
				n = (n.multiply(i));
		}
		return n;
	}
	
	public static void main(String[] args) {
		
		System.out.println("Number of lattice paths in a " + gridSize + "*" + 
		gridSize + " grid = " + countLatticePaths(gridSize));		
		
		long endTime = System.nanoTime();
		System.out.println("\nTook "+ ((endTime - startTime) / 1000000000.0) + " seconds");
	}

}
