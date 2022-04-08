package com.lec.ex2_datastream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex01_DataInputStream {

	public static void main(String[] args) {

		InputStream is = null;
		DataInputStream dis = null;

		try {
			is = new FileInputStream("txtFile/dataFile.dat");
			dis = new DataInputStream(is);

			while (true) {
				String name = dis.readUTF();
				int grade = dis.readInt();
				double score = dis.readDouble();
				System.out.printf("%s는 %d학년 %f점\n", name, grade, score);

			}

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("데이터 끝");
		} finally {
			try {
				if (dis != null) {
					dis.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
			}
		}
	}
}
