package strategy2.modularization;

import strategy2.interfaces.IEngine;
import strategy2.interfaces.IFuel;
import strategy2.interfaces.IKm;

public abstract class Car {

	private IEngine engine;
	private IKm km;
	private IFuel fuel;
	
	public void drive() {
		System.out.println("����̺� �� �� �ֽ��ϴ�.");
	}
	public void shape() {
		String nameClass = getClass().getName();
		int idx = nameClass.lastIndexOf(".");
		String name = nameClass.substring(idx+1);
		System.out.println(name + "�Դϴ�. door, sheet, handle�� �̷���� �ֽ��ϴ�.");
	}
	
	public void infoPrint() {
		engine.engine();
		km.km();
		fuel.fuel();
	}
	
	public void setEngine(IEngine engine) {
		this.engine = engine;
	}
	public void setKm(IKm km) {
		this.km = km;
	}
	public void setFuel(IFuel fuel) {
		this.fuel = fuel;
	}
}
