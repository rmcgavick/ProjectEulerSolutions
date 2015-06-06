// This program finds the largest palindrome that is the product of two 4-digit numbers;
// Can scale to larger digits by changing the parameters in the two for loops in findLargestPalindrome() method

public class LargestPalindrome {
	
	static int temp = 0;
	static int solution = 0;
	static int solutionArr[] = {0, 0};
	
	private static boolean isPalindrome(int a, int b) {
		boolean isPal = true;
		String c = "" + (a * b);
		int len = c.length();
		int i = 0;
		
		while (i <= len) {
			if(c.charAt(i) != c.charAt(len-1)) {
				isPal = false;
				break;
			} else {
				i++;
				len--;
			}
		}
		return isPal;
	}
	
	public static int[] findLargestPalindrome() {
		for(int i = 999; i > 99; i--) {
			for(int j = 999; j > 99; j--) {
				if(isPalindrome(i, j)) {
					temp = i * j;
					System.out.println("Possible solution: " + temp);
					if (temp > solution) {
						solution = temp;
						solutionArr[0] = i;
						solutionArr[1] = j;
						System.out.println("Possible solution: " + solutionArr[0] + " * " + solutionArr[1] + " = " + solution);
					}
				}
			}
		}
		return solutionArr;
	}
	
	public static void main(String[] args) {
		
		int answerArr[] = findLargestPalindrome();
		int answer = (answerArr[0] * answerArr[1]);
		System.out.println("The largest palindrome made from the product of two 3-digit numbers is: " + '\n' + answerArr[0] + " * " + answerArr[1] + " = " + answer);
		
	}

}
