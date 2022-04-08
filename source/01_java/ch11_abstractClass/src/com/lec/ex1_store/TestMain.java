package com.lec.ex1_store;

public class TestMain {

	public static void main(String[] args) {
		
		HeadQuarterStore[] store = { //new HeadQuarterStore("=== 본사 ==="),
		new StoreNum1("=== 1호점 ==="),
		new StoreNum2("=== 2호점 ==="),
		new StoreNum3("=== 3호점 ===")};
		
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
