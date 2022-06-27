package com.PracticeJAVA;

import java.util.LinkedHashSet;

public class CountEachNumbersInArray {

	public static void main(String[] args) {
		int s[]= {1,0,1,0,0,1,1,6,8,6};
		LinkedHashSet<Integer> set=new LinkedHashSet<Integer>();
		for(int i=0;i<s.length;i++) {
			set.add(s[i]);
		}
		for(Integer no:set) {
			int count=0;
			for(int j=0;j<=s.length-1;j++) {
				if(no==s[j]) {
					count++;
				}
			}
			System.out.println(no+" --> repeated "+count+" times");
		}
	}

}
