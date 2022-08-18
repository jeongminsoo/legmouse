package com.lec.ex2_date;

import java.util.Calendar;

public class Ex01_calendar {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		
		System.out.println(cal.getTime());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int week = cal.get(Calendar.DAY_OF_WEEK);
		int hour24 = cal.get(Calendar.HOUR_OF_DAY);
		int ampm = cal.get(Calendar.AM_PM);
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second =cal.get(Calendar.SECOND);
		int millisec = cal.get(Calendar.MILLISECOND);
		System.out.println(day);
		System.out.printf("%d년 %d월 %d일\n",year,month,day);
		System.out.println(Calendar.DATE);
		
		switch(week) {
		case 1:
			System.out.println("일요일");
			break;
		case 2:
			System.out.println("월요일");
			break;
		case 3:
			System.out.println("화요일");
			break;
		case 4:
			System.out.println("수요일");
			break;
		case 5:
			System.out.println("목요일");
			break;
		case 6:
			System.out.println("금요일");
			break;
		case 7:
			System.out.println("토요일");
			break;
		}
		// %tY 년도  %tm 월  %td  일  %ta 요일  %tH 24시 %tp 오전오후  %tl 12시  %tM 분  %tS초  
		System.out.print(ampm == 0 ? "오전" : "오후");
		System.out.printf("%d시 %d분 %d초 %d\n", hour, minute, second, millisec);
		System.out.printf("%d시 %d분 %d초 %d\n", hour24, minute, second, millisec);
		System.out.printf("%tY년 %tm월 %td일%ta요일%tp %tl시 %tM분 %tS초\n", cal, cal, cal, cal, cal, cal, cal, cal, cal);
		System.out.printf("%1$tY년 %1$tm월 %1$td일%1$ta요일%1$tp %1$tl시 %1$tM분 %1$tS초\n", cal);
		System.out.println(cal);
	}
}
