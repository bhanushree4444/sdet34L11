package com.PracticeJAVA;

import java.util.LinkedHashSet;

public class CountWordRepeatedinString {

	public static void main(String[] args) {
		String s="wellcome to india india";
		String[] str = s.split(" ");
		LinkedHashSet<String> set=new LinkedHashSet<String>();
		for(int i=0;i<str.length;i++) {
			set.add(str[i]);
		}
		
		
		
		for(String word:set) {
			int count=0;
			for(int i=0;i<str.length;i++) {
				if(word.equals(str[i])) {
					count++;
				}
			}
			System.out.println("number of times word " +word +" repeated is-->"+count);	
		}

	}

}
