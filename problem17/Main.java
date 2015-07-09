package problem17;

/* ~ ~ ~ QUESTION PROMPT ~ ~ ~
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, 
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total. 
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out 
 * in words, how many letters would be used?
 * 
 *  Notes: this problem gets the right solution, using almost entirely enums
 *  I wrote 4 different enums: 1-9, 10-19, 20-90 (only multiples of ten), and
 *  100 - 900 (only multiples of one hundred).
 *  
 * these enums are cycled through using nested for each loops, and the output
 * is exactly the right sequence.
 */

public class Main {

	private static int sum = 3;

	public static void main(String[] args) {
			
		for(oneHundredToNineHundred n: oneHundredToNineHundred.values()) {
			// subtract 3 because we shouldn't count the "AND" for multiples of 100
			// ex: this program will print: "NINETY-NINE, ONE HUNDRED AND, 
			// ONE HUNDRED AND ONE"
			// This is also the reason sum starts at 3 instead of 0.. this is to handle
			// the case where the hundred's digit = 0, because the program is still 
			// subtracting 3
			sum -= 3;
			
			for(oneToNine num: oneToNine.values()) {
				System.out.println(n + " " + num);
				sum += (n.getValue() + num.getValue());
			}
			for(tenToNineteen num: tenToNineteen.values()) {
				System.out.println(n + " " + num);
				sum += (n.getValue() + num.getValue());
			}
		
			for(twentyToNinety num: twentyToNinety.values()) {
				for(oneToNine num1: oneToNine.values()) {
						System.out.println(n + " " + num + "-" + num1);
							sum += (n.getValue() + num.getValue() + num1.getValue());
					}
			}
			System.out.println("Sum = " + sum);
		}
		System.out.println("One Thousand (11)");
		sum += 11;
		System.out.println("Sum = " + sum);
	}

}
