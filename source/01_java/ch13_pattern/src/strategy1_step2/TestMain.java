package strategy1_step2;

public class TestMain {

	public static void main(String[] args) {
		
		Robot spr = new SuperRobot();
		Robot sdr = new StandardRobot();
		Robot lwr = new LowRobot();
		
		Robot[] robot = {spr, sdr, lwr};
		
		for (Robot r : robot) {
			r.shape();
			r.actionRun();
			r.actionWalk();
			if (r instanceof SuperRobot) {
				SuperRobot rr = (SuperRobot)r;
				rr.actionFly();
				rr.actionMissile();
				rr.actionKnife();
			} else if (r instanceof StandardRobot) {
				StandardRobot rr = (StandardRobot)r;
				rr.actionFly();
				rr.actionMissile();
				rr.actionKnife();
			} else if (r instanceof LowRobot) {
				LowRobot rr = (LowRobot)r;
				rr.actionFly();
				rr.actionMissile();
				rr.actionKnife();
			}
		}
	}
}
