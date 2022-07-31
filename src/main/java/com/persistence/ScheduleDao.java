package com.persistence;

import com.bean.Schedule;

public interface ScheduleDao {


	Schedule getDoctorSchedule(int doctorId);
	
	boolean addDoctorSchedule(Schedule schedule);
	boolean removeDoctorSchedule(int doctorId);
	

}
