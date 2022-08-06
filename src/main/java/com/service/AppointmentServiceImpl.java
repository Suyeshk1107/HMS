package com.service;

import java.util.List;

import com.bean.PrevSlots;
import com.persistence.AppointmentDaoImpl;
public class AppointmentServiceImpl implements AppointmentService {
	AppointmentDaoImpl appointmentDaoImpl = new AppointmentDaoImpl();
	@Override
	public List<PrevSlots> prevSlots(String dId) {
		// TODO Auto-generated method stub
		return appointmentDaoImpl.prevAppointments(dId);
	}

}
