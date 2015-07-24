package problem19;

public class MyDate {
	
	private String myDayOfWeek;
	private String myMonth;
	private int myDayOfMonth;
	private int myYear;
	
	public MyDate(int wkday, int mnth, int mnthday, int yr) {
		myDayOfWeek = dayToString(wkday);
		myMonth = monthToString(mnth);
		myDayOfMonth = mnthday;
		myYear = yr;
	}
	
	private String dayToString(int w) {	
		switch(w) {
		case 1:
			return "Monday";
		case 2:
			return "Tuesday";
		case 3:
			return "Wednesday";
		case 4:
			return "Thursday";
		case 5:
			return "Friday";
		case 6:
			return "Saturday";
		case 7:
			return "Sunday";
		default:
			return null;
		}
	}
	
	private String monthToString(int m) {
		switch(m) {
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:	
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			return null;
		}
	}
	
	public String toString() {
		return myDayOfWeek + ", " + myMonth + " " + myDayOfMonth + ", " + myYear;
	}
}
