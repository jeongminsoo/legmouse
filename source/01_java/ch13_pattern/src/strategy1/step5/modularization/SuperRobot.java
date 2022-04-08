package strategy1.step5.modularization;

import strategy1_step4_interfaces.*;

public class SuperRobot extends Robot {

	public SuperRobot() {
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
	}
}
