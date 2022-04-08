package com.lec.ex5_atm;

public class ATM {

	private int balance;

	public ATM(int balance) {
		this.balance = balance;
	}

	public synchronized void deposit(int money, String who) {
		System.out.println(who + "가 입금 시작");
		balance += money;
		System.out.println(who + "가 " + money + "원 입금했습니다. 잔액 : " + balance);
		System.out.println(who + "가 입금 종료");
	}

	public synchronized void withdraw(int money, String who) {
		System.out.println(who + "가 출금 시작");
		balance -= money;
		System.out.println(who + "가 " + money + "원 출금했습니다. 잔액 : " + balance);
		System.out.println(who + "가 출금 종료");
	}

	public int getBalance() {
		return balance;
	}
}
