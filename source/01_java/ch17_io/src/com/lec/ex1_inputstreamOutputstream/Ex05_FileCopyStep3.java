package com.lec.ex1_inputstreamOutputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex05_FileCopyStep3 {

	public static void main(String[] args) {

		InputStream is = null;
		OutputStream os = null;

		try {
			File file = new File("d:\\webPro_薑團熱\\IU.jpg");
			is = new FileInputStream(file);
			os = new FileOutputStream("d:/webPro_薑團熱/IU_copy.jpg");
			int count = 0;
			byte[] bs = new byte[(int) file.length()];
			while (true) {
				int readByteCount = is.read(bs);
				if (readByteCount == -1) {
					break;
				}
				os.write(bs, 0, readByteCount);
				count++;
			}
			System.out.println(count);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (os != null) {
					os.close();
				}
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
			}
		}
	}
}
