package com.lec.ex5_momchild;

public class Child {

	private String name;
	
	static MomPouch momPouch = new MomPouch();
	
	public Child() {
	}
	public Child(String name) {
		this.name = name;
	}
	public void takeMoney(int money) {
		if (momPouch.money >= money) {
			momPouch.money -= money;
			System.out.println(name + "가 " + money + "원 가져가서 엄마 지갑에 " + momPouch.money + "원 있음");
		} else {
			System.out.println(name + "가 돈을 못받음. 현재 엄마 지갑에는 " + momPouch.money + "원 밖에 없음");
		}
	}
}