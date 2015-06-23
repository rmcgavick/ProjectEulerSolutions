<<<<<<< HEAD
// This prog solves the problem, but takes a long time to do so (~20 minutes)
=======
// This prog solves the problem brute force, but takes a long time to do so (~20 minutes)
>>>>>>> 73bc1fa2f56ca169961cb7c6538b02d0a87cca8c

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Problem10 {

	static List<Integer> primesList = new ArrayList<Integer>();
	static Scanner in = new Scanner(System.in);
	static int n = 0;
	
	public static void findPrimes() {
		System.out.println("Enter number to find the nth prime number: ");
		n = in.nextInt();
		
		for(int i = 2; i < n; i++) {
			for(int j = 2; j<=i; j++) {
				if (j == i) {
					System.out.println(i);
					primesList.add(i);
				} else if (i % j == 0) {
					j=i+1;
				}
					
			}
		}
	}
	
	public static void printPrimesList() {
		long sum = 0L;
		for (long num : primesList) {
			sum += num;
		}
		System.out.println("solution: " + sum);
	}
	
	public static void main(String[] args) {
		findPrimes();
		printPrimesList();
	}

}
