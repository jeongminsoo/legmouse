package com.lec.ex1_inputstreamOutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex02_InputStreamByteArray {

	public static void main(String[] args) {
		
		InputStream is = null;
		
		try {
			is = new FileInputStream("txtFile/inTest.txt");
			byte[] bs = new byte[10];
			while (true) {
				int readByteCount = is.read(bs);
				if (readByteCount == -1) {
					break;
				}
				for(int i = 0; i < readByteCount; i++) {
					System.out.print((char)bs[i]);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
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
