package com.zlt.test.list;

import java.util.ArrayList;

public class TestList {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList let=new ArrayList(); 
		let.add("p"); 
		let.add(0, "r"); 
		let.add("e");  
		System.out.println(let.indexOf("p")); //1
		let.remove(1);  
		System.out.println(let.get(1));  
		System.out.println(let.contains("r")); 
		System.out.println(let.contains("p")); 
	}
}
