package com.lec.ex1_store;

// 본사 지침         : 김치찌개-5,000  부대찌개-6,000  비빔밥-6,000 순대국-5,000  공기밥-1,000원
public abstract class HeadQuarterStore {

	private String str;

//	public HeadQuarterStore() {
//	}
	public HeadQuarterStore(String str) {
		this.str = str;
	}

	// 메소드 구현은 없고 선언만 되어있는 메소드 : 추상메소드
	// 클래스 내에 추상 메소드가 하나 이상일 떄 : 추상클래스
	public abstract void kimchi();

	public abstract void bude();

	public abstract void bibim();

	public abstract void sunde();

	public abstract void gonggibab();

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
}
