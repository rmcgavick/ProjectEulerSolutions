package problem19;

/* ~ ~ ~ QUESTION PROMPT  && MY NOTES ~ ~ ~  

You are given the following information, but you may prefer to do some research for yourself.

	1 Jan 1900 was a Monday.
	Thirty days has September,
	April, June and November.
	All the rest have thirty-one,
	Saving February alone,
	Which has twenty-eight, rain or shine.
	And on leap years, twenty-nine.
	A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)? 
 */

/* My notes:
 * 
 * In all of these solutions, I am emphasizing OOP practices and design patterns over
 * brevity. In this case, I know I don't need an array list to store each relevant date,
 * as I could just use a simple int to count all the days, and this would save memory,
 * but I want to practice solving the problem in the true Java fashion: creating
 * and formatting objects and storing them in a collection so that I could access each 
 * individual object later.
 */
import java.util.ArrayList;

public class Problem19 {

	private static ArrayList<MyDate> sundayList;
	
	private static void countSundays() {
		sundayList = new ArrayList<MyDate>();
		
		boolean isLeapYear;
		int  dayOfWeek = 1;
		for(int year = 1900; year <= 2000; year++) {
			/* line below calculates leap year - leap years occur on:
			 * a year evenly divisible by 4
			 * but not on a century
			 * unless it is divisible by 400
			 */
			if(year%4 == 0 && year%100 != 0 && year%400 == 0)
				isLeapYear = true;
			else
				isLeapYear = false;
			
			for(int month = 1; month <= 12; month++) {
				int numDays = calculateDaysOfMonth(month, isLeapYear);
				
				for(int day = 1; day <= numDays; day++) {
					// This will add only Sundays that fall on the first of the month
					// between 1901 and 2000 to the ArrayList (This function starts 
					// counting at the year 1900 )
					if(year >= 1901 && dayOfWeek == 7 && day == 1)
						sundayList.add(new MyDate(dayOfWeek, month, day, year));
					dayOfWeek++;
					if(dayOfWeek > 7)
						dayOfWeek = 1;
				}
			}
		}	
		return;
	}
	
	// method that finds the number of days in a month
	// including leap years
	private static int calculateDaysOfMonth(int val, boolean leap) {		
		switch(val) {
		case 2:
			if(leap == false)
				return 28;
			else
				return 29;
		case 4:
			return 30;
		case 6:
			return 30;
		case 9:
			return 30;
		case 11:
			return 30;
		default:
			return 31;
		}
	}
	
	public static void main(String[] args) {
		
		countSundays();
		System.out.println(sundayList);
		System.out.println(sundayList.size());
	}

}
