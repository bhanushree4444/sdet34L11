package com.PracticeJAVA;

public class ReverseStringUsingThirdVariable {

	public static void main(String[] args) {
		String a="india";
		 
		String rev="";
		for(int i=a.length()-1;i>=0;i--) {
			rev=rev+a.charAt(i);
		}
		System.out.println(rev);
	}

}
