package com.PracticeJAVA;

public class Max2NumbersWithotBubbleSort {
	public static void main(String[] args) {
		
	int arr[]= {20,10,50,30,40};
	int max1=arr[0];
	int max2=arr[0];
	for(int i=1;i<arr.length;i++) {
		if(arr[i]> max1) {
			max2=max1;
			max1=arr[i];	
		}
		else
			if(arr[i]>max2) {
				max2=arr[i];
			}
	}
	System.out.println("1 st max value in an array is ---->"+max1 );
	System.out.println("2 nd max value in an array is ---->"+max2 );
	}
}
