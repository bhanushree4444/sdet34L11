package com.PracticeJAVA;

import java.util.LinkedHashSet;

public class PrintStringInSentencesIgnoreCases {
	public static void main(String[] args) {
		String str = "katham ta Ta bye Bye";
		String[] arr = str.split(" ");
		LinkedHashSet<String> set=new LinkedHashSet<String>();
		for(int i=0;i<arr.length;i++) {
			set.add(arr[i]);
		}
		
		
		for(String st:set)
		{
			int count=0;
			for(int i=0;i<arr.length;i++) {
				
				if(st.equalsIgnoreCase(arr[i])) {
					count++;
				}
			}
			System.out.println(st+" "+ count);
			
		}
		}
}
