package com.lec.ex1_inputstreamOutputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex03_OutputStream {

	public static void main(String[] args) {
		
		OutputStream os = null;
		
		try {
			os = new FileOutputStream("txtFile/outTest.txt", true);
			byte[] bs = {'H', 'e', 'l', 'l', 'o'};
			os.write(bs);
			System.out.println("���� ��� ����");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
