package com.lec.ex12_store;
// ���ð��� ����1ȣ��: ��ġ�-5,000  �δ��-5,000  �����-6,000 ���뱹-���Ⱦ� �����-1,000��
public class StoreNum1 extends HeadQuarterStore {

	public StoreNum1(String str) {
		super(str);
	}
	@Override
	public void bude() {
		System.out.println("�δ�� 5,000��");
	}
	@Override
	public void sunde() {
		System.out.println("���뱹 ���Ⱦ�");
	}
	

}
