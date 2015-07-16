// This code also solves problem 10, using "Sieve of Atkin" method
// for finding quadratic primes. Runs in ~ 1 second when limit = 2,000,000

import java.util.Arrays;

public class Problem10Sieve {

	private static long startTime = System.nanoTime();
	public static int limit = 2000000;
	private static boolean[] sieve = new boolean[limit+1];
	private static int limitSqrt = (int)Math.sqrt((double)limit);
	private static long sum = 0;
	
	
	public static void main(String[] args) {
		
		Arrays.fill(sieve, false);
		sieve[0] = false;
		sieve[1] = false;
		sieve[2] = true;
		sieve[3] = true;

		for(int x = 1; x <= limitSqrt; x++) {
			for (int y = 1; y <= limitSqrt; y++) {
				int n = (4 * x * x) + (y * y);
				if (n <= limit && (n % 12 == 1 || n % 12 ==5)) {
					sieve[n] = !sieve[n];
				}
				n = (3 * x * x) + (y * y);
				if (n <= limit && (n % 12 == 7)) {
					sieve[n] = !sieve[n];
				}
				n = (3 * x * x) - (y * y);
				if ( x > y && n <= limit && (n % 12 == 11)) {
					sieve[n] = !sieve[n];
				}
			}
		}
		
		for(int n = 5; n <= limitSqrt; n++) {
			if (sieve[n]) {
				int x = n * n;
				for (int i = x; i <= limit; i += x) {
					sieve[i] = false;
				}
			}
		}
		
		/*put results to system.out in 10X0 blocks
		for (int i = 0, j = 0; i <= limit; i++) {
			if (sieve[i]) {
				sum += i;
				System.out.printf("%,2d ", i);
				if (++j % 10 == 0) {
					System.out.println();
				}
				if (j % 100 == 0) {
					System.out.println();
				}
			}
		}*/
		
		System.out.println("\n\nSum is: " + sum);
		long endTime = System.nanoTime();
		System.out.println("\nTook "+ ((endTime - startTime) / 1000000000.0) + " seconds");
	}

}
