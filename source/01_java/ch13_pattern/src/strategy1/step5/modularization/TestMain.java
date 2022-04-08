package strategy1.step5.modularization;

import strategy1_step4_interfaces.FlyHigh;

public class TestMain {

	public static void main(String[] args) {
		
		Robot superR = new SuperRobot();
		Robot standardR = new StandardRobot();
		Robot lowR = new LowRobot();
		
		Robot[] robot = {superR, standardR, lowR};
		
		for (Robot r : robot) {
			r.shape();
			r.actionWalk();
			r.actionRun();
			r.actionFly();
			r.actionMissile();
			r.actionKnife();
		}
		superR.setFly(new FlyHigh());
		
		for (Robot r : robot) {
			r.shape();
			r.actionWalk();
			r.actionRun();
			r.actionFly();
			r.actionMissile();
			r.actionKnife();
	}
}
}
