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
		System.out.println("remove �� : " + hash);
		hash.remove(20);
		System.out.println("remove �� : " + hash);
		hash.clear();
		System.out.println(hash.isEmpty() ? "������ ��� ����" : "������ ����");
		hash.put(0, "ȫ�浿");
		hash.put(10, "��浿");
		hash.put(22, "�̼���");
		hash.put(40, "������");
		System.out.println(hash);
		
		Iterator<Integer> iter = hash.keySet().iterator();
		
		while (iter.hasNext()) {
			Integer key = iter.next();
			System.out.println(key + "�� �����ʹ� " + hash.get(key));
		}
	}
}
