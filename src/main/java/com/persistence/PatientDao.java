package com.persistence;

import java.util.List;

import com.bean.Patient;

public interface PatientDao {


	List<Patient> getPatientList();
	
	Patient getPatientById(int patientId);
	
	boolean addPatient(Patient patient);
	
	boolean removePatient(int patientId);
	
//	boolean searchPatientId(String patientName);
//	boolean searchPatientId(String patientName);
}