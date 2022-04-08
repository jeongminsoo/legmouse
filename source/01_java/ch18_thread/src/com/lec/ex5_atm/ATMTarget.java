package com.lec.ex5_atm;

public class ATMTarget implements Runnable {

	private boolean flag;
	private ATM card;
	public ATMTarget(ATM card) {
		this.card = card;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			if (flag) {
				card.withdraw(1000, Thread.currentThread().getName());
				flag = false;
			} else {
				card.deposit(1000, Thread.currentThread().getName());
				flag = true;
			}
		}
		
	}

}
