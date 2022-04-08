package com.lec.ex07_book1;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		
		Book[] book = { new Book("890ㅁ101-1ㄱ", "java", "홍길동"),
						new Book("110ㄱ-111-1", "oracle", "신길동"),
						new Book("110ㅁ-123-2ㅌ", "mysql", "유길동"),
						new Book("770ㅁ-123-2ㅌ", "web", "고길동"),
						new Book("110ㅁ-123-2ㅌ", "spring", "김길동"),
					  };
		
		Scanner sc = new Scanner(System.in);
		int fn;
		int idx;
		String bTitle, borrower, checkOutDate;

		do {
			System.out.print("1. 대출 | 2. 반납 | 3. 책list | 0. 종료");
			fn = sc.nextInt();
			switch (fn) {
			case 1:
				System.out.print("책 이름을 입력하세요 : ");
				bTitle = sc.next();
				for (idx = 0; idx < book.length; idx++) {
					if (bTitle.equals(book[idx].getBookTitle())) {
						break;
					}
				}
				if (idx == book.length) {
					System.out.println("보유하지 않은 도서입니다.");
				} else {
					if (book[idx].getState() == Book.STATE_BORROWED) {
						System.out.println("현재 대출중인 도서입니다.");
					} else {
						System.out.print("대출자 이름을 입력하세요 : ");
						borrower = sc.next();
						System.out.print("대출일을 입력하세요 : ");
						checkOutDate = sc.next();
						book[idx].checkOut(borrower, checkOutDate);
					}
				}
				
				break;
			case 2:
				
				break;
			case 3:
				System.out.println("--------------- 리스트 ---------------");
				for (Book b : book) {
					b.printState();
				}
				break;
			case 0: 
				System.out.println("프로그램 종료");
				break;
			default :
				System.out.println("다시 입력해주세요");
			}
		} while(fn != 0);
//		while(true) {
//			System.out.print("1. 대출 | 2. 반납 | 3. 책list | 0. 종료");
//			fn = sc.nextInt();
//			if (fn == 0) {
//				break;
//			}
//		}
		
	}
}
