package com.Collection.java;

import java.util.LinkedHashMap;

public class LinkedhashmapPgm {
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> map=new LinkedHashMap<>();
		map.put(2, "hi");
		map.put(5, "hi");
		map.put(8, "hello");
		map.put(1, null);
		map.put(null, null);
		map.put(null, null);
		System.out.println(map);
		map.remove(5);
		System.out.println(map);
		
			

		}
}
