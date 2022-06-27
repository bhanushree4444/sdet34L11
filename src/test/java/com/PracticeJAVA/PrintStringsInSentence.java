package com.PracticeJAVA;

import java.util.LinkedHashSet;

public class PrintStringsInSentence {
public static void main(String[] args) {
	String str = "welcome to india and to tyss tyss company";
	String[] arr = str.split(" ");
	LinkedHashSet<String> set=new LinkedHashSet<String>();
	for(int i=0;i<arr.length;i++) {
		set.add(arr[i]);
	}
	
	
	for(String st:set)
	{
		for(int i=0;i<arr.length;i++) {
			if(st.equals(arr[i])) {
				System.out.println(st+" "+(i+1));
				break;
			}
		}
		
	}
}
}
