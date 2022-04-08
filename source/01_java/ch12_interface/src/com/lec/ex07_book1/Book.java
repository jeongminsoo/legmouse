package com.lec.ex07_book1;

public class Book implements ILendable {

	private String bookNo;
	private String bookTitle;
	private String writer;
	private String borrower;
	private String checkOutDate;
	private byte state;
	
	public Book() {
	}
	public Book(String bookNo, String bookTitle, String writer) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.writer = writer;
		state = STATE_NORMAL;
	}
	
	@Override
	public void checkOut(String borrower, String checkOutDate) {
		if (state == STATE_BORROWED) {
			System.out.println(bookTitle + "도서는 대출중입니다.");
			return;
		} else {
			this.borrower = borrower;
			this.checkOutDate = checkOutDate;
			state = STATE_BORROWED;
			System.out.println(bookTitle + "도서가 대출 처리되었습니다.");
			System.out.println("대출인 : " + borrower + "\t대출일 : " + checkOutDate);
		}
		
	}

	@Override
	public void checkIn() {
		if (state ==  STATE_NORMAL) {
			System.out.println(bookTitle + "도서는 반납완료된 책인데 이상합니다. 예외다");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + "도서가 반납 완료되었습니다.");
		
	}

	@Override
	public void printState() {
		if (state == STATE_NORMAL) {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + "지음) 대출가능");
		} else if (state == STATE_BORROWED) {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + "지음) 대출중");
		} else {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + "지음) 이상해");
		}
//		String msg = bookNo + "\t" + bookTitle + "(" + writer + "지음)";
//		msg = msg + ((state == STATE_NORMAL) ? "대출가능" : "대출중");
//		System.out.println(msg);
	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public byte getState() {
		return state;
	}
	public void setState(byte state) {
		this.state = state;
	}
	

}
