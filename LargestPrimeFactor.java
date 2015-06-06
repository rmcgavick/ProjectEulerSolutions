import java.util.ArrayList;
import java.util.List;

// Program that finds the largest prime factor of the number 600851475143
// NOT WORKING

public class LargestPrimeFactor {

	@SuppressWarnings({ "rawtypes" })
	public static void main(String[] args) {
		long n = 2639L;
		long temp = 0L;
		@SuppressWarnings("rawtypes")
		List<Integer> primeFactors = new ArrayList<>();
		
		for(int i = (int)n/2; i > 1; i = i--) {
			System.out.println(i);
			if ( n % i == 0) {
				System.out.println("factor found: " + i);
				primeFactors.add(i);
				
				
				
				//temp = n / i;
				//System.out.println("temp = " + temp);
				
				for(long j = temp; temp > 2; j--) {
					System.out.println(j);
					if ( temp % j == 0 ) {
						temp /= j;
						
					}
					
				}
			}
		}

	}

}
