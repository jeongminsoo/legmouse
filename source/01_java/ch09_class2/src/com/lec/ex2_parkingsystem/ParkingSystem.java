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
		System.out.println(carNum + "�� �������");
		System.out.println("�����ð� : " + this.inTime + '��');
	}

	public ParkingSystem(String carNum, int inTime, int outTime, int fee) {
		this.carNum = carNum;
		this.inTime = inTime;
		this.outTime = outTime;
		this.fee = fee;
	}

	public void outCar(int outTime) {
		System.out.println(carNum + "�� �ȳ��� ������");
		System.out.println("�����ð� : " + inTime + '��');
		this.outTime = outTime;
		System.out.println("�����ð� : " + this.outTime + '��');
		fee = (this.outTime - inTime) * Constant.HOURLYPARKINGRATE;
		System.out.println("������� : " + fee + '��');

	}
}
