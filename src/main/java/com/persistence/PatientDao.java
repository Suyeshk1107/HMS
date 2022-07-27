package com.persistence;

import com.bean.Patient;

public interface PatientDao {


	boolean getPatientList();
	
	boolean getPatientDetails(int patientId);
	
	boolean addPatient(Patient patient);
	
	boolean removePatient(int patientId);
	
	boolean searchPatientId(String patientName);
}
