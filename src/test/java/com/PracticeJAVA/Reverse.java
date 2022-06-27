package com.PracticeJAVA;

public class Reverse {

	public static void main(String[] args) {
   String s="i am from chitradurga";
   String[] arr = s.split(" ");
  
   for(int i=arr.length-1;i>=0;i--) {
    String ar = revv(arr[i]);
    System.out.print(ar +" "); 
    
	}

}
	public static String revv(String s) {
		 String rev="";
	for(int i=0;i<s.length();i++) {
		 rev=rev+s.charAt(i);
	}
	return rev;
	}
}