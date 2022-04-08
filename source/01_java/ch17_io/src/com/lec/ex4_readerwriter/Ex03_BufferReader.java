package com.lec.ex4_readerwriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Ex03_BufferReader {

	public static void main(String[] args) {

		Reader reader = null;
		BufferedReader br = null;

		try {
			reader = new FileReader("txtFile/inTest.txt");
			br = new BufferedReader(reader);

			while (true) {
				String linedata = br.readLine();

				if (linedata == null) {
					break;
				}
				System.out.println(linedata);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (IOException ignore) {
			}
		}

	}
}
