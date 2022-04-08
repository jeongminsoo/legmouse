package com.lec.ex11_robot;

public class TestMain {

	public static void main(String[] args) {
		
	
		RobotOrder order = new RobotOrder();
	
		Robot[] robot = { new DanceRobot(),
						  new SingRobot(),
						  new DrawRobot() };
	
		for (Robot r : robot) {
			order.action(r);
		}
	}
}

