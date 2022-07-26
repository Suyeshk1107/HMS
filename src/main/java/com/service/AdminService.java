package com.service;

import bean.Doctor;

public interface AdminService {

	boolean generateAppointment(int patientId); 
	//consists the functionality where in patient
	//	details get matched with available doctor's details
	
	boolean cancelAppointment(int patientId);
	
	boolean addPatient(int doctorId,int patientId); //maps a doctor to a patient
	
	boolean removePatient(int doctorId,int patientId);
	
	boolean registerDoctorToDatabase(Doctor doctor); // add this to menu options in admin login
	
	boolean removeDoctorFromDatabase(Doctor doctor);
	
	
	//add patient, and remove patient
//	multiple patients can be mapped to one doctor
}
