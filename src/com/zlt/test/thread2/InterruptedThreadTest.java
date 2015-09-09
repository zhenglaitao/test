package com.zlt.test.thread2;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class InterruptedThreadTest implements Runnable{

	private String initPath;
	private String fileName;
	
	public InterruptedThreadTest(String initPath, String fileName) {
		this.initPath = initPath;
		this.fileName = fileName;
	}



	@Override
	public void run(){
		// TODO Auto-generated method stub
		File file = new File(initPath);
		if(!file.exists()){
			file.getParentFile().mkdirs();
		}
		
		if(file.isDirectory()){
			try {
				directoryFile(file);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Thread InterruptedException");
			}
		}
	}



	private void directoryFile(File file) throws InterruptedException {
		// TODO Auto-generated method stub
		File[] files = file.listFiles();
		for (File file2 : files) {
			if(file2.isDirectory()){
				directoryFile(file2);
			}else{
				fileMatch(file2);
			}
		}
		
		if(Thread.interrupted()){
			throw new InterruptedException();
		}
	}



	private void fileMatch(File file2) throws InterruptedException {
		// TODO Auto-generated method stub
		if(file2.getName().equals(fileName)){
			System.out.println(Thread.currentThread().getName()+"----"+file2.getAbsolutePath());
		}
		
		if(Thread.interrupted()){
			throw new InterruptedException();
		}
	}
	
	public static void main(String[] args) {
		InterruptedThreadTest test = new InterruptedThreadTest("d:\\", "hello.txt");
		Thread thread = new Thread(test);
		thread.start();
		System.out.println(new Date().getTime());
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		thread.interrupt();
		System.out.println(new Date().getTime());
	}
}
