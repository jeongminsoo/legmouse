package com.lec.ex3_product;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class ProducWrite {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		OutputStream os = null;
		DataOutputStream dos = null;
		String answer;

		try {
			os = new FileOutputStream("txtFile/ProductList.dat");
			dos = new DataOutputStream(os);
					
			while (true) {
				System.out.print("제고를 입력하시겠습니까? (Y/N)");
				answer = sc.next();
				if (answer.equalsIgnoreCase("n")) {
					break;
				} else if (answer.equalsIgnoreCase("y")) {
					System.out.print("상품명 : ");
					dos.writeUTF(sc.next());
					System.out.print("가격 : ");
					dos.writeInt(sc.nextInt());
					System.out.print("재고 : ");
					dos.writeInt(sc.nextInt());
				}
			}
			sc.close();
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
