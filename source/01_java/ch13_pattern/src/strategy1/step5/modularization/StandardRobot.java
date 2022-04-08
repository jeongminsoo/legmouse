package strategy1.step5.modularization;

import strategy1_step4_interfaces.*;

public class StandardRobot extends Robot {
	
	public StandardRobot() {
		setFly(new FlyNo());
		setMissile(new MissileYes());
		setKnife(new KnifeWood());
	}

}
