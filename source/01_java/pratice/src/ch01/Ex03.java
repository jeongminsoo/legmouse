package ch01;

public class Ex03 {

	public static void main(String[] args) {
		
		int sum = 0;
		
		for (int i = 0; i <= 20; i++) {
			if ((i % 2 != 0) && (i % 3 != 0)) {
				sum += i;
			}
		}
		System.out.println("2�� 3�� ����� �ƴ� ���� �� : " + sum);
	}
}
