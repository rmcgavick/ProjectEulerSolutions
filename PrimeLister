// Program that finds the first n prime numbers, and puts them in an int array
import java.util.Scanner;

public class PrimeLister {

	public static void main(String[] args) {
		
		int i = 0;
		int count = 0;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter number to find the nth prime number: ");
		int n = in.nextInt();
		int[] primesFound = new int[n];
		
		// Outer loop executes until count = n; that is, until the nth
		// prime number has been found
		while (count != n) {
			primesFound[count] = i;
			count++;

			// inner loop checks each number i against all it's divisors
			// to see which ones are prime
			for( int j = 2; j < i; j++) {
				
				if( i % j == 0) {
					primesFound[--count] = 0;
					j = i;
				}
			}
			i++;
		}
		printPrimeArray(primesFound);	
	}
	
	public static void printPrimeArray(int[] arr) {
		int len = arr.length;
		System.out.println("Here is the list of primes up to " + len);
		for(int i = 0; i < len; i++) {
			System.out.println("primesFound[" + i + "] = " + arr[i]);
		}
	}
}
