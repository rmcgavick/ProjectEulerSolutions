// This program finds the sum of the even-valued terms whose values do not
// exceed four million

public class EvenFibSum {
	
	// a method that recursively finds the nth term of the Fibonacci sequence
	// This methd isn't actually used in this program, but still cool
	public static int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		else {
			return fib(n - 1) + fib(n - 2);
		
		}
	}

	public static void main(String[] args) {
		int solution = 0;
		int n = 0;
		int m = 1;
		int x = 0;
		
		System.out.println("0, Solution = 0");
		System.out.println("1, Solution = 0");
		
		while (true) {
			x = n + m;
			if (x > 4000000)
				break;
			System.out.print(x);
			if(x % 2 == 0) 
				solution += x;

			n = m;
			m = x;
			System.out.print(", Solution = " + solution + "\n");
		}
		// The code below uses the fib() method, it's not actually a part of the solution.
		int num = 17;
		System.out.println("The " + num + "th number in the fibonacci sequence is: " + fib(num));
	}

}
