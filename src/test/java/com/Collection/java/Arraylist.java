package com.Collection.java;

import java.util.ArrayList;

public class Arraylist {

	public static void main(String[] args) {
	ArrayList<Object> list=new ArrayList<>();
	list.add(10);
	list.add('a');
	list.add("hi");
	ArrayList<Object> list2=new ArrayList<>();
	list2.addAll(list);
	System.out.println(list2);
	System.out.println(list);
	list2.add(2, "hello");
	System.out.println(list2);
	if(list2.contains('a')) {
		System.out.println("present");
	}else {
		System.out.println("not present");
	}
//list2.remove(1); // removes the perticular index value
//System.out.println(list2);
//list2.removeAll(list);// removes all common values
//System.out.println(list2);
	list2.retainAll(list);
	System.out.println(list2 );
	

	}

}
