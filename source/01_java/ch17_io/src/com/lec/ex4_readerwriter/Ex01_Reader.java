package com.lec.ex4_readerwriter;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex01_Reader {

	public static void main(String[] args) {
		
		Reader reader = null;
		try {
			reader = new FileReader("txtFile/inTest.txt");
			while (true) {
				int i = reader.read();
				if (i == -1) {
					break;
				}
				System.out.print((char)i);
				
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
			}
		}
		
	}
}
