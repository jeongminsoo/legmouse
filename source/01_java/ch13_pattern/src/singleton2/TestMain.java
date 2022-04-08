package singleton2;

public class TestMain {

	public static void main(String[] args) {
		
		FirstClass firstObj = new FirstClass();
		SecondClass secondobj = new SecondClass();
		SingletonClass singleObj = SingletonClass.getInstance();
		
		System.out.println("MainÇÔ¼ö¿¡¼­ ½Ì±ÛÅæ °´Ã¼ÀÇ i°ª : " + singleObj.getI());
		
	}
}
