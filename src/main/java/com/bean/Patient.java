package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends Person{
//	private String symptoms;
//	private String illness;
	private String address;

	public Patient(int personId, String Name, int age, String gender, String contactNumber, String Department,
		String address) {
		super(personId, Name, age, gender, contactNumber, Department);
		this.address = address;
	}
	
	
}