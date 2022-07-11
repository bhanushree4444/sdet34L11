package com.PracticeJAVA;

public class SwapWords {

	public static void main(String[] args) {
	String a="bhanuuu";
	String b="shree";
	a=a+b;
	
	System.out.println(a);
	b=a.substring(0,(a.length()-b.length()));
	a=a.substring(b.length());
	System.out.println(a);
	System.out.println(b);
	String c="Bhanuuu shree";
	String d = c.replace(" ", "");
	System.out.println(d.length()+" "+ d);
	}

}
