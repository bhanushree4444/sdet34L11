package com.PracticeJAVA;

public class PrintWordOfStringInreverseOrder {

	public static void main(String[] args) {
		String s="wellcome to india india";
		String[] str = s.split(" ");
		for(int i=str.length-1;i>=0;i--) {
			System.out.print(str[i]+" ");
		}
	}

}
 