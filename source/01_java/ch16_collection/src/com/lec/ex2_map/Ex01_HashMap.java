package com.lec.ex2_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Ex01_HashMap {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("aaa");
		System.out.println(list.get(0));
		
		HashMap<Integer, String> hash = new HashMap<Integer, String>();
		
		hash.put(11, "str11");
		hash.put(20, "str20");
		hash.put(33, "str33");
		System.out.println(hash.get(20));
		System.out.println("remove 전 : " + hash);
		hash.remove(20);
		System.out.println("remove 후 : " + hash);
		hash.clear();
		System.out.println(hash.isEmpty() ? "데이터 모두 삭제" : "데이터 있음");
		hash.put(0, "홍길동");
		hash.put(10, "김길동");
		hash.put(22, "이순신");
		hash.put(40, "김유신");
		System.out.println(hash);
		
		Iterator<Integer> iter = hash.keySet().iterator();
		
		while (iter.hasNext()) {
			Integer key = iter.next();
			System.out.println(key + "의 데이터는 " + hash.get(key));
		}
	}
}
