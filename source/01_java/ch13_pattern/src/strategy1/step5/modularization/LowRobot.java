package strategy1.step5.modularization;

import strategy1_step4_interfaces.*;


public class LowRobot extends Robot {

	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
	}
}
