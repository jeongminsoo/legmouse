package strategy1.step4.modularization;

public abstract class Robot {

	public void actionWalk() {
		System.out.println("걸을 수 있다");
	}
	public void actionRun() {
		System.out.println("뛸 수 있다");
	}
	
	public void shape() {
		String className = getClass().getName();
		int idx = className.lastIndexOf('.');
		String name = className.substring(idx + 1);
		System.out.println(name + "입니다. 외형은 팔, 다리, 몸통, 머리가 있습니다.");
	}
	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionKnife();
}
