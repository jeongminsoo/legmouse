package com.lec.ex1_list;

import java.util.ArrayList;

public class Ex01_ArrayList {

	public static void main(String[] args) {
		
		String[] array = new String[4];
		
		array[0] = "str0";
		array[1] = "str1";
		array[3] = "str3";
		
		for(int i = 0; i < array.length; i++) {
			System.out.printf("array[%d] = %s\t", i, array[i]);
		}
		
		System.out.println();
		
		for(String s : array) {
			System.out.print(s + "\t");
		
		}
		System.out.println();
		System.out.println("---------------------------");
		
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("str0");
		arrayList.add("str1");
		arrayList.add("str2");
		System.out.println(arrayList);
		
		arrayList.add(1, "str11111111111111");
		System.out.println(arrayList);
		arrayList.set(1, "11111");
		System.out.println(arrayList);
		
		for(String st : arrayList) {
			System.out.print(st+ "\t");
		}
		System.out.println();
		
		System.out.println("- remove한 후에 -");
		arrayList.remove(1);
		System.out.println(arrayList);
		arrayList.remove(arrayList.size()-1);
		for (int i = 0; i < arrayList.size(); i++) {
			System.out.printf("%d번째 인덱스 값은 %s\t", i, arrayList.get(i));
		}
		System.out.println();
		arrayList.clear();
		if (arrayList.size() == 0) {
			System.out.println("arrayList의 데이터는 없습니다");
		}
		if(arrayList.isEmpty()) {
			System.out.println("arrayList의 데이터는 없습니다");
		}
		System.out.println(arrayList);
		
		arrayList = null;
	}
}
