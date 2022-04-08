package com.lec.ex2_parkingsystem;

import com.lec.cons.Constant;

public class ParkingSystem {

	private String carNum;
	private int inTime;
	private int outTime;
	private int fee;
//	private final int HOURLYPARKINGRATE = 2000;

	public ParkingSystem() {
	}

	public ParkingSystem(String carNum) {
		this.carNum = carNum;
	}

	public ParkingSystem(String carNum, int inTime) {
		this.carNum = carNum;
		this.inTime = inTime;
		System.out.println(carNum + "님 어서오세요");
		System.out.println("입차시간 : " + this.inTime + '시');
	}

	public ParkingSystem(String carNum, int inTime, int outTime, int fee) {
		this.carNum = carNum;
		this.inTime = inTime;
		this.outTime = outTime;
		this.fee = fee;
	}

	public void outCar(int outTime) {
		System.out.println(carNum + "님 안녕히 가세요");
		System.out.println("입차시간 : " + inTime + '시');
		this.outTime = outTime;
		System.out.println("출차시간 : " + this.outTime + '시');
		fee = (this.outTime - inTime) * Constant.HOURLYPARKINGRATE;
		System.out.println("주차요금 : " + fee + '원');

	}
}
