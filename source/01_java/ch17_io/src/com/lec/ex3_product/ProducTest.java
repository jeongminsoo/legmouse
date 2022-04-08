package com.lec.ex3_product;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class ProducTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		OutputStream os = null;
		DataOutputStream dos = null;
		
		String answer;
		String name;
		int price;
		int ps;
		
		do {
			System.out.print("제고를 입력하시겠습니까? (Y/N)");
			answer = sc.next();
			if (answer.equalsIgnoreCase("n")) {
				break;
			} else if (answer.equalsIgnoreCase("y")) {
				System.out.print("상품명 : ");
				name = sc.next();
				System.out.print("가격 : ");
				price = sc.nextInt();
				System.out.print("개수 : ");
				ps = sc.nextInt();
				try {
					os = new FileOutputStream("txtFile/ProductList.dat");
					dos = new DataOutputStream(os);
					
					while (true) {
						dos.writeUTF(name);
						dos.writeInt(price);
						dos.writeInt(ps);
					}
				} catch (FileNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}	
		} while(!answer.equalsIgnoreCase("n"));
	}
}
