package singleton2;

public class TestMain {

	public static void main(String[] args) {
		
		FirstClass firstObj = new FirstClass();
		SecondClass secondobj = new SecondClass();
		SingletonClass singleObj = SingletonClass.getInstance();
		
		System.out.println("Main�Լ����� �̱��� ��ü�� i�� : " + singleObj.getI());
		
	}
}
