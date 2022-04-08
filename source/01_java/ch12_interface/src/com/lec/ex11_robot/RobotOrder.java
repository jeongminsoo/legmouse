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
			System.out.println("확장된 로못이면 이곳에 구현하세요");
		}
	}
}
