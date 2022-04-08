package strategy2.modularization_person;

import strategy2_interfaces_person.GetSalary;
import strategy2_interfaces_person.JobLec;

public class Lecturer extends Person {

	private String subject;
	
	public Lecturer(String id, String name, String subject) {
		super(id, name);
		this.subject = subject;
		setJob(new JobLec());
		setGet(new GetSalary());
	}
	
	@Override
	public void print() {
		super.print();
		System.out.print(" [°ú¸ñ]" + subject + "\n");
	}

}
