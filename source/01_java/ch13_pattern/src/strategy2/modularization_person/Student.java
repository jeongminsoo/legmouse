package strategy2.modularization_person;

import strategy2_interfaces_person.GetStudentPay;
import strategy2_interfaces_person.JobStudy;

public class Student extends Person {

	private String ban;

	public Student(String id, String name, String ban) {
		super(id, name);
		this.ban = ban;
		setJob(new JobStudy());
		setGet(new GetStudentPay());
	}

	@Override
	public void print() {
		super.print();
		System.out.print(" [¹Ý]" + ban + "\n");
	}
}
