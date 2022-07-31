package com.service;

import java.util.List;

import com.bean.Doctor;

public interface AdminService {

	boolean generateAppointment(int patientId); 
	//consists the functionality where in patient
	//	details get matched with available doctor's details
	
	boolean cancelAppointment(int patientId);
	
	boolean addPatient(int doctorId,int patientId); //maps a doctor to a patient
	
	boolean removePatient(int doctorId,int patientId);
	
	boolean registerDoctorToDatabase(Doctor doctor); // add this to menu options in admin login
	
	List<Doctor> getAvailableDoctors();

	boolean removeDoctorFromDatabase(String doctorID);
	
//	boolean displayAvailableDoctors(); //doctor list + emergencyContact
	//add patient, and remove patient
//	multiple patients can be mapped to one doctor
}
