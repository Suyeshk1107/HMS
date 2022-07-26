package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends Person{
	private String symptoms;
	private String illness;
	private String illnessDuration;

}
