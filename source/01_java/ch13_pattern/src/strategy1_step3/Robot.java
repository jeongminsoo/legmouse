package strategy1_step3;

public abstract class Robot {

	public void actionWalk() {
		System.out.println("���� �� �ִ�");
	}
	public void actionRun() {
		System.out.println("�� �� �ִ�");
	}
	
	public void shape() {
		String className = getClass().getName();
		int idx = className.lastIndexOf('.');
		String name = className.substring(idx + 1);
		System.out.println(name + "�Դϴ�. ������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�.");
	}
	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionKnife();
}
