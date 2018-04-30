/*
Name: Jennifer Storozum
Email: jstorozum@brandeis.edu
Date: 7/23/2017
PA 2 - This class creates a new type of ticket called advance ticket. 
Bugs: None.
*/
public class AdvanceTicket extends RegularTicket {

	//fields
	protected int daysInAdvance; 
	
	//constructor makes a new ticket with ticket number and how many days in advance it was purchased
	public AdvanceTicket(int number, int daysInAdvance) {
		super(number);
		this.daysInAdvance = daysInAdvance;
	}
	
	//getPrice returns the price based on how many days in advance ticket was purchased
	public double getPrice(){
		if(this.daysInAdvance >= 20){
			return 15;
		} else if(this.daysInAdvance <= 10){
			return super.getPrice();
		} else {
			return 20;
		}
	}
	
	//print prints the relevant information about the advance ticket
	public String print(){
		super.print();
		String str = "  " + daysInAdvance + " days Advance purchase ";
		System.out.println(str);
		return str;
	}

}
