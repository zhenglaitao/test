package com.zlt.test.pripropub;

public class Private1 {
	
	private String pri;
	
	protected String pro;
	
	public String pub;

	public String getPri() {
		return pri;
	}

	public void setPri(String pri) {
		this.pri = pri;
	}

	public String getPro() {
		return pro;
	}

	public void setPro(String pro) {
		this.pro = pro;
	}

	public String getPub() {
		return pub;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}
	
	public static void main(String[] args) {
		Private1 test = new Private1();
		test.pri ="1";
	}
}
