package com.lec.ex11_final;

public final class Rabbit extends Animal {

	@Override
	public void running() {
		setSpeed(getSpeed() + 30);
		System.out.println("���� �پ��. ���� �ӵ� : " + getSpeed());
	}
}
