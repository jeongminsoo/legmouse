package com.lec.ex5_printwriter;

import java.io.IOException;
import java.io.PrintWriter;

public class Ex {

	public static void main(String[] args) {
		
//		OutputStream os = null;;
//		Writer writer = null;
		PrintWriter pw = null;
		
		try {
//			os = new FileOutputStream("txtFile/outTest.txt");
//			pw = new PrintWriter(os);
//			writer = new FileWriter("txtFile/outTest.txt");
//			pw = new PrintWriter(writer);
			
			pw = new PrintWriter("txtFile/outTest.txt"); // 파일 append 불가
			
			System.out.println("안녕하세요\n반갑습니다");
			pw.println("안녕하세요\n반갑습니다");
			
			System.out.print("print는 자동 개행이 안되서 개행추가\n");
			pw.print("print는 자동 개행이 안되서 개행추가\n");
			
			System.out.printf("%s\t%d\t%d\t%.1f\n", "홍길동", 90, 91, 90.5);
			pw.printf("%s\t%d\t%d\t%.1f\n", "홍길동", 90, 91, 90.5);
			
			System.out.printf("%s\t%d\t%d\t%.1f\n", "신길동", 100, 100, 100.0);
			pw.printf("%s\t%d\t%d\t%.1f\n", "신길동", 100, 100, 100.0);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
}
