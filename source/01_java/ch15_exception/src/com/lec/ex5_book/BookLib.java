package com.lec.ex5_book;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookLib implements ILendable {

	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private Date checkOutDate;
	private byte state;
	
	public BookLib(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
	}
	
	@Override
	public void checkOut(String borrower) throws Exception {
		if (state == STATE_BORROWED) {
			throw new Exception(bookTitle + "������ �ڴ����ߡ��Դϴ�");
		}
		this.borrower = borrower;
		checkOutDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��(E)");
		state = STATE_BORROWED;
		System.out.printf("\"%s\"��(��) �ڴ���ڵǾ����ϴ�\n[������]%s\n[������]%s\n", bookTitle, borrower, sdf.format(checkOutDate));
		
	}

	@Override
	public void checkIn() throws Exception {
		if (state == STATE_NORMAL) {
			throw new Exception(bookTitle + "������ �������� �ƴմϴ�");
		}
		Scanner sc = new Scanner(System.in);
		String answer;
		Date now = new Date();
		long diff = now.getTime() - checkOutDate.getTime();
		long day = diff / (1000*60*60*24);
		if (day > 14) {
			System.out.print("��ü�ᰡ " + (day * 100) + "���� �߻��Ͽ����ϴ�. ��ü�Ḧ �����Ͽ����ϱ�? (Y/N)");
			answer = sc.next();
			if (answer.equalsIgnoreCase("y")) {
				state = STATE_NORMAL;
				borrower = null;
				checkOutDate = null;
				System.out.println("��ü�Ḧ �����Ͽ� �ݳ��� �Ϸ�Ǿ����ϴ�");
			} else {
				System.out.println("��ü�Ḧ �����ؾ� �ݳ��� �����մϴ�.");
				return;
			}
		} else {
			System.out.println(bookTitle + "��(��) �ݳ��� �Ϸ�Ǿ����ϴ�.");
		}
	}

	@Override
	public String toString() {
		String msg = "[å��ȣ]" + bookNo + " [å�̸�]" + bookTitle + " [����]" + writer + " ";
		msg += (state == STATE_BORROWED) ? "������" : "���Ⱑ��";
		if (state == STATE_BORROWED) {
//			Date that = new Date(checkOutDate.getTime() + 14 * (1000 * 60 * 60 * 24));
			SimpleDateFormat sdf = new SimpleDateFormat("(������ : yyyy-M-d(E))");
			msg += sdf.format(checkOutDate);
		}
		return msg;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	
}
