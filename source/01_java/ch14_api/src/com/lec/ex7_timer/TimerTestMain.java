package com.lec.ex7_timer;

import java.util.Timer;

public class TimerTestMain {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("Ω√¿€");
		
		Timer timer = new Timer(true);
		TimerTaskEx1 task1 = new TimerTaskEx1();
		TimerTaskEx2 task2 = new TimerTaskEx2();
		timer.schedule(task1, 2000);
		timer.schedule(task2, 1000, 500);
		Thread.sleep(5000);
		
		System.out.println("≥°");
	}
}
