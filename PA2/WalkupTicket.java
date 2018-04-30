/*
Name: Jennifer Storozum
Email: jstorozum@brandeis.edu
Date: 7/23/2017
PA 2 - This class creates a new type of ticket called walkup ticket. 
Bugs: None.
*/
public class WalkupTicket extends RegularTicket{

	//Constructor creates a new ticket with a ticket number
	public WalkupTicket(int number) {
		super(number);
	}
	
	//getPrice overrides and makes the walkup price 50
	@Override
	public double getPrice(){
		return 50;
	}

	//print prints the relevant information about the ticket
	@Override
	public String print(){
		super.print();
		String str = "  Walkup Ticket";
		System.out.println(str);
		return str;		
	}
}
