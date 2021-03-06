package strategy1.step4.modularization;

import strategy1_step4_interfaces.FlyNo;
import strategy1_step4_interfaces.IFly;
import strategy1_step4_interfaces.IKnife;
import strategy1_step4_interfaces.IMissile;
import strategy1_step4_interfaces.KnifeNo;
import strategy1_step4_interfaces.MissileNo;

public class LowRobot extends Robot {

	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
	}
	
	
	
	@Override
	public void actionFly() {
		fly.fly();
	}

	@Override
	public void actionMissile() {
		missile.missile();
	}

	@Override
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
