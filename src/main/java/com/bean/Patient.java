package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends Person{
	public Patient(String password, String name, int age, String gender, String contactNumber) {
		// TODO Auto-generated constructor stub
	}
	private String symptoms;
	private String illness;
	private String illnessDuration;

}
