package com.lec.ex4_threadnobjectn;

public class ThreadEx extends Thread {

	private int num = 0;
	
	public ThreadEx(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if (Thread.currentThread().getName().equals("A")) {
				System.out.println("-----A스레드 수행중-----");
				num++;
			}
			System.out.println(Thread.currentThread().getName() + "의 num : " + num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
		
	}
	
	public int getNum() {
		return num;
	}
}
