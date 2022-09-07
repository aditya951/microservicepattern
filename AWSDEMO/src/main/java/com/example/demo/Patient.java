package com.example.demo;

public class Patient {

	private String id;
	private String Name;
	private String age;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(String id, String name, String age) {
		super();
		this.id = id;
		Name = name;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", Name=" + Name + ", age=" + age + "]";
	}
	
	
	
	
}
