package com.lec.ex7_product;

public class Product {

	private int serialNum;
	public static int count = 100;
	
	public Product() {
		serialNum = ++count;
	}
	public void infoPrint() {
		System.out.println("serialNum : " + serialNum + "\t공유변수 count : " + count);
	}
}
