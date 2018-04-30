/*
Name: Jennifer Storozum
Email: jstorozum@brandeis.edu
Date: 7/23/2017
PA 2 - This class creates a new type of ticket called student advance ticket. 
Bugs: None.
*/
public class StudentAdvanceTicket extends AdvanceTicket{

	//constructor makes a new ticket with a number and indicates how many days in advance it was purchased
	public StudentAdvanceTicket(int number, int daysInAdvance) {
		super(number, daysInAdvance);
	}
	
	//getPrice calls the method in the superclass and returns half off prices
	public double getPrice(){
		return super.getPrice() / 2;
	}
	
	//print prints the relevant information about student advance tickets
	public String print(){
		super.print();
		String str = "  Requires Student ID to purchase";
		System.out.println(str);
		return str;
	}

}
