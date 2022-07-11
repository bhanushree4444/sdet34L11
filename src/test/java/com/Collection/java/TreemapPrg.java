package com.Collection.java;

import java.util.TreeMap;

public class TreemapPrg {
	public static void main(String[] args) {
		TreeMap<Integer, String> map=new TreeMap<>();
		map.put(2, "hi");
		map.put(5, "hi");
		map.put(8, "hello");
		map.put(1, null);
		//map.put(null, null); // not allowded
		
		System.out.println(map);
		map.remove(5);
		System.out.println(map);
		
			

		}
}
