package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends Person{

	private String address;
	private static int counter = 1000;

	public Patient(String personId, String Name, int age, String gender, String contactNumber, String Department,
		String address) {
		super(personId, Name, age, gender, contactNumber, Department);
		this.address = address;
	}

	public void updateCounter() {
		counter = getCounter() + 1;
	}
	
	public int getCounter() {
		return counter;
	}

	@Override
	public String toString() {
		return "Patient [PersonId=" + getPersonId() + ", Name=" + getName()
				+ ", Age=" + getAge() + ", Gender=" + getGender() + ", ContactNumber="
				+ getContactNumber() + ", Department=" + getDepartment() + ", address=" + getAddress() +"]";
	}

}