package com.lec.ex5_book;

import java.util.Date;

public class TestMain {

	public static void main(String[] args) {
		
		BookLib book = new BookLib("89a¤¡-01", "java", "È«±æµ¿");
		BookLib book1 = new BookLib("89a¤¡-02", "DBMS", "ÀÌµðºñ");
		System.out.println(book);
		System.out.println(book1);
		
		try {
			book.checkOut("È«¼®Ãµ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		book.setCheckOutDate(new Date(122, 2, 11));
		try {
			book.checkIn();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(book);
	}
}
