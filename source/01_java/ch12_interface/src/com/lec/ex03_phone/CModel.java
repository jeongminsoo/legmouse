package com.lec.ex03_phone;


public class CModel implements IAcor {

	private String modelName;

	public CModel() {
		modelName = "C��";
	}

	@Override
	public void dmbReceive() {
		System.out.println(modelName + "�� DMB �۽� �Ұ�");
	}

	@Override
	public void lte() {
		System.out.println(modelName + "�� LTE");
	}

	@Override
	public void tvRemoteControl() {
		System.out.println(modelName + "�� TV������ ��ž��");
	}

}
