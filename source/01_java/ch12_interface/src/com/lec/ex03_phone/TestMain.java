package com.lec.ex03_phone;

public class TestMain {

	public static void main(String[] args) {
		
		AModel a = new AModel();
		BModel b = new BModel();
		CModel c = new CModel();
		
		IAcor[] phone = {a, b, c};
		
		for ( IAcor ac : phone) {
			System.out.println(ac.getClass().getName());
			ac.dmbReceive();
			ac.lte();
			ac.tvRemoteControl();
		}
		
	}
}
