package com.PracticeJAVA;

public class PrintOvelsinWord {

	public static void main(String[] args) {
		String s="accurence";
		for(int i=0;i<s.length();i++) {
			Character ch=s.charAt(i);
			if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
				System.out.println(ch);
			}
		}

	}

}
