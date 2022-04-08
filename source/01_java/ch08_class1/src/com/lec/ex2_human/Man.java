package com.lec.ex2_human;

public class Man {

	private int age;
	private int height;
	private double weight;
	private String phoneNum;
	
	public Man() {
	}
	
	public Man(int age, int height, double weight, String phoneNum) {
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.phoneNum = phoneNum;
	}
	
	public Man(int age, int height, double weight) {
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	
	public Man(int age) {
		this.age = age;
	}
	
	public double calculateBMI() {
		double result = weight / ((height / 100.0) * (height / 100.0));
		return result;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getHeight() {
		return height;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
}
