package com.lec.ex1_string;

public class Ex11_speedCheck {

	public static void main(String[] args) {
		
		System.out.println(System.currentTimeMillis());
		
		String str = "A";
		long startTime = System.currentTimeMillis();
		for (int i = 0; i<100000; i++)
			str += 'a';
		
		long endTime = System.currentTimeMillis();
		System.out.println("String 10만번 수정 경과 시간 : " + (endTime - startTime));
		
		StringBuffer strBuf = new StringBuffer("A");
		
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			strBuf.append("a");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuffer 10만번 수정 경과 시간 : " + (endTime - startTime));
		
		
		StringBuilder strBuld = new StringBuilder("A");
		
		startTime = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			strBuld.append("a");
		}
		endTime = System.currentTimeMillis();
		System.out.println("StringBuilder 10만번 수정 경과 시간 : " + (endTime - startTime));
	}
}
