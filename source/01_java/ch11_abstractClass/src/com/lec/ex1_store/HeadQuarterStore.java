package com.lec.ex1_store;

// ���� ��ħ         : ��ġ�-5,000  �δ��-6,000  �����-6,000 ���뱹-5,000  �����-1,000��
public abstract class HeadQuarterStore {

	private String str;

//	public HeadQuarterStore() {
//	}
	public HeadQuarterStore(String str) {
		this.str = str;
	}

	// �޼ҵ� ������ ���� ���� �Ǿ��ִ� �޼ҵ� : �߻�޼ҵ�
	// Ŭ���� ���� �߻� �޼ҵ尡 �ϳ� �̻��� �� : �߻�Ŭ����
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
