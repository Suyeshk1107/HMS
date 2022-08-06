package com.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import com.bean.Schedule;

public class ScheduleDaoImpl implements ScheduleDao {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	Connection connectDB() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "wiley");
	}
	
	@Override
	public Schedule getDoctorSchedule(String doctorId) {
		
		Schedule schedule = null;
		try{
			this.connection = connectDB();
			preparedStatement = connection.prepareStatement("SELECT * FROM regular_schedule where doctor_id=?");
			preparedStatement.setString(1, doctorId);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				String id = resultSet.getString("doctor_id");
				String name = resultSet.getString("name_of_doctor");
				String day = resultSet.getString("available_day");
				Time slot_start = resultSet.getTime("slot_start");
				Time slot_end = resultSet.getTime("slot_end");
				

				schedule = new Schedule(id,name,day,slot_start,slot_end);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return schedule;
	}

	@Override
	public boolean addDoctorSchedule(Schedule schedule) {
		int rows = 0;
		try{
			this.connection = connectDB();
			preparedStatement = connection.prepareStatement("INSERT INTO regular_schedule values(?,?,?,?,?)");

			preparedStatement.setString(1, schedule.getDoctor_id());
			preparedStatement.setString(2, schedule.getName_of_doctor());
			preparedStatement.setString(3, schedule.getAvailable_day());
			preparedStatement.setTime(4, schedule.getSlot_start());
			preparedStatement.setTime(5, schedule.getSlot_end());
			

			rows = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (rows>0)
			return true;
		return false;
	}

	

	@Override
	public boolean removeDoctorSchedule(String doctorId) {
		// TODO Auto-generated method stub
		try{
			this.connection = connectDB();
			preparedStatement = connection.prepareStatement("DELETE FROM REGULAR_SCHEDULE where doctor_id=?");
			preparedStatement.setString(1, doctorId);

			preparedStatement.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
