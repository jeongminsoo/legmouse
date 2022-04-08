package singleton1;

public class TestMain {

	public static void main(String[] args) {
		
		SingletonClass obj1 = SingletonClass.getInstance();
		SingletonClass obj2 = SingletonClass.getInstance();
		
		System.out.println(obj1.getI());
		obj1.setI(99);
		System.out.println("obj1ÀÇ i : " + obj1.getI());
		System.out.println("obj2ÀÇ i : " + obj2.getI());
		
	}
}
