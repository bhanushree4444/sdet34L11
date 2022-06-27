package com.PracticeJAVA;

public class PrintCountOfNNumbersInString {
public static void main(String[] args) {
	String s="a5$5b8c";
	int sum=0;
	for (int i = 0; i < s.length(); i++) {
		if(s.charAt(i)>='0'&&s.charAt(i)<='9') {
			int num=s.charAt(i)-48;
			
			sum=sum+num;
			System.out.println(s.charAt(i));
			
		}
	}
	System.out.println("sum is-->"+sum);
}
}
