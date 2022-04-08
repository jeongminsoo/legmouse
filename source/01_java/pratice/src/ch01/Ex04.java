package ch01;

public class Ex04 {

	public static void main(String[] args) {
		
		int count = 0;
		
		int num1 = 0;
		int num2 = 0;
		
		while ( num1 + num2 != 6) {
			num1 = (int)(Math.random()*6)+1;
			num2 = (int)(Math.random()*6)+1;
			if (num1 + num2 == 6) {
				System.out.printf("(%d, %d)\n", num1, num2);
			} else {
				System.out.printf("(%d, %d)\n", num1, num2);
				count++;
			}
		}
		System.out.println("주사위 던진 횟수 : " + count);
	}
}
