import java.math.BigInteger;

/* ~ ~ ~ QUESTION PROMPT ~ ~ ~
 * 
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 */

/* My notes:
 * 
 * This program correctly solves the problem using the BigInteger class
 * to store the huge value of 2^1000. The print statements are what I 
 * was using for testing.
 * 
 * my formula for "adding the digits" in the number involves BigInteger
 * math and comparisons, so my method instantiates quite a few BigIntegers,
 * including remainder, sum and a final BigInteger with the value of 10.
 * This lets me go through and perform the operation: num % 10, where num
 * is my original BigInteger, since BigIntegers can't otherwise be used in 
 * operations with variables of type int or long. Did I say "BigInteger" 
 * enough in this paragraph? BigInteger!!
 */

public class Probelm16 {

	static final BigInteger bi = new BigInteger("2"); 
	static final BigInteger ZERO = new BigInteger("0");
	
	private static BigInteger findPowerSum(BigInteger b, int exponent) {
		b = bi.pow(exponent);
		final BigInteger modBI = new BigInteger("10");
		BigInteger remainder;
		BigInteger sum = new BigInteger("0");
		
		while(b.compareTo(ZERO) > 0) {	
			remainder = b.mod(modBI);
			sum = sum.add(remainder);
			b = b.divide(modBI);
			
			System.out.println("b = " + b + ", sum = " + sum + ", remainder = " + remainder);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(findPowerSum(bi, 1000));
	}
}
