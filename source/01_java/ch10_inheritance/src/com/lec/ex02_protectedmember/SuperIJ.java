package com.lec.ex02_protectedmember;

public class SuperIJ {

	private int i;
	private int j;
	
	public SuperIJ() {
		System.out.println("�Ű����� ���°� SuperIJ ������ �Լ�");
	}
	public SuperIJ(int i, int j) {
		this.i = i;
		this.j = j;
		System.out.println("�Ű����� �ִ� SuperIJ ������ �Լ��� i, j�� �ʱ�ȭ");
	}
	protected void setI(int i) {
		this.i = i;
	}
	protected int getI() {
		return i;
	}
	public void setJ(int j) {
		this.j = j;
	}
	protected int getJ() {
		return j;
	}
}
