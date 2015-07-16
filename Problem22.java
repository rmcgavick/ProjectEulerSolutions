/* ~ ~ ~ QUESTION PROMPT ~ ~ ~
 * 
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file 
 * containing over five-thousand first names, begin by sorting it into 
 * alphabetical order. Then working out the alphabetical value for each name, 
 * multiply this value by its alphabetical position in the list to obtain a 
 * name score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN, which 
 * is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, 
 * COLIN would obtain a score of 938 × 53 = 49714.
 * 
 * What is the total of all the name scores in the file?
 */

/*
 * This program correctly solves the problem. I wrote 3 methods to solve it.
 * The first method, readFileToArrayList() is just a filereader method. It
 * takes a txt file as input and saves its contents to a String array.
 * 
 * The next method, findSumOfNameScores, sums all the name scores, which are 
 * calculated by the third method, findNameScores.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Problem22 {
	
	static long startTime = System.nanoTime();
	private static String[] namesList;
	
	// This method reads in from a txt file that has names in quotes, separated
	// by commas. This method removes the quotes and commas, saves all the names
	// into a String array, and then alphabetically sorts and returns the array.
	private static String[] readFileToArrayList() throws IOException {
	
		// start by initializing everything to null, because the actual line
		// initialization happens inside a try/catch block
		String[] names = null;
		String line = null;
		BufferedReader textReader = null;
		
		try {
			textReader = new BufferedReader(new FileReader("resources/names.txt"));
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		// go through the bufferedReader and remove the quotes
		// and commas that separate the names. Then, add each
		// split string into the String[] called "names"
		while ((line = textReader.readLine()) != null) {
			names = (line.split("\",\""));
		}

		// The 2 lines below just remove the comma at the beginning of names[0],
		// and the comma at the end of the end of the names array
		names[0] = names[0].substring(1, names[0].length());
		names[names.length-1] = names[names.length-1].substring(0, names[names.length-1].length()-1);
		
		// sort list into alphabetical order
		Arrays.sort(names);
		
		textReader.close();
		return names;
	}
	
	private static long findSumOfNameScores(String[] list) {
		long sum = 0;
		int currentScore = 0;
		
		for (int i=0, count=1; i<list.length; i++, count++) {
			currentScore = ((findNameScore(list[i])) * count);
			sum += currentScore;
		}
		
		return sum;
	}
	
	private static int findNameScore(String name) {
		int score = 0;
		char currentLetter;
		
		for(int i=0; i<name.length(); i++) {
			currentLetter = name.charAt(i);
		
			switch(currentLetter) {
			case 'A': score += 1;
				break;
			case 'B': score += 2;
				break;
			case 'C': score += 3;
				break;
			case 'D': score += 4;
				break;
			case 'E': score += 5;
				break;
			case 'F': score += 6;
				break;
			case 'G': score += 7;
				break;
			case 'H': score += 8;
				break;
			case 'I': score += 9;
				break;
			case 'J': score += 10;
				break;
			case 'K': score += 11;
				break;
			case 'L': score += 12;
				break;
			case 'M': score += 13;
				break;
			case 'N': score += 14;
				break;
			case 'O': score += 15;
				break;
			case 'P': score += 16;
				break;
			case 'Q': score += 17;
				break;
			case 'R': score += 18;
				break;
			case 'S': score += 19;
				break;
			case 'T': score += 20;
				break;
			case 'U': score += 21;
				break;
			case 'V': score += 22;
				break;
			case 'W': score += 23;
				break;
			case 'X': score += 24;
				break;
			case 'Y': score += 25;
				break;
			case 'Z': score += 26;
				break;
			}
		}
		
		return score;
	}
	
	public static void main(String[] args) throws IOException {
		
		namesList = readFileToArrayList();
		
		for (String str : namesList)
			System.out.println(str);
		
		System.out.println("Sum of all name scores of all names in the names.txt: " + findSumOfNameScores(namesList));
		
		long endTime = System.nanoTime();
		System.out.println("\nTook "+ ((endTime - startTime) / 1000000000.0) + " seconds");
	}

}
