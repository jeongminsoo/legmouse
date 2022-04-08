package com.lec.ex4_readerwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_Writer {

	public static void main(String[] args) {
		
		Writer writer = null;
		
		try {
			writer = new FileWriter("txtFile/RW.txt", true);
			String msg = "�ȳ��ϼ���\n�ݰ����ϴ�\n�ڽñ� ������~";
			writer.write(msg);
			System.out.println("���� ��� ����");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException ignore) {
			}
		}
	}
}
