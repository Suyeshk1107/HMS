package com.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.bean.Patient;
import com.bean.Schedule;
import com.persistence.AppointmentDaoImpl;
import com.persistence.DoctorDaoImpl;
import com.persistence.PatientDaoImpl;
import com.persistence.ScheduleDaoImpl;

public class DoctorServiceImpl implements DoctorService {

	PatientDaoImpl patientDaoImpl = new PatientDaoImpl();
	ScheduleDaoImpl scheduleDaoImpl = new ScheduleDaoImpl();
	DoctorDaoImpl doctorDaoImpl = new DoctorDaoImpl();
	AppointmentDaoImpl appointmentDaoImpl = new AppointmentDaoImpl();
	
	@Override
	public Patient getPatientProfile(String patientId) {
		return patientDaoImpl.getPatientById(patientId);		
	}

	@Override
	public boolean updatePatientProfile(String doctorId, String patientId, Map<String, String> editList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Schedule getDoctorSchedule(String doctorId) {
		return scheduleDaoImpl.getDoctorSchedule(doctorId);
	}

	@Override
	public boolean updateDoctorSchedule(String doctorId, Schedule schedule) {
		if(scheduleDaoImpl.removeDoctorSchedule(doctorId))
			return scheduleDaoImpl.addDoctorSchedule(schedule);
		return false;
	}

	@Override
	public List<Schedule> getAvailableDoctors(Date date) {
		return doctorDaoImpl.getAvailableDoctors(date);
	}

	@Override
	public void displayAvailableDoctors(Date date) {
		List<Schedule> doctors = getAvailableDoctors(date);
		if (doctors == null){
			System.out.println("No Doctor Available");
		} 
		else {
			for(Schedule doc: doctors) {
				System.out.println(doc.toString());
			}
		}
	}
	
	@Override
	public List<String> getMyAppointments(String id, int choice) {
		return appointmentDaoImpl.getAllAppointments(id, choice);
	}

}
