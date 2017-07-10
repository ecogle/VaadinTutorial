package com.eco.gdit.udemy.vaadin.Tutorial2;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Person {

	@NotNull(message="Have to specify name")
	private String name;
	
	@NotNull(message="Have to specify age")
	@Min(value=0,message="Can not be smaller than 0")
	@Max(value=100,message="Can not be greater than 100")
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Person(){
		
	}
	
	@Override
	public String toString(){
		return this.name + " " + this.age;
	}
	
	
}
