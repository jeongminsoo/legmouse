package com.lec.ex;

public class Ex01 {

	public static void main(String[] args) {
		
		int tot = 0;
		
		for (int i = 1 ; i <= 10 ; i++) {
			tot += i;
		}
		System.out.println("1~10���� ������ ���� " + tot + "�Դϴ�.");
		
		String msg;
		if (tot % 2 == 0) {
			msg = "¦���Դϴ�";
		} else {
			msg = "Ȧ���Դϴ�";
		}
		System.out.println(msg);
		
//		System.out.println((tot % 2) == 0 ? "¦���Դϴ�" : "Ȧ���Դϴ�");
	}
}
