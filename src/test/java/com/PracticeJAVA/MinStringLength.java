package com.PracticeJAVA;

public class MinStringLength {
	public static void main(String[] args) {
		
		String arr[]= {"hii", "hwllo", "abhgb", "abc"};
		String min=arr[0];
		for(int i=1;i<arr.length;i++) { 
			if(arr[i].length()<min.length()) {
				min=arr[i];
			}
		}
		for(int i=0;i<arr.length;i++) {
			if(min.length()==arr[i].length()) {
				System.out.println(arr[i]);
			}
		}

	}
}
