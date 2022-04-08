package singleton2;

public class SingletonClass {

	private int i= 10;

	private SingletonClass() {
	}
	
	private static SingletonClass INSTANCE = new SingletonClass();
	
	public static SingletonClass getInstance() {
		return INSTANCE;
	}
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	
}
