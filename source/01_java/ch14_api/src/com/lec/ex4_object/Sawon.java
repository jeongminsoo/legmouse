package com.lec.ex4_object;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon {

//	public static final String COMPUTER = "COMPUTER";
	private String num;
	private String name;
	private String dept;
	private Date hiredate;
	
	public Sawon(String num, String name, String dept) {
		this.num = num;
		this.name = name;
		this.dept = dept;
		hiredate = new Date();
	}

	public Sawon(String num, String name, String dept, int y, int m, int d) {
		this.num = num;
		this.name = name;
		this.dept = dept;
		hiredate = new Date(new GregorianCalendar(y, m-1, d).getTimeInMillis());
	}
	
	@Override
		public String toString() {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd��(E)");
			return "[���]" + num + " [�̸�]" + name 
					+ " [�μ�]" + dept + " [�Ի���]" + sdf.format(hiredate);
		}
	
}
