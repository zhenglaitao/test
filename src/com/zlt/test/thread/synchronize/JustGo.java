package com.zlt.test.thread.synchronize;

public class JustGo {
	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		TicketsOffice1 office1 = new TicketsOffice1(cinema);
		Thread thread1 = new Thread(office1, "office1");
		TicketsOffice2 office2 = new TicketsOffice2(cinema);
		Thread thread2 = new Thread(office2, "office2");
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("office1 vacancies :"+cinema.getVacanciesCinema1());
		System.out.println("office2 vacancies :"+cinema.getVacanciesCinema2());
	}
}
