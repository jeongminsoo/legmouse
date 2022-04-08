package com.lec.ex7_timer;

import java.util.TimerTask;

public class TimerTaskEx2 extends TimerTask{

	@Override
	public void run() {
		System.out.println("작업2 : 1초 후에 0.5초마다 계속 수행될 예정인 작업(TimerTaks) ★★★");
		
	}

}
