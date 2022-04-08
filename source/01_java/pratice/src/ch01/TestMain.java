package ch01;

public class TestMain {

	public static void main(String[] args) {
		
		Account hong = new Account("110-111", "ȫ�浿", 1000000);
		
		hong.deposit(1000000);
		hong.withdraw(3000000);
		hong.withdraw(1500000);
		hong.getBalance();
	}
}
