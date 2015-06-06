// This program takes an int (n) from the user and prints every number from n to 0 unless:
// the number is divisible by 3, in which case it prints "Fizz" or
// the number is divisible by 5, in which case it prints "Buzz"
// If the number is divisible by 3 and 5, it will print "FizzBuzz"

import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {		
		System.out.println("Please enter an int to see it's Fizz Buzz results: ");
		fizzBuzz();
	}

	private static void fizzBuzz() {
		Scanner in = new Scanner( System.in );
		int userNum = in.nextInt();
	
		for (int i = userNum; i>0; i--) {
			String output = "";
		
			if(i % 3 == 0)
				output += "Fizz";
			if(i % 5 == 0)
				output += "Buzz";
			if(i % 3 != 0 && i % 5 != 0)
				output += i;
		
			System.out.println(output);
		}
		in.close();
	}
}
