package com.lec.ex14_account;

public class CreditLineAccount extends CheckingAccount {

	private int creditLine;
	
	public CreditLineAccount(String accountNo, String ownerName, String cardNo, int creditLine) {
		super(accountNo, ownerName, cardNo);
		this.creditLine = creditLine;
	}
//	public CreditLineAccount(String accountNo, String ownerName, int balance, String cardNo, int creditLine) {
//		super(accountNo, ownerName, balance, cardNo);
//		this.creditLine = creditLine;
//	}
	@Override
	public void pay(String cardNo, int money) {
		if (cardNo.equals(getCardNo())) {
			if (money <= creditLine) {
				 creditLine -= money;
				 System.out.printf("%s(%s)님 %d원 지불해서 한도 %d원 남았습니다\n",
						 getOwnerName(), getAccountNo(), money, creditLine);
			} else {
				System.out.printf("%s(%s)님 한도 %d원으로 %d원 지불 불가합니다\n",
						getOwnerName(), getAccountNo(), creditLine, money);
			}
		}else {
			System.out.println("올바른 카드번호를 입력하세요.");
		}
	}
}
