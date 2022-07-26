package com.service;

import bean.Doctor;
import bean.Patient;

public interface ValidateUserService {
boolean isPatient(int id, String Password);
	
	boolean isDoctor(int id, String Password);
	
	boolean isAdmin(int id, String Password);
	
	boolean registerPatient(Patient patient);
	
	boolean registerDoctor(Doctor doctor); // called internally only by admin 
	
}
