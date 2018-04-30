/*
Name: Jennifer Storozum
Email: jstorozum@brandeis.edu
Date: 7/23/2017
PA 2 - This is the driver class for the ticket problem. 
Bugs: None.
*/
public class TestTicket {

	//Main method starts the ticket count at 1, initializes a new array of tickets, 
	//populates the array, prints the array, and prints the profits
	public static void main(String[] args) {
		int ticketNo = 1;
		RegularTicket[] ticketArray = new RegularTicket[15];
		storeTickets(ticketNo, ticketArray);
		
		for(int i = 0; i < ticketArray.length; i++){
			ticketArray[i].print();
		}
		
		System.out.println("Total profit: " + getProfit(ticketArray));
	}

	//getProfit takes a ticket array and calculates the profit made from ticket sales
	public static double getProfit(RegularTicket[] ticketArray){
		double totalProfit = 0;
		for(int i = 0; i < ticketArray.length; i++){
			totalProfit += ticketArray[i].getPrice();
		}
		return totalProfit;
	}
	
	//storeTickets populates a ticketArray with tickets and their numbers
	public static RegularTicket[] storeTickets(int ticketNo, RegularTicket[] ticketArray){
		int[] day = {3, 15, 30};
		
		for(int i = 0; i < ticketArray.length; i++){
			if(i < 3 || i > 10){
				ticketArray[i] = new RegularTicket(ticketNo);
				ticketNo++;
			}
			else if(i >= 3 && i < 5){
				ticketArray[i] = new WalkupTicket(ticketNo);
				ticketNo++;
			} else if(i > 4 && i < 8){
				ticketArray[i] = new AdvanceTicket(ticketNo, 30);
				ticketNo++;
			}else if(i == 6){
				ticketArray[i] = new AdvanceTicket(ticketNo, 15);
				ticketNo++;
			}else if(i ==7){
				ticketArray[i] = new AdvanceTicket(ticketNo, 3);
				ticketNo++;
			}else if(i ==8){
				ticketArray[i] = new StudentAdvanceTicket(ticketNo, 30);
				ticketNo++;
			}else if(i ==9){
				ticketArray[i] = new StudentAdvanceTicket(ticketNo, 15);
				ticketNo++;
			}else if(i ==10){
				ticketArray[i] = new StudentAdvanceTicket(ticketNo, 3);
				ticketNo++;
			} 
		}
		return ticketArray;
	}
}
