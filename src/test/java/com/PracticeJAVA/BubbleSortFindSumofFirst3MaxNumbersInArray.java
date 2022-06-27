package com.PracticeJAVA;

public class BubbleSortFindSumofFirst3MaxNumbersInArray {
	public static void main(String[] args) {
	
int arr[]= {30,50,40,10,20} ;
for(int i=0;i<arr.length;i++) {
	for(int j=i;j<arr.length;j++) {
	if(arr[i]<arr[j]) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
}
int sum=0;
for(int i=0;i<3;i++) {
	sum=sum+arr[i];
	System.out.println(arr[i]);
}
System.out.println("sum of first 3 max numbers is----> "+sum);
	}
}

