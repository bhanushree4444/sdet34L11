package com.PracticeJAVA;

import java.util.LinkedHashSet;

public class PrintCharacterIndex {
	public static void main(String[] args) {
		String str="india";
		
		LinkedHashSet<Character> set=new LinkedHashSet<Character>();
		for(int i=0;i<str.length();i++) {
			set.add(str.charAt(i));
		}
	
		for(Character ch:set) {
		
			for(int i=0;i<str.length();i++) {
				if(ch==str.charAt(i))
				{
			System.out.println(str.charAt(i)+"="+(i+1));
			break;
		}
	}		
		}
}
}
