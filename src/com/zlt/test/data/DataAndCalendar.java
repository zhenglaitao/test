package com.zlt.test.data;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataAndCalendar {
	
	
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		
		System.out.println(d.getTime());
		System.out.println(d.getYear());
		System.out.println("---------------------");
		
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal);
		System.out.println(cal.getTime());
		System.out.println(cal.get(Calendar.YEAR));
		
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		  format.setLenient(false);
		  //Òª×ª»»×Ö·û´® str_test
		  String str_test ="2011-04-24"; 
		  try {
		   Timestamp ts = new Timestamp(format.parse(str_test).getTime());
		   System.out.println(ts.toString()+"------");
		   System.out.println(ts+"------");
		  } catch (ParseException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
	}
}
