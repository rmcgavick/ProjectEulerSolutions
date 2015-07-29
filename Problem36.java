/* ~ ~ ~QUESTION PROMPT ~ ~ ~
 * 
 * The decimal number, 585 = 1001001001(binary), is palindromic 
 * in both bases.
 * 
 * Find the sum of all numbers, less than one million, which are 
 * palindromic in base 10 and base 2.
 * 
 * (Please note that the palindromic number, in either base, may not 
 * include leading zeros.)
 * 
 * My Notes:
 * The main method here is able to solve the problem with minimal code
 * because it uses two calls to the isPalindrome method (which I wrote
 * to solve a previous solution - problem4). I also overloaded the isPalindrome 
 * method for this class. See the methods notes below.
 */

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class Problem36 {

	private static long startTime = System.nanoTime();
	private static ArrayList<String> DBPalindromes;
	private final static int limit = 1000000;
	private static long sum = 0;
	
	private static ArrayList<String> findDoubleBasePalindromes(int lim) {
		ArrayList<String> solution = new ArrayList<String>();
		
		for(long i=1; i<=lim; i++) {
			if(isPalindrome(i)) {
				String binary = Long.toBinaryString(i);
				if(isPalindrome(binary)) {
					solution.add(i + "::" + binary);
					sum += i;
				}
			}
		}
		return solution;
	}
	
	/* I was able to reuse this method from an earlier solution I only 
	 * had to change it so the @params are of type long instead of int
	 */
	private static boolean isPalindrome(long n) {
		boolean isPal = true;
		String num = "" + n;
		int len = num.length();
		int i = 0;
		
		while (i <= len) {
			if(num.charAt(i) != num.charAt(len-1)) {
				isPal = false;
				break;
			} else {
				i++;
				len--;
			}
		}
		return isPal;
	}
	
	/* Here is the overloaded isPalindrome method that takes a String
	 * as its @params. This is actually more simplified, since the method 
	 * above must first convert the long to a String
	 */
	private static boolean isPalindrome(String n) {
		boolean isPal = true;
		int len = n.length();
		int i = 0;
		
		while (i <= len) {
			if(n.charAt(i) != n.charAt(len-1)) {
				isPal = false;
				break;
			} else {
				i++;
				len--;
			}
		}
		return isPal;
	}
	
	public static void main(String[] args) {
		DBPalindromes = findDoubleBasePalindromes(limit);
		
		System.out.println(DBPalindromes + "\n\nCount of double-base Palindromes less than " 
				+ NumberFormat.getNumberInstance(Locale.US).format(limit) + " = " 
				+ DBPalindromes.size());

		System.out.println("Sum of these numbers (in base 10) = " + sum);
		
		long endTime = System.nanoTime();
		System.out.println("\nTook " + ((endTime - startTime) / 1000000000.0)
				+ " seconds.");
	}

}
