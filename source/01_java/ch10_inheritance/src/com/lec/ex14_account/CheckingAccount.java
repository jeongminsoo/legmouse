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
				 System.out.printf("%s(%s)�� %d�� �����ؼ� �ܾ� %d�� ���ҽ��ϴ�\n",
						 getOwnerName(), getAccountNo(), money, getBalance());
			} else {
				System.out.printf("%s(%s)�� �ܾ� %d������ %d�� ���� �Ұ��մϴ�\n",
						getOwnerName(), getAccountNo(), getBalance(), money);
			}
		}else {
			System.out.println("�ùٸ� ī���ȣ�� �Է��ϼ���.");
		}
	}
	public String getCardNo() {
		return cardNo;
	}
	
}
