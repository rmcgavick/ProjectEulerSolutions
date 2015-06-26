/* 
 * ~~~ Problem 14 - Longest Collatz Sequence ~~~
 * 
The following iterative sequence is defined for the set of positive integers:

n - n/2 (n is even)
n - 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:
13 - 40 - 20 - 10 - 5 - 16 - 8 - 4 - 2 - 1

It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
 */

// My notes: This program works, and very fast, but apparently doesn't find the right answer.
// The solution this program finds is that the number 910107 produces the longest chain, which
// is 476 numbers long. This number seems too low...

public class Problem14 {

	static int solution = 0;
	static int longestSequence = 0;
	static long startTime = System.nanoTime();
	
	public static int findLongestSequence() {
		int currentNum = 0;
		int longestSequence = 0;
		
		for(int i = 2; i < 1000001; i++) {
			int sequenceLength = 1;
			currentNum = i;
			//System.out.println("i = " + i + ":");
			while(currentNum > 1) {
				//System.out.print(currentNum + " ");
				currentNum = collatzSequence(currentNum);
				sequenceLength++;
			}
			//System.out.println("1\nsequence length: " + sequenceLength + "\n");
			if(sequenceLength > longestSequence) {
				longestSequence = sequenceLength;
				solution = i;
			}
		}
		return longestSequence;
	}
	
	public static int collatzSequence(int n) {
		if (n == 1)
			return 1;
		else if (n % 2 == 0)
			return (n/2);
		else
			return (3*n + 1);
	}
	
	public static void main(String[] args) {
		longestSequence = findLongestSequence();
		System.out.println("Starting number that produces the longest chain is " + solution + ", \nwith a sequence length of " + longestSequence);
		
		long endTime = System.nanoTime();
		System.out.println("\nTook "+ ((endTime - startTime) / 1000000000.0) + " seconds");
	}
}
