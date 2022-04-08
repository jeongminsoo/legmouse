package com.lec.ex4_object;

public class Rectangle implements Cloneable{

	private int width;
	private int height;
	private String color;
	
	public Rectangle() {
		color = "검정";
	}

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
		color = "검정";
	}

	public Rectangle(int width, int height, String color) {
		this.width = width;
		this.height = height;
		this.color = color;
	}

	@Override
	public String toString() {
		//	return "가로 " + width + ", 세로 " + height + "인 " + color + "색 사각형";
		return String.format("가로 %dcm 새로 %dcm인 %s색 사각형", width, height, color);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Rectangle) {
			Rectangle tempObj = (Rectangle)obj;
			boolean widthChk = width == tempObj.width;
			boolean heightChk = height == tempObj.height;
			boolean colorChk = color.equals(tempObj.color);
			return widthChk && heightChk && colorChk;
		} else {
			return false;
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {  // 예외처리
		return super.clone();
	}
	

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
