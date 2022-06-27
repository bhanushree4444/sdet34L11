package com.PracticeJAVA;

public class PrintAllPrimeNumbers {

	public static void main(String[] args) {
int arr[]= {1,20,50,4,7,5,11,17,13,15};
for(int i=0;i<arr.length;i++) {
	prime(arr[i]);	
}
	}
	
	public static void prime(int n) {
		int j=2;
		while(n>=j) {
		if(n%j==0) {
			break;
		}
		j++;
	}
		if(n==j){
			System.out.println(n);
		}
	}
}
