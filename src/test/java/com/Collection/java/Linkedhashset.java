package com.Collection.java;

import java.util.Iterator;
import java.util.LinkedHashSet;


public class Linkedhashset {

	public static void main(String[] args) {
		LinkedHashSet<Object> hs=new LinkedHashSet<>();
		hs.add(10);
		hs.add("hi");
		hs.add(10);
		hs.add('h');
		hs.add(null);
		hs.add(null);
		System.out.println(hs);
		Iterator<Object> i=hs.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}

	}

}
