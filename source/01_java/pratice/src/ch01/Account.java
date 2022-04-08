package ch01;

public class Account {

	private String accNo;
	private String ownerName;
	private int balance;
	
	public Account() {
	}

	public Account(String accNo, String ownerName, int balance) {
		this.accNo = accNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	public void deposit(int money) {
		balance += money;
		System.out.printf("%s(%s)�� %d�� �Ա� �Ϸ�. ���� �ܾ� : %d\n",
				ownerName, accNo, money, balance);
	}
	public void withdraw(int money) {
		if (money <= balance) {
			balance -= money;
			System.out.printf("%s(%s)�� %d�� ��� �Ϸ�. ���� �ܾ� : %d\n",
					ownerName, accNo, money, balance);
		} else {
			System.out.printf("%s(%s)���� �ܾ��� �����մϴ�.\n",
					ownerName, accNo);
		}
	}
	public void getBalance() {
		System.out.printf("%s(%s)���� ���� �ܾ� : %d",
				ownerName, accNo, balance);
	}
}
