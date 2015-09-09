package com.zlt.test.thread2;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ThreadClock implements Runnable{
	
	public void run(){
		
		for(int i =0;i<6;i++){
			System.out.println(new Date());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("InterruptedException---");
			}
		}
		System.out.println("11111");
	}
	public static void main(String[] args) {
		Thread thread = new Thread(new ThreadClock());
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.interrupt();
	}
}
