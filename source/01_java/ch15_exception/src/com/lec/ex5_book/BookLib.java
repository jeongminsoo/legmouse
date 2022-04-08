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
			throw new Exception(bookTitle + "도서는 ★대출중★입니다");
		}
		this.borrower = borrower;
		checkOutDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E)");
		state = STATE_BORROWED;
		System.out.printf("\"%s\"이(가) ★대출★되었습니다\n[대출인]%s\n[대출일]%s\n", bookTitle, borrower, sdf.format(checkOutDate));
		
	}

	@Override
	public void checkIn() throws Exception {
		if (state == STATE_NORMAL) {
			throw new Exception(bookTitle + "도서는 대출중이 아닙니다");
		}
		Scanner sc = new Scanner(System.in);
		String answer;
		Date now = new Date();
		long diff = now.getTime() - checkOutDate.getTime();
		long day = diff / (1000*60*60*24);
		if (day > 14) {
			System.out.print("연체료가 " + (day * 100) + "원이 발생하였습니다. 연체료를 납부하였습니까? (Y/N)");
			answer = sc.next();
			if (answer.equalsIgnoreCase("y")) {
				state = STATE_NORMAL;
				borrower = null;
				checkOutDate = null;
				System.out.println("연체료를 납부하여 반납이 완료되었습니다");
			} else {
				System.out.println("연체료를 납부해야 반납이 가능합니다.");
				return;
			}
		} else {
			System.out.println(bookTitle + "이(가) 반납이 완료되었습니다.");
		}
	}

	@Override
	public String toString() {
		String msg = "[책번호]" + bookNo + " [책이름]" + bookTitle + " [저자]" + writer + " ";
		msg += (state == STATE_BORROWED) ? "대출중" : "대출가능";
		if (state == STATE_BORROWED) {
//			Date that = new Date(checkOutDate.getTime() + 14 * (1000 * 60 * 60 * 24));
			SimpleDateFormat sdf = new SimpleDateFormat("(대출일 : yyyy-M-d(E))");
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
