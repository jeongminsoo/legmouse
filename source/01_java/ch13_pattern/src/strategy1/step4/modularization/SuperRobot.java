package strategy1.step4.modularization;

import strategy1_step4_interfaces.FlyYes;
import strategy1_step4_interfaces.IFly;
import strategy1_step4_interfaces.IKnife;
import strategy1_step4_interfaces.IMissile;
import strategy1_step4_interfaces.KnifeLazer;
import strategy1_step4_interfaces.MissileYes;

public class SuperRobot extends Robot {

	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public SuperRobot() {
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
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
