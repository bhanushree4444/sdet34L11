package com.PracticeJAVA;

import java.util.Arrays;

public class AnagramProgram {

	public static void main(String[] args) {
		
		String s="Ammaaa";
		String s1="Mama";
		
		//convert to to char array and to lower case
		char[] a1 = s.toLowerCase().toCharArray();
		char[] a2 = s1.toLowerCase().toCharArray();
		
		// sort the array
		Arrays.sort(a1);
		Arrays.sort(a2);

	// compare the arrays
	if(Arrays.equals(a1, a2)) {
	System.out.println("anagram");
	}
	else 
	{
	System.out.println("not-anagram");
	}
  }
}
