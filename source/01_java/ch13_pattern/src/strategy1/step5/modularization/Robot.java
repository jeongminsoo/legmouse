package strategy1.step5.modularization;

import strategy1_step4_interfaces.*;

public abstract class Robot {

	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public void actionWalk() {
		System.out.println("걸을 수 있다");
	}
	public void actionRun() {
		System.out.println("뛸 수 있다");
	}
	
	public void shape() {
		String className = getClass().getName();
		int idx = className.lastIndexOf('.');
		String name = className.substring(idx + 1);
		System.out.println(name + "입니다. 외형은 팔, 다리, 몸통, 머리가 있습니다.");
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
