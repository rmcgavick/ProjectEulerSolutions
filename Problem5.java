import java.util.ArrayList;

/* Question prompt:
 * 
 * 2520 is the smallest number that can be divided by each of the 
 * numbers from 1 to 10 without any remainder. What is the smallest positive 
 * number that is evenly divisible by all of the numbers from 1 to 20?
 */

public class Problem5 {
	static int[] factors;
	
	private static int findSmallestEvenlyDivisibleNum(int n) {
		factors = new int[n+1];
		double solution = 1;
		
		for(int i=n; i>=2; i--) {
			primeFactors(i);
		}	
		// loop that goes through the now-populated factors[] array
		// and takes all nonzero indexes, and multiples the index number
		// to the power of that index. For example, if factors[2] = 3,
		// solution *= (2^3)
		for(int i=2; i < factors.length; i++) {
			if(factors[i] > 0) {
				solution *= Math.pow(i,(factors[i]));
			}
		}
		return (int)solution;
	}
	
	// this method finds all prime factors of ONE number n,
	// but it keeps track of the highest power of each prime factor
	// in a class variable - the int[] factors.
	private static void primeFactors(int n) {
		int[] tempArr = new int[factors.length];
		
		while(n%2 == 0) {
			n /= 2;
			tempArr[2]++;
		}
		
		for(int i=3; i<=Math.sqrt(n); i = i+2) {
			while(n%i == 0) {
				tempArr[i]++;
				n /= i;
			}
		}
		
		if(n>2) 
			tempArr[n]++;
	    
	    for(int i=2; i<tempArr.length; i++) {
	    	if(tempArr[i] > factors[i])
	    		factors[i] = tempArr[i];
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(findSmallestEvenlyDivisibleNum(20));
		for(int i=0; i<factors.length; i++) {
			System.out.println("factors[" + i + "] = " + factors[i]);
		}
	}
}
