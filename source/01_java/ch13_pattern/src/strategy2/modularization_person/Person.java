package strategy2.modularization_person;

import strategy2_interfaces_person.IGet;
import strategy2_interfaces_person.IJob;

public class Person {

	private IJob job;
	private IGet get;
	private String id;
	private String name;

	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public void print() {
		System.out.print("[ID]" + id + " [¿Ã∏ß]" + name);
	}

	public void job() {
		job.job();
	}

	public void get() {
		get.get();
	}

	public void setJob(IJob job) {
		this.job = job;
	}

	public void setGet(IGet get) {
		this.get = get;
	}

	public String getName() {
		return name;
	}

}
