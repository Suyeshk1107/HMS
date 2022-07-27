package com.persistence;

import com.bean.Admin;
import com.bean.Doctor;
import com.bean.Patient;

public interface LoginDao {

	boolean registerUser();

	boolean setAdmin(Admin admin);
	
//	boolean addPatientToDatabase(Patient patient);
//	
//	boolean removePatientFromDatabase(int patientId);
//	
//	boolean addDoctorToDatabase(Doctor doctor);
//	
//	boolean removeDoctorFromDatabase(int patientId);
//	
	
	boolean getPassword(int id);
	
}

//transaction, appointment