package strategy2_interfaces_person;

public class GetSalary implements IGet {

	@Override
	public void get() {
		System.out.println("월급을 받습니다.");
	}

}
