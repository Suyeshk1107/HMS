package com.persistence;

import bean.Admin;
import bean.Doctor;
import bean.Patient;

public interface LoginDao {

	boolean registerUser();

	boolean setAdmin(Admin admin);
	
	boolean addPatientToDatabase(Patient patient);
	
	boolean removePatientFromDatabase(int patientId);
	
	boolean addDoctorToDatabase(Doctor doctor);
	
	boolean removeDoctorFromDatabase(int patientId);
	
	boolean getPassword(int id);
	
}
