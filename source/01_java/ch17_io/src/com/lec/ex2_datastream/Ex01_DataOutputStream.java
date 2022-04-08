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
			dos = new DataOutputStream(os); // ���� ��Ʈ���� �⺻ ��Ʈ���� ���ؼ��� ����
			dos.writeUTF("ȫ�浿"); // String�� ����
			dos.writeInt(2); // int�� ����
			dos.writeDouble(95.5); // double�� ����

			dos.writeUTF("�ű浿");
			dos.writeInt(3);
			dos.writeDouble(99.5);

			System.out.println("���� ���� �Ϸ�");
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
