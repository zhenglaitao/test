package com.zlt.test.thread.synchronize;

public class TicketsOffice2 implements Runnable{

	private Cinema cinema;
	public TicketsOffice2(Cinema cinema){
		this.cinema= cinema;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		cinema.sellTickets1(2);
		cinema.sellTickets1(10);
		cinema.sellTickets1(1);
		cinema.returnTickets1(2);
		cinema.returnTickets2(7);
	}

}
