package com.lec.ex;

public class Ex05_line {

	public static void main(String[] args) {
		
		printLine('бс', 50);
		System.out.println("\tHello, world!");
		printLine(40);
		System.out.println("\tHello, Java!");
		printLine('~');
		System.out.println("\tHello, Hong!");
		printLine();
	}
	
	private static void printLine() {
		
		for (int i = 0; i < 30; i++) {
			System.out.print('-');
		}
		System.out.println();
	}
	
	private static void printLine(char c) {
		
		for (int i = 0; i < 30; i++) {
			System.out.print(c);
		}
		System.out.println();
	}
	
	private static void printLine(int i) {
		
		for (int j = 0; j < i; j++) {
			System.out.print('-');
		}
		System.out.println();
	}
	private static void printLine(char c, int i) {
		
		for (int j = 0; j < i; j++) {
			System.out.print(c);
		}
		System.out.println();
	}
	
}
