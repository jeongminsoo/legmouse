package strategy1.step4.modularization;

import strategy1_step4_interfaces.FlyNo;
import strategy1_step4_interfaces.IFly;
import strategy1_step4_interfaces.IKnife;
import strategy1_step4_interfaces.IMissile;
import strategy1_step4_interfaces.KnifeWood;
import strategy1_step4_interfaces.MissileYes;

public class StandardRobot extends Robot {

	private IFly fly;
	private IMissile missile;
	private IKnife knife;
	
	public StandardRobot() {
		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeWood());
	}
	
	@Override
	public void actionFly() {

	}

	@Override
	public void actionMissile() {

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
