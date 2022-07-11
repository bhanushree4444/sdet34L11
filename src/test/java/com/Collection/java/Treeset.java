package com.Collection.java;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Treeset {

	public static void main(String[] args) {
		TreeSet<Object> hs=new TreeSet<>();
		hs.add(10);
		hs.add(20);
		hs.add(10);
		hs.add(25);
	
		System.out.println(hs);
		Iterator<Object> i=hs.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}

	}

}
