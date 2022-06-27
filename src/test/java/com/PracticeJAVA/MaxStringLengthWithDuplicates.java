package com.PracticeJAVA;

public class MaxStringLengthWithDuplicates {

	public static void main(String[] args) {
		String arr[]={"hiiiii", "hello", "byeeee" ,"oyeeee"};
		String max=arr[0];
		for(int i=1;i<arr.length;i++) { 
			if(arr[i].length()>max.length()) {
				max=arr[i];
			}
		}
		for(int i=0;i<arr.length;i++) {
			if(max.length()==arr[i].length()) {
				System.out.println(arr[i]);
			}
		}

	}

}
