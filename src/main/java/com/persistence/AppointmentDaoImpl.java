package com.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDaoImpl implements AppointmentDao {
	ArrayList<String> list = new ArrayList<>();
	
	public void appointment(String patient_id, String new_date) {
		

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("call book_appointment(?)");) {

			preparedStatement.setString(1, patient_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String p_id = resultSet.getString("Patient Id");
				String p_name = resultSet.getString("Patient Name");
				String slot = resultSet.getString("Starting Time");
				String slot_end = resultSet.getString("Ending Time");
				String d_id = resultSet.getString("Doctor Id");
				String d_name = resultSet.getString("Appointed Doctor");
				String dept = resultSet.getString("Department");

				Date date = Date.valueOf(new_date);
				String new_slot = checkSlot(slot, d_id, date);
		
				int a = new_slot.compareTo(slot_end);
				if(a == 0) {
					storeAppointment(p_id, p_name, new_slot, date, d_id, d_name, dept);
					System.out.println(p_id+" "+p_name+" "+new_slot+" "+date+" "+d_id+" "+d_name+" "+dept);
				}
				else
					System.out.println("No slot present for the date :"+date);
				
			}
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public String checkSlot(String slot_to_check, String d_id, Date date) {
		LocalTime new_slot = null;
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("select slot from appointments where doctor_id = ? AND date_of_appointment = ?");) {

			preparedStatement.setString(1, d_id);
			preparedStatement.setDate(2, date);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String slot_present = resultSet.getString("slot");
				list.add(slot_present);
				
				
			}if(list.isEmpty()) {
				return slot_to_check;}
			for(String e:list) {
				System.out.println(e);
			}
			String last_slot = list.get(list.size()-1);
			new_slot = LocalTime.parse(last_slot);
			new_slot = new_slot.plusMinutes(20);
			System.out.println(new_slot);
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new_slot.toString();
		
	}
	
	
	public void storeAppointment(String p_id, String p_name, String new_slot, Date date, String d_id, String d_name, String dept) {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO Appointments values(?,?,?,?,?,?,?)");) {

			preparedStatement.setString(1, p_id);
			preparedStatement.setString(2, p_name);
			preparedStatement.setString(3, new_slot);
			preparedStatement.setString(4, date.toString());
			preparedStatement.setString(5, d_id);
			preparedStatement.setString(6, d_name);
			preparedStatement.setString(7, dept);
			

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		

	}
	
	public List<String> getAllAppointments(String pid) {
		
		List<String> appointments = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root",
				"wiley");
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from Appointments where patient_id=?");) {

			preparedStatement.setString(1, pid);

			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				appointments.add("[AppointmentID: "+resultSet.getInt("appointment_id")+","
						+ " Slot: "+ resultSet.getTime(3) +", Date of Appointment: "+ resultSet.getDate(4) 
						+", DoctorID:" + resultSet.getString(5) + ", Doctor Name: "+ resultSet.getString(6) +"]");		
			}
			
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return appointments;
	}
	
	

}
