package com.lec.ex2_date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex05_SimpleDateFormat {

	public static void main(String[] args) {
		
		Date now1 = new Date();
		Calendar now2 = Calendar.getInstance();
		GregorianCalendar now3 = new GregorianCalendar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy년 MM월 dd일 E요일 a hh시 mm분 ss초");
		
		System.out.println(sdf.format(now1));
		System.out.println(sdf.format(now2.getTime()));
		System.out.println(sdf.format(now3.getTime()));
	}
}
