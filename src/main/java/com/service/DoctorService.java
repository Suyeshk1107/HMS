package com.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.bean.Doctor;
import com.bean.Patient;
import com.bean.Schedule;

public interface DoctorService {
	
	boolean updatePatientProfile(String doctorId, String patientId, Map<String,String> editList);
	
	List<Doctor> getAvailableDoctors(Date date);

	Schedule getDoctorSchedule(String doctorId);

//	boolean getPatientProfile(String doctorId, String patientId);

	Patient getPatientProfile(String patientId);

	void displayAvailableDoctors(Date date);

	boolean updateDoctorSchedule(String doctorId, Schedule schedule);
}
