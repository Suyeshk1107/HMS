package com.service;

import com.bean.Doctor;
import com.bean.Patient;

public interface ValidateUserService {
boolean isPatient(int id, String Password);
	
	boolean isDoctor(int id, String Password);
	
	boolean isAdmin(int id, String Password);
	
	boolean registerPatient(Patient patient);
	
	boolean registerDoctor(Doctor doctor); // called internally only by admin 
	
}
