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
				 System.out.printf("%s(%s)�� %d�� �����ؼ� �ѵ� %d�� ���ҽ��ϴ�\n",
						 getOwnerName(), getAccountNo(), money, creditLine);
			} else {
				System.out.printf("%s(%s)�� �ѵ� %d������ %d�� ���� �Ұ��մϴ�\n",
						getOwnerName(), getAccountNo(), creditLine, money);
			}
		}else {
			System.out.println("�ùٸ� ī���ȣ�� �Է��ϼ���.");
		}
	}
}
