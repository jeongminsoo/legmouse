package com.lec.ex2_datastream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex01_DataOutputStream {

	public static void main(String[] args) {

		OutputStream os = null;
		DataOutputStream dos = null;

		try {
			os = new FileOutputStream("txtFile/dataFile.dat", true);
			dos = new DataOutputStream(os); // 보조 스트림은 기본 스트림을 통해서만 생성
			dos.writeUTF("홍길동"); // String값 저장
			dos.writeInt(2); // int값 저장
			dos.writeDouble(95.5); // double값 저장

			dos.writeUTF("신길동");
			dos.writeInt(3);
			dos.writeDouble(99.5);

			System.out.println("파일 저장 완료");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (dos != null) {
					dos.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
			}

		}
	}
}
