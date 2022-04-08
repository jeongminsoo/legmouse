package com.lec.ex4_readerwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Ex02_Writer {

	public static void main(String[] args) {
		
		Writer writer = null;
		
		try {
			writer = new FileWriter("txtFile/RW.txt", true);
			String msg = "안녕하세요\n반갑습니다\n코시국 ㅈ같네~";
			writer.write(msg);
			System.out.println("파일 출력 성공");
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
