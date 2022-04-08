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
			
			pw = new PrintWriter("txtFile/outTest.txt"); // ���� append �Ұ�
			
			System.out.println("�ȳ��ϼ���\n�ݰ����ϴ�");
			pw.println("�ȳ��ϼ���\n�ݰ����ϴ�");
			
			System.out.print("print�� �ڵ� ������ �ȵǼ� �����߰�\n");
			pw.print("print�� �ڵ� ������ �ȵǼ� �����߰�\n");
			
			System.out.printf("%s\t%d\t%d\t%.1f\n", "ȫ�浿", 90, 91, 90.5);
			pw.printf("%s\t%d\t%d\t%.1f\n", "ȫ�浿", 90, 91, 90.5);
			
			System.out.printf("%s\t%d\t%d\t%.1f\n", "�ű浿", 100, 100, 100.0);
			pw.printf("%s\t%d\t%d\t%.1f\n", "�ű浿", 100, 100, 100.0);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}
}
