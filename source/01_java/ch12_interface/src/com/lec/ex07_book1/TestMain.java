package com.lec.ex07_book1;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {
		
		Book[] book = { new Book("890��101-1��", "java", "ȫ�浿"),
						new Book("110��-111-1", "oracle", "�ű浿"),
						new Book("110��-123-2��", "mysql", "���浿"),
						new Book("770��-123-2��", "web", "��浿"),
						new Book("110��-123-2��", "spring", "��浿"),
					  };
		
		Scanner sc = new Scanner(System.in);
		int fn;
		int idx;
		String bTitle, borrower, checkOutDate;

		do {
			System.out.print("1. ���� | 2. �ݳ� | 3. ålist | 0. ����");
			fn = sc.nextInt();
			switch (fn) {
			case 1:
				System.out.print("å �̸��� �Է��ϼ��� : ");
				bTitle = sc.next();
				for (idx = 0; idx < book.length; idx++) {
					if (bTitle.equals(book[idx].getBookTitle())) {
						break;
					}
				}
				if (idx == book.length) {
					System.out.println("�������� ���� �����Դϴ�.");
				} else {
					if (book[idx].getState() == Book.STATE_BORROWED) {
						System.out.println("���� �������� �����Դϴ�.");
					} else {
						System.out.print("������ �̸��� �Է��ϼ��� : ");
						borrower = sc.next();
						System.out.print("�������� �Է��ϼ��� : ");
						checkOutDate = sc.next();
						book[idx].checkOut(borrower, checkOutDate);
					}
				}
				
				break;
			case 2:
				
				break;
			case 3:
				System.out.println("--------------- ����Ʈ ---------------");
				for (Book b : book) {
					b.printState();
				}
				break;
			case 0: 
				System.out.println("���α׷� ����");
				break;
			default :
				System.out.println("�ٽ� �Է����ּ���");
			}
		} while(fn != 0);
//		while(true) {
//			System.out.print("1. ���� | 2. �ݳ� | 3. ålist | 0. ����");
//			fn = sc.nextInt();
//			if (fn == 0) {
//				break;
//			}
//		}
		
	}
}
