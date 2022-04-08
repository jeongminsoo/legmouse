package com.lec.ex3_threadnobject1;

public class TargetExTestMain {

	public static void main(String[] args) {
		
		TargetEx target = new TargetEx();
		
		Thread threadA = new Thread(target, "A");
		
		Thread threadB = new Thread(target, "B");
		
		threadA.start();
		threadB.start();
	}
}
