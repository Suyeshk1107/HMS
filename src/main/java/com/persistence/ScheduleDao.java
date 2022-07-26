package com.persistence;

public interface ScheduleDao {


	boolean getDoctorSchedule(int doctorId);
	
	boolean updateDoctorSchedule(int doctorId);
	

}
