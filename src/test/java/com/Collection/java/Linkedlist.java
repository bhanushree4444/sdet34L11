package com.Collection.java;

import java.util.LinkedList;

import org.apache.poi.util.LittleEndianByteArrayOutputStream;

public class Linkedlist {

	public static void main(String[] args) {
		LinkedList<Object> llist=new LinkedList<>();
		llist.add(10);
		llist.add('a');
		llist.add("hi");
		System.out.println(llist);
		llist.addFirst("hello");
		System.out.println(llist);
		llist.addLast("bbye");
System.out.println(llist);
System.out.println(llist.getFirst());
System.out.println(llist.getLast());


	}

}
