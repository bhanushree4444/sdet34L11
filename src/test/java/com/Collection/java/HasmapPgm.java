package com.Collection.java;

import java.util.HashMap;

public class HasmapPgm {
	public static void main(String[] args) {
		HashMap<Integer, String> map=new HashMap<>();
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
