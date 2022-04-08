package strategy2.modularization_person;

import strategy2_interfaces_person.GetSalary;
import strategy2_interfaces_person.JobMng;

public class Staff extends Person {

	private String part;

	public Staff(String id, String name, String part) {
		super(id, name);
		this.part = part;
		setJob(new JobMng());
		setGet(new GetSalary());
	}

	@Override
	public void print() {
		super.print();
		System.out.print(" [ºÎ¼­]" + part + "\n");
	}

}
