package com.Collection.java;

import java.util.HashMap;
import java.util.Hashtable;

public class HashtablePgm {

	public static void main(String[] args) {
	Hashtable<Integer, String> map=new Hashtable<>();
	map.put(2, "hi");
	map.put(5, "hi");
	map.put(8, "hello");
	map.put(1, "hi");
	System.out.println(map);
	map.remove(5);
	System.out.println(map);
	
		

	}

}
