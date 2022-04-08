package strategy1.step4.modularization;

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
		
	}
}
