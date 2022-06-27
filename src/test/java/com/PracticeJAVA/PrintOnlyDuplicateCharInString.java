package com.PracticeJAVA;

import java.util.LinkedHashSet;

public class PrintOnlyDuplicateCharInString {

	public static void main(String[] args) {
		String s="india";
		LinkedHashSet<Character> set=new LinkedHashSet<Character>();
		for(int i=0;i<s.length();i++) {
			set.add(s.charAt(i));
		}
		for(Character ch:set) {
			int count=0;
			for(int i=0;i<s.length();i++) {
				if(ch==s.charAt(i)) {
					count++;
				}
			}
			if(count>1) {
			System.out.println("number of times character "+ch+" repeated is--->"+count);
		}
			if(count==1) {
				System.out.println("unique characters in a string are "+ch);
			}

	}

	}

}
