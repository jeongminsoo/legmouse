package com.lec.ex4_supermarket;

import java.text.DecimalFormat;

public class CustomerDto {

	private int cId;
	private String cTel;
	private String cName;
	private int cPoint;
	private int cAmount;
	private byte levelNo;
	private String levelName;
	private int gap;
	
	public CustomerDto() {
	}
	
	// 입력용
	public CustomerDto(int cId, String cTel, String cName, int cPoint, int cAmount, byte levelNo) {
		this.cId = cId;
		this.cTel = cTel;
		this.cName = cName;
		this.cPoint = cPoint;
		this.cAmount = cAmount;
		this.levelNo = levelNo;
	}
	
	// 회원가입
	public CustomerDto(String cTel, String cName) {
		this.cTel = cTel;
		this.cName = cName;
		cPoint = 1000;
	}
	
	// 아이디 검색, 전화번호4자리, 전체 검색, 이름검색
	public CustomerDto(int cId, String cTel, String cName, int cPoint, int cAmount, String levelName, int gap) {
		this.cId = cId;
		this.cTel = cTel;
		this.cName = cName;
		this.cPoint = cPoint;
		this.cAmount = cAmount;
		this.levelName = levelName;
		this.gap = gap;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat();
		return cId + "\t" + cTel + "\t\t" + cName + "\t" + df.format(cPoint)
				+ "\t" + df.format(cAmount) + "\t" + levelName + "\t" + df.format(gap) + "\n";
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcTel() {
		return cTel;
	}

	public void setcTel(String cTel) {
		this.cTel = cTel;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getcPoint() {
		return cPoint;
	}

	public void setcPoint(int cPoint) {
		this.cPoint = cPoint;
	}

	public int getcAmount() {
		return cAmount;
	}

	public void setcAmount(int cAmount) {
		this.cAmount = cAmount;
	}

	public byte getLevelNo() {
		return levelNo;
	}

	public void setLevelNo(byte levelNo) {
		this.levelNo = levelNo;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public int getGap() {
		return gap;
	}

	public void setGap(int gap) {
		this.gap = gap;
	}
}
