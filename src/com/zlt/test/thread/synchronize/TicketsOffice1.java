package com.zlt.test.thread.synchronize;

public class TicketsOffice1 implements Runnable{

	private Cinema cinema;
	
	public TicketsOffice1(Cinema cinema){
		this.cinema=cinema;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		cinema.sellTickets1(2);
		cinema.sellTickets1(3);
		cinema.sellTickets2(5);
		cinema.sellTickets2(1);
		cinema.returnTickets1(2);
	}

}
