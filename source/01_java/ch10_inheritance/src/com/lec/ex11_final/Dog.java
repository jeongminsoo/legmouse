package com.lec.ex11_final;

public class Dog extends Animal {

	@Override
	public void running() {
		setSpeed(getSpeed() + 10);
		System.out.println("������ ���� �پ��. ����ӵ� : " + getSpeed());
	}
}
