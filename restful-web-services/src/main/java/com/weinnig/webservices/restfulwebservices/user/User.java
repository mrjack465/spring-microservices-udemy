package com.weinnig.webservices.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	
	private static final int MIN_NAME_LENGTH = 5; 
	
	@Size(min=MIN_NAME_LENGTH, message="Name should have at least " + MIN_NAME_LENGTH + ".")
	private String name;
	
	private Integer id;
	
	@Past(message="Date should be in the past.")
	private Date date;
	
	protected User() {}
	
	public User(Integer id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}
	
	public User(int id, String name, Date date) {
		super();
		this.id = new Integer(id);
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = new Integer(id);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id.toString() + ", date=" + date + "]";
	}
	
}
