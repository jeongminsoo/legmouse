package com.lec.ex3_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Ex03_Iterator {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("STR1");
		list.add("STR2");
		System.out.println(list);
		
		Iterator<String> iter1 = list.iterator();
		
		while (iter1.hasNext()) {
			System.out.println(iter1.next());
		}
		
		for (String st : list) {
			System.out.println(st);
		}
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("홍길동", "010-9999-9999");
		map.put("신길동", "010-9999-8888");
		
		Iterator<String> iter2 = map.keySet().iterator();
		
		while (iter2.hasNext()) {
			String key = iter2.next();
			System.out.println(key + "키의 데이터 : " + map.get(key));
		}
		
		HashSet<String> set = new HashSet<String>();
		
		set.add("str0");
		set.add("str1");
		set.add("str1");
		
		Iterator<String> iter3 = set.iterator();
		
		while (iter3.hasNext()) {
			System.out.println(iter3.next());
		}
	}
}
