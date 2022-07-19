package com.practiceTest;

public class BlocksGlobalVariables {
	int a=2;
	int b= 2;
	int c=a+b;
	{
		System.out.println(c+" "+"IIB");
	}
	static {
		System.out.println("SIB");
	}
	  {
		System.out.println("IIB");
	}
	
	BlocksGlobalVariables(){
		System.out.println("constructor");
	}
	public static void main(String[] args) {
		System.out.println("main method");

  BlocksGlobalVariables g = new BlocksGlobalVariables();
System.out.println("main ends");
	}

}
