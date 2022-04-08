package com.lec.ex1_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex01_InputStream {

	public static void main(String[] args) {
		
		InputStream is = null;
		
		try {
			is = new FileInputStream("txtFile/inTest.txt");
			
			while (true) {
				int i = is.read();
				if (i == -1) {
					break;
				}
				System.out.print((char)i + "(" + i + ")");
			}
			System.out.println("\n��");
			
		} catch (FileNotFoundException e) {
			System.out.println("������ ��ã�� ��� ���� : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("������ ������ ��� ���� : " + e.getMessage());
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
