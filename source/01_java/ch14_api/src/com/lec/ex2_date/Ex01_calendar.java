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
		System.out.printf("%d�� %d�� %d��\n",year,month,day);
		System.out.println(Calendar.DATE);
		
		switch(week) {
		case 1:
			System.out.println("�Ͽ���");
			break;
		case 2:
			System.out.println("������");
			break;
		case 3:
			System.out.println("ȭ����");
			break;
		case 4:
			System.out.println("������");
			break;
		case 5:
			System.out.println("�����");
			break;
		case 6:
			System.out.println("�ݿ���");
			break;
		case 7:
			System.out.println("�����");
			break;
		}
		// %tY �⵵  %tm ��  %td  ��  %ta ����  %tH 24�� %tp ��������  %tl 12��  %tM ��  %tS��  
		System.out.print(ampm == 0 ? "����" : "����");
		System.out.printf("%d�� %d�� %d�� %d\n", hour, minute, second, millisec);
		System.out.printf("%d�� %d�� %d�� %d\n", hour24, minute, second, millisec);
		System.out.printf("%tY�� %tm�� %td��%ta����%tp %tl�� %tM�� %tS��\n", cal, cal, cal, cal, cal, cal, cal, cal, cal);
		System.out.printf("%1$tY�� %1$tm�� %1$td��%1$ta����%1$tp %1$tl�� %1$tM�� %1$tS��\n", cal);
		System.out.println(cal);
	}
}
