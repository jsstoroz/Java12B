/*
Name: Jennifer Storozum
Email: jstorozum@brandeis.edu
Date: 7/17/2017
PA 1 - This program creates date objects and various methods for the object.
Bugs: None.
*/

public class Date {

	//class invariants, names of the days of the week and how many days are in each month (ignoring leap year)
	//first element in DAYS_IN_MONTH is zero as a placeholder
	private static final String[] DAYS_OF_WEEK = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	//fields
	private int year;
	private int month;
	private int day;
	
	//constructor Date takes 3 parameters, year month and day, to create a specific date object
	public Date(int year, int month, int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	//constructor Date takes no parameters to create a date object for today's date
	public Date(){
		this(1970, 1, 1);
		int daysSinceEpoch = TeacherDate.getDaysSinceEpoch();
		for(int i = 0; i < daysSinceEpoch; i++){
			nextDay();
		}
	}
	
	//getDay returns int day, the day of the Date object
	public int getDay(){
		return day;
	}
	
	//getMonth returns int month, the month of the Date object
	public int getMonth(){
		return month;
	}
	
	//getYear returns int year, the year of the Date object
	public int getYear(){
		return year;
	}
	
	//getDayOfWeek returns String of the name of the day of the week for the Date object
	public String getDayOfWeek(){
		//count the number of days from the start Date start until the Date object
		Date start = new Date(1753, 1, 1);
		int dayCount = 0;
		while(!start.equals(this)){
			start.nextDay();
			dayCount += 1;
		}
		//mod 7 will give you the correct index that correlates with the name in the DAYS_OF_WEEK array
		int dayNameIndex = dayCount % 7;
		return DAYS_OF_WEEK[dayNameIndex];
	}
	
	//isLeapYear returns true if the year of the Date object is a leap year and false if it is not a leap year
	public boolean isLeapYear(){
		if ((year % 400 == 0) || (year % 100 != 0 ) && (year % 4 == 0)){
			return true;
		} else return false;
	}
	
	//nextDay advances the Date object by one day
	public void nextDay(){
		day += 1;
		if(day > daysInMonth()){
			month += 1;
			day = 1;
			if(month > 12){
				year += 1;
				month = 1;
			}
		}
	}
	
	//nextDay helper
	//daysInMonth returns int numDays which correlates to the DAYS_IN_MONTH array
	//also accounts for leap years by incrementing the # of days in Feb by 1
	public int daysInMonth(){
		int numDays = DAYS_IN_MONTH[month];
		if(month == 2 && isLeapYear()){
			numDays++;
		}
		return numDays;
	}
	
	//toString returns Date object formatted as a String year/month/day
	public String toString(){
		return year + "/" + month + "/" + day;
	}
	
	//equals takes an Object o as a parameter and assesses if two date objects are identical
	//two date objects are identical if all their fields are identical
	//if the two dates are the same, method returns true. if they're not, method returns false
	public boolean equals(Object o){
		if(o instanceof Date){
			Date other = (Date) o;
			return (other.day == day && other.month == month && other.year == year);
		} else return false;
	}
}
