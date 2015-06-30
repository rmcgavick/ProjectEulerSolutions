
public class Problem3 {

	public static long findLargestPrimeFactor(long num) {
		long largestPrime = 0;
		
		for(long i = 2; i > 1; i++) {
			if (num / i == 1) {
				largestPrime = num;
				return largestPrime;
			}
			if (num % i == 0) {
				num /= i;
				for(long j = num; j > 0; j--) {
					if(num % j == 0)
						j = 0;
				}
			}
		}
		return largestPrime;
	}
	
	public static void main(String[] args) {
		System.out.println(findLargestPrimeFactor(600851475143L));
	}
	
}
