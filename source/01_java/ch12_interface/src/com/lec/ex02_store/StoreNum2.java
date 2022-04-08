package com.lec.ex02_store;

// ´ëÇĞ°¡¿¡ ¸ÅÀå2È£Á¡: ±èÄ¡Âî°³-5,000  ºÎ´ëÂî°³-5,000  ºñºö¹ä-5,000 ¼ø´ë±¹-5,000  °ø±â¹ä-¹«·á
public class StoreNum2 implements HeadQuarterStore {

	private String str;
	
	public StoreNum2(String str) {
		this.str = str;
	}

	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ 5,000¿ø");
	}

	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ 5,000¿ø");
	}

	@Override
	public void bibim() {
		System.out.println("ºñºö¹ä 5,000¿ø");
	}

	@Override
	public void sunde() {
		System.out.println("¼ø´ë±¹ 5,000¿ø");
	}

	@Override
	public void gonggibab() {
		System.out.println("°ø±â¹ä ¹«·á");
	}

	public String getStr() {
		return str;
	}
	
}
