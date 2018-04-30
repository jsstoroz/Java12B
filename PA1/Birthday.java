/*
Name: Jennifer Storozum
Email: jstorozum@brandeis.edu
Date: 7/17/2017
PA 1 - This program uses the TeacherDate class. It asks a user for their birthday and calculates the day of the week they were 
born on, if that year was a leap year, if today is their birthday, how old they are in years and
how old they are in days.
Bugs: None.
*/

import java.util.*;

public class Birthday {
	private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What month, day and year were you born?");
		int month = input.nextInt();
		int day = input.nextInt();
		int year = input.nextInt();
		
		TeacherDate birthday = new TeacherDate(year, month, day);
		TeacherDate today = new TeacherDate();
		
		System.out.println("You were born on " + birthday.toString() + ", which was a " + birthday.getDayOfWeek() + ".");
		if(birthday.isLeapYear()){
			System.out.println(birthday.getYear() + " was a leap year.");
		}
		if(isBirthday(today, birthday)){ 
			System.out.println("Happy Birthday! You are now age " + getAge(today, birthday));
		} else {
			System.out.println("It will be your birthday in " + daysToBirthday(today, birthday) + " days.");
		}
		System.out.println("You are " + daysOld(today, birthday) + " days old.");	
	}
	
	//isBirthday takes two TeacherDate objects as parameters and returns true if today is
	//the user's birthday and false otherwise.
	public static boolean isBirthday(TeacherDate date, TeacherDate birthday){
		//it's the user's birthday if the birthday month and day are the same as
		//today's month and day
		if(birthday.getMonth() == date.getMonth() && birthday.getDay() == date.getDay()){
			return true;
		} else return false;
	}
	
	//daysOld takes two TeacherDate objects as parameters and returns how old the person is
	//in days, an integer
	public static int daysOld(TeacherDate today, TeacherDate birthday){
		int days = 0;
		//count the number of days from their birthday to today's date
		while(!(birthday.equals(today))){
			birthday.nextDay();
			days++;
		}
		return days;
	}
	
	//getAge takes two TeacherDate objects as parameters and returns how old the user is in years, an integer
	public static int getAge(TeacherDate date, TeacherDate birthday){
		return date.getYear() - birthday.getYear();
	}
	
	//daysToBirthday takes two TeacherDate objects as parameters and returns an integer that represents
	//the number of days remaining until the user's next birthday
	public static int daysToBirthday(TeacherDate today, TeacherDate birthday){
		//create a new TeacherDate object nextBirthday to keep track of when the user's next
		//birthday is supposed to occur
		//create a new TeacherDate object that's a copy of today so the today object isn't altered
		TeacherDate nextBirthday;
		TeacherDate day = new TeacherDate(today.getYear(), today.getMonth(), today.getDay());
		
		//check if we need to increment the year of the user's next birthday
		//if the birthday has already passed or is today, the next birthday isn't until next year
		//otherwise the next birthday is the same day and month of the actual birthday but in the current year
		if(birthday.getMonth() < day.getMonth() || (birthday.getMonth() == day.getMonth() && birthday.getDay() < day.getDay())){
			nextBirthday = new TeacherDate(day.getYear() + 1, birthday.getMonth(), birthday.getDay());
		} else {
			nextBirthday = new TeacherDate(day.getYear(), birthday.getMonth(), birthday.getDay());
		}
		
		//count the number of days from today until the nextBirthday
		int count = 0;
		while(!(day.equals(nextBirthday))){
			count++;
			day.nextDay();
		}
		return count;
	}
	
	//daysInMonth takes an int month representing the month of the year and returns
	//an int at the index of the month in the class invariant DAYS_IN_MONTH
	public static int daysInMonth(int month){
		return DAYS_IN_MONTH[month];
	}

	
}
