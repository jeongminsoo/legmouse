package com.lec.ex8_decimalformat;

import java.text.DecimalFormat;

public class ex {

	public static void main(String[] args) {
		double num = 123000000000l;
		DecimalFormat df0 = new DecimalFormat("00000000");
		System.out.println(df0.format(num));
		DecimalFormat df1 = new DecimalFormat("########");
		System.out.println(df1.format(num));
		DecimalFormat df2 = new DecimalFormat("0,000.000");
		System.out.println(df2.format(num));
		DecimalFormat df3 = new DecimalFormat("#,###.##");
		System.out.println(df3.format(num));
		DecimalFormat df4 = new DecimalFormat("#.##E00");
		System.out.println(df4.format(num));
	}
}
