package com.zlt.test.file;

import java.io.File;
import java.io.IOException;

public class FileExist {
	public static void main(String[] args) {
		File fiel = new File("d:/zlt/hello.txt");
		if(!fiel.exists()){
			fiel.getParentFile().mkdirs();
			try {
				fiel.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
