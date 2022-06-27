package com.PracticeJAVA;

public class ReverseStringWithoutCharatAndLength {

	public static void main(String[] args) {
		String s="india";
		char[] ch = s.toCharArray();
		String rev="";
for(char c:ch) {
	rev=c+rev ;
}
System.out.println(rev);
	}

}
