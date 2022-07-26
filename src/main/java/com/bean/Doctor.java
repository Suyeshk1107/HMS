package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends Person {
	private String Specialization;
	private int experienceInYears;
	private int casesHandled;
	private boolean isAvailable = true;
}
