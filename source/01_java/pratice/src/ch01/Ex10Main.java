package ch01;

import java.util.Scanner;

public class Ex10Main {

	public static void main(String[] args) {
		
		Ex10 ex = new Ex10();
		
		Scanner sc = new Scanner(System.in);

		int num = 0;
		
		while(num < 2 || num > 9) {
			System.out.print("수를 입력하세요. : ");
			num  = sc.nextInt();
			System.out.println("2~9 사이의 수를 입력하세요.");
			
		}
		ex.method(num);
	}
}
