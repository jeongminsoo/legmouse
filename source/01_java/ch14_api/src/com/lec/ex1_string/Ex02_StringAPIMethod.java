package com.lec.ex1_string;

public class Ex02_StringAPIMethod {

	public static void main(String[] args) {
		
	String str1 = "abcXabc";
	String str2 = new String("ABCXabc");
	String str3 = "       ja      va     ";
	System.out.println("1." + str1.concat(str2));
	System.out.println("2." + str1.substring(3));
	System.out.println("3." + str1.substring(3, 4));
	System.out.println("4." + str1.length());
	System.out.println("5." + str1.toUpperCase());
	System.out.println("6." + str1.toLowerCase());
	System.out.println("7." + str1.charAt(3));
	str1 = "abcXabc";
	System.out.println("8." + str1.indexOf('b'));
	System.out.println("9." + str1.indexOf('b', 3));
	System.out.println("10." + str1.indexOf("abc"));
	System.out.println("11." + str1.indexOf("abc", 2));
	System.out.println("12." + str1.indexOf('z'));
	System.out.println("13." + str1.lastIndexOf('b'));
	System.out.println("13." + str1.lastIndexOf('b', 3));
	str2 = new String("ABCXabc");
	System.out.println("15." + str1.contentEquals(str2));
	System.out.println("16." + str1.equalsIgnoreCase(str2));
	System.out.println("17." + str3.trim());
	System.out.println("18." + str3.replace('a', '9'));
	System.out.println("19." + str1.replace("abc", "#"));
	System.out.println("20." + str3.replace(" ", ""));
	System.out.println("21." + str1.replaceAll("abc", "Z"));
	String str = "æ»≥ÁHello";
	System.out.println("22." +str.replaceAll("[a-zA-z]", ""));
	System.out.println("23." + str.replaceAll("[∞°-∆R]", ""));
	System.out.println("str = " + str);
	System.out.println("str1 = " + str1);
	System.out.println("str2 = " + str2);
	System.out.println("str3 = " + str3);
	
	}
}
