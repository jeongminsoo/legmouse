package com.lec.ex13;

public class Person {
	
	private String id;
	private String name;
	private String no;
	
	public Person(String id, String name) {
		this.id = id;
		this.name = name;
	}
	public void print() {
		System.out.printf("[��ȣ]%s [Id]%s (�̸�):%s ", no, id, name);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
	
	
}
