package com.lec.ex14_account;

public class CheckingAccount extends Account {

	private String cardNo;
	
	public CheckingAccount(String accountNo, String ownerName, String cardNo) {
		super(accountNo, ownerName);
		this.cardNo = cardNo;
	}
	public CheckingAccount(String accountNo, String ownerName, int balance ,String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
	}
	public void pay(String cardNo, int money) {
		if (cardNo.equals(this.cardNo)) {
			if (money <= getBalance()) {
				 setBalance(getBalance() - money);
				 System.out.printf("%s(%s)님 %d원 지불해서 잔액 %d원 남았습니다\n",
						 getOwnerName(), getAccountNo(), money, getBalance());
			} else {
				System.out.printf("%s(%s)님 잔액 %d원으로 %d원 지불 불가합니다\n",
						getOwnerName(), getAccountNo(), getBalance(), money);
			}
		}else {
			System.out.println("올바른 카드번호를 입력하세요.");
		}
	}
	public String getCardNo() {
		return cardNo;
	}
	
}
