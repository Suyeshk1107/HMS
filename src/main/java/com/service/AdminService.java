package com.service;

import java.sql.Date;
import java.util.List;

import com.bean.Doctor;

public interface AdminService {

	boolean generateAppointment(String patientId); 
	//consists the functionality where in patient
	//	details get matched with available doctor's details
	
	boolean cancelAppointment(String patientId);
	
//	boolean addPatient(String doctorId,String patientId); //maps a doctor to a patient
//	
//	boolean removePatient(String doctorId,String patientId);
	
	boolean registerDoctorToDatabase(Doctor doctor); // add this to menu options in admin login
	
	List<Doctor> getAvailableDoctors(Date date);

	boolean removeDoctorFromDatabase(String doctorID);
	
//	boolean displayAvailableDoctors(); //doctor list + emergencyContact
	//add patient, and remove patient
//	multiple patients can be mapped to one doctor
}
