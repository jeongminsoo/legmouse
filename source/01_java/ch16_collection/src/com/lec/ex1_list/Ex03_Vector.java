package com.lec.ex1_list;

import java.util.ArrayList;
import java.util.Vector;

public class Ex03_Vector {

	public static void main(String[] args) {
		
		Vector<Object> vec = new Vector<Object>();
		
		vec.add(10);
		vec.add(new AClass());
		BClass objB = new BClass();
		vec.add(objB);
		System.out.println(vec);
		
		for (Object obj : vec) {
			System.out.println(obj);
		}
		
		for (int i = 0; i < vec.size(); i++) {
			System.out.println(vec.get(i));
		}
		
	}
}
