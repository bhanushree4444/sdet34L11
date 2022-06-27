package com.PracticeJAVA;

public class CharacterprintWithAdding {

	public static void main(String[] args) {
		String s="@1b5o$m5(";
		String alpha="";
		String num="";
		String spl="";
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(ch>='a' && ch<='z'||ch>='A' && ch<='Z') {
				alpha=alpha+s.charAt(i);
			}else
				if(ch>='0'&&ch<='9') {
					num=num+s.charAt(i);
				}else {
					spl=spl+s.charAt(i);
				}
		}
		System.out.println(alpha);
		System.out.println(num);
		System.out.println(spl);
	}

}
