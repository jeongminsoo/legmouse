package com.lec.ex3_set;

import java.util.HashSet;
import java.util.Iterator;

public class Ex01_HashSet {

	public static void main(String[] args) {
		
		HashSet<String> hash = new HashSet<String>();
		
		hash.add("str0");
		hash.add("str1");
		System.out.println(hash);
		hash.add("str1");
		System.out.println(hash);
		
		Iterator<String> iter = hash.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
