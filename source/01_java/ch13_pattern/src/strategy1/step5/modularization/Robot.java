package strategy1.step5.modularization;

import strategy1_step4_interfaces.*;

public abstract class Robot {

	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public void actionWalk() {
		System.out.println("���� �� �ִ�");
	}
	public void actionRun() {
		System.out.println("�� �� �ִ�");
	}
	
	public void shape() {
		String className = getClass().getName();
		int idx = className.lastIndexOf('.');
		String name = className.substring(idx + 1);
		System.out.println(name + "�Դϴ�. ������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�.");
	}
	public void actionFly() {
		fly.fly();
	}
	public void actionMissile() {
		missile.missile();
	}
	public void actionKnife() {
		knife.knife();
	}
	
	public void setFly(IFly fly) {
		this.fly = fly;
	}
	
	public void setMissile(IMissile missile) {
		this.missile = missile;
	}
	
	public void setKnife(IKnife knife) {
		this.knife = knife;
	}
}
