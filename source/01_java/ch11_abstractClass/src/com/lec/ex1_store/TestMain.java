package com.lec.ex1_store;

public class TestMain {

	public static void main(String[] args) {
		
		HeadQuarterStore[] store = { //new HeadQuarterStore("=== ���� ==="),
		new StoreNum1("=== 1ȣ�� ==="),
		new StoreNum2("=== 2ȣ�� ==="),
		new StoreNum3("=== 3ȣ�� ===")};
		
		for (HeadQuarterStore s : store) {
			System.out.println(s.getStr());
			s.kimchi();
			s.bude();
			s.bibim();
			s.sunde();
			s.gonggibab();
		}
	}
}
