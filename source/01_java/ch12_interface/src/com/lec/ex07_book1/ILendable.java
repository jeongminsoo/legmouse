package com.lec.ex07_book1;

public interface ILendable {

	public byte STATE_BORROWED = 1; // 대출 불가능
	public byte STATE_NORMAL = 0;   // 대출 가능
	public void checkOut(String borrower, String checkOutDate);
	public void checkIn();
	public void printState();
}
