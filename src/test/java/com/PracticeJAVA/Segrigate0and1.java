package com.PracticeJAVA;

public class Segrigate0and1 {

	public static void main(String[] args) {
		
		int arr[]= {1,0,1,0,0,1,1};
		for(int i=0;i<=arr.length-1;i++) {
			if(arr[i]==1) {
				System.out.print(arr[i]+" ");
			}
		}
	}

}
