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
			System.out.println(bookTitle + "������ �������Դϴ�.");
			return;
		} else {
			this.borrower = borrower;
			this.checkOutDate = checkOutDate;
			state = STATE_BORROWED;
			System.out.println(bookTitle + "������ ���� ó���Ǿ����ϴ�.");
			System.out.println("������ : " + borrower + "\t������ : " + checkOutDate);
		}
		
	}

	@Override
	public void checkIn() {
		if (state ==  STATE_NORMAL) {
			System.out.println(bookTitle + "������ �ݳ��Ϸ�� å�ε� �̻��մϴ�. ���ܴ�");
			return;
		}
		borrower = null;
		checkOutDate = null;
		state = STATE_NORMAL;
		System.out.println(bookTitle + "������ �ݳ� �Ϸ�Ǿ����ϴ�.");
		
	}

	@Override
	public void printState() {
		if (state == STATE_NORMAL) {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + "����) ���Ⱑ��");
		} else if (state == STATE_BORROWED) {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + "����) ������");
		} else {
			System.out.println(bookNo + "\t" + bookTitle + "(" + writer + "����) �̻���");
		}
//		String msg = bookNo + "\t" + bookTitle + "(" + writer + "����)";
//		msg = msg + ((state == STATE_NORMAL) ? "���Ⱑ��" : "������");
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
