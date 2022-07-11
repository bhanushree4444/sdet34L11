package com.Collection.java;

import java.util.Stack;

public class staack {
public static void main(String[] args) {
	Stack<Object> s=new Stack<>();
	s.push(10);
	s.push(20);
	System.out.println(s.pop());
	s.push(50);
	System.out.println(s.pop());
	s.push('h');
	System.out.println(s.pop());
}
}
