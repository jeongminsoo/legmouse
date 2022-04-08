package com.lec.loop;

public class Ex04_for {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 40; i++) {
			System.out.print(i + "\t");
			if ( i % 4 == 0) {
				System.out.println();
			}
		}
		
		
		
		
		
		
		
		
		
		int num = 15;
		
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 5; j++) {
				if (num <= 50) {
					System.out.print(num + "\t");
					num++;
				}
			}
			System.out.println();
		}
	}
}
