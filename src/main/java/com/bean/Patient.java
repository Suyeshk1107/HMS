package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends Person{
	
	public void updateCounter() {
		counter = getCounter() + 1;
	}
	
	public int getCounter() {
		return counter;
	}
	private String address;

//	private String symptoms;
//	private String illness;

	public Patient(int personId, String Name, int age, String gender, String contactNumber, String Department,
		String address) {
		super(personId, Name, age, gender, contactNumber, Department);
		this.address = address;
	}
	private String symptoms;
//	private String illness;
//	private String illnessDuration;
	private static int counter = 1000;

}
	
	
}