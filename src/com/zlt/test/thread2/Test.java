package com.zlt.test.thread2;

public class Test implements Runnable{

	private int number;
	
	public Test(int number){
		this.number=number;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i< 10;i++){
			System.out.printf("%s: %d * %d = %d\n",Thread.currentThread().getName(),number,i,i*number);
		}
	}
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			Test test = new Test(i);
			Thread thread = new Thread(test);
			thread.start();
		}
	}
}
