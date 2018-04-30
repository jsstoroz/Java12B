/*
Name: Jennifer Storozum
Email: jstorozum@brandeis.edu
Date: 7/23/2017
PA 2 - This class creates a ticket object. 
Bugs: None.
*/
public class RegularTicket {
	//fields
	private int number;
	
	//constructor makes new ticket with a number
	public RegularTicket(int number){
		this.number = number;
	}

	//getPrice gets price at 40
	public double getPrice(){
		return 40;
	}
	
	//print prints the number and price of the ticket
	public String print(){
		String str = "Ticket number = " + number + " and price = " + getPrice();
		System.out.println(str); 
		return str;
	}
}
