package com.lec.ex02_store;

// ���ð��� ����1ȣ��: ��ġ�-5,000  �δ��-5,000  �����-6,000 ���뱹-���Ⱦ� �����-1,000��
// ctrl + 1 : �߻�Ŭ������ �߻�޼ҵ� �ҷ�����
public class StoreNum1 implements HeadQuarterStore {

	private String str;
	
	public StoreNum1(String str) {
		this.str = str;
	}

	@Override
	public void kimchi() {
		System.out.println("��ġ� 5,000��");
	}

	@Override
	public void bude() {
		System.out.println("�δ�� 5,000��");
	}

	@Override
	public void bibim() {
		System.out.println("����� 6,000��");
	}

	@Override
	public void sunde() {
		System.out.println("���뱹 ���Ⱦ�");
	}

	@Override
	public void gonggibab() {
		System.out.println("����� 1,000��");
	}

	public String getStr() {
		return str;
	}

}
