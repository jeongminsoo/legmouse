package strategy1_step3;

public class LowRobot extends Robot{

	@Override
	public void actionFly() {
		System.out.println("�� �� ����");
	}
	@Override
	public void actionMissile() {
		System.out.println("�̻����� �� �� ����");
	}
	@Override
	public void actionKnife() {
		System.out.println("���� ����");
	}
}
