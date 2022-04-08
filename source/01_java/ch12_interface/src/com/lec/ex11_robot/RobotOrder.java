package com.lec.ex11_robot;

public class RobotOrder {

	public void action(Robot r) {
		if (r instanceof DanceRobot) {
			((DanceRobot) r).dance();
		} else if (r instanceof SingRobot) {
			((SingRobot) r).sing();
		} else if (r instanceof DrawRobot) {
			((DrawRobot)r).draw();
		} else {
			System.out.println("Ȯ��� �θ��̸� �̰��� �����ϼ���");
		}
	}
}
