package com.practiceTest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetData {

	public static void main(String[] args) {
	Date date=new Date();
	SimpleDateFormat sdate=new SimpleDateFormat();
	String datee = sdate.format(date);
	System.out.println(datee);

	}

}
