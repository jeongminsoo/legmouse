package com.lec.ex03_phone;

public class BModel implements IAcor {

	private String modelName;
	
	public BModel() {
		modelName = "B��";
	}
	
	@Override
	public void dmbReceive() {
		System.out.println(modelName + "�� DMB �۽� ����");

	}

	@Override
	public void lte() {
		System.out.println(modelName + "�� LTE");

	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "�� DMB �۽� ����");

	}

}
