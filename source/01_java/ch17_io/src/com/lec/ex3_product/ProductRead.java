package com.lec.ex3_product;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ProductRead {

	public static void main(String[] args) {
		
		InputStream is = null;
		DataInputStream dis = null;
		
		ArrayList<Product> products = new ArrayList<Product>();
		
		try {
			is = new FileInputStream("txtFile/ProductList.dat");
			dis = new DataInputStream(is);
			
			while (true) {
				String name = dis.readUTF();
				int price = dis.readInt();
				int ps = dis.readInt();
				
				products.add(new Product(name, price, ps));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("��� �����ʹ� ������ �����ϴ�.");
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
		if (products.isEmpty()) {
			System.out.println("�Էµ� ��� �����Ͱ� �����ϴ�.");
		} else {
			System.out.println("��ǰ��\t����\t����");
			for (Product p : products) {
				System.out.println(p);
			}
			System.out.println("�̻� ��ǰ" + products.size() + "���� �Էµ�");
		}
	}
}
