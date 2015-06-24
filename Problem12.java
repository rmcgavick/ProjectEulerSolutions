/*
The sequence of triangle numbers is generated by adding the natural numbers. 
So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. 
The first ten terms would be:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

Let us list the factors of the first seven triangle numbers:

     1: 1
     3: 1,3
     6: 1,2,3,6
    10: 1,2,5,10
    15: 1,3,5,15
    21: 1,3,7,21
    28: 1,2,4,7,14,28

We can see that 28 is the first triangle number to have over five divisors.

What is the value of the first triangle number to have over five hundred divisors?
*/

// First program solved the problem correctly, but it took 15.65 minutes. I
// re-wrote the program to use only ints instead of arraylists, which took 13 minutes

import java.util.*;

public class Problem12 {
	
	static long startTime = System.nanoTime();
	static int triangleNums = 0;
	static int triangleNumDivisors = 0;
	static int solution = 0;
	
	public static void populateTriangleNums() { 
		int n = 0;
		int numDivisors = 0;
		for(int i=1, j=1; numDivisors < 502; i++) {
			n = 1;
			j = i;
			
			while (j>1) {
				n += j--;
			}			
			triangleNums++;
			numDivisors = findDivisors(n);
		}
		solution = n;
		triangleNumDivisors = numDivisors;
	}
	
		public static int findDivisors(int n) {
		int divisors = 2;
		
		for(int i = 2; i <= (int) n/2; i++) {
			if (((int) n % i) == 0) {
				divisors++;
			}
		}
		return divisors;
	}
	
	public static void main(String args[]) {
		populateTriangleNums();
		System.out.println("Number of divisors for triangle number " + triangleNums + " = " + triangleNumDivisors);
		System.out.println("Value of first triangle number with over 500 divisors = " + solution);

		long endTime = System.nanoTime();
		System.out.println("\nTook "+ ((endTime - startTime) / 1000000000.0) + " seconds");
	}
	
}
