package com.Collection.java;

import java.util.HashSet;

public class Hashset {

	public static void main(String[] args) {
HashSet<Object> hs=new HashSet<>();
hs.add(10);
hs.add("hi");
hs.add(10);
hs.add('h');
hs.add(null);
hs.add(null);
System.out.println(hs);

	}

}
