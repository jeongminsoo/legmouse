package com.lec.ex07_book1;

public interface ILendable {

	public byte STATE_BORROWED = 1; // ���� �Ұ���
	public byte STATE_NORMAL = 0;   // ���� ����
	public void checkOut(String borrower, String checkOutDate);
	public void checkIn();
	public void printState();
}
