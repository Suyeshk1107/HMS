package com.presentation;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.bean.Doctor;
import com.bean.Patient;
import com.bean.PrevSlots;
import com.bean.Schedule;
import com.service.AdminServiceImpl;
import com.service.AppointmentServiceImpl;
import com.service.DoctorServiceImpl;
import com.service.PatientServiceImpl;
import com.service.ValidateUserServiceImpl;

public class PresentationImpl implements Presentation {

	Scanner sc = new Scanner(System.in);		//its is for integer
	Scanner str = new Scanner(System.in);		//for string -> next()
	Scanner sl = new Scanner(System.in);		//for lines -> nextLine()
	
	@Override
	public void showMenu() {
		
		System.out.println("============================Hospital Management System===================");
		System.out.println("1. User Login");
		System.out.println("2. Register User");
		System.out.println("3. Contact Us");
		System.out.println("4. Exit");
		
		int choice = sc.nextInt();
		performMenu(choice);

	}

	@Override
	public void performMenu(int choice) {

		switch(choice) {
//		==================================================>		
		case 1: signIn();
				break;
		
		case 2: register();
				break;
		
		case 3:
				System.out.println("TO be done");
				break;
			
		case 4:	System.out.println("======== Thank you for using our Hospital Management System ===============");
				System.exit(0);
			
		default:System.out.println("Wrong Input!!");
			
		}
	}
	
	@Override
	public void signIn() {
		System.out.println("=========== Login Page ============");
		System.out.println("1. Login as a Patient ");
		System.out.println("2. Login as a Doctor ");
		System.out.println("3. Login as Admin ");
		System.out.println("4. Exit");
		
		int choice = sc.nextInt();
		char chosen = 'y';
		
		while(chosen == 'y' || chosen == 'Y') {
			logIn(choice);
			System.out.println("Want to continue(y/n):");
			chosen = str.next().charAt(0);
		}
				
	}
			
	@Override
	public void logIn(int choice) {
		
		String id;
		String password;
		char chosen = 'y';
		ValidateUserServiceImpl user = new ValidateUserServiceImpl();
		boolean isValid;
		
		switch(choice) {
		
		case 1:	System.out.println("Enter Patient id : ");
				id = str.next();
				System.out.println("Enter password : ");
				password = str.next();
				
				isValid = user.isPatient(id, password);
				if(!isValid) {
					System.out.println("Invalid Credentials");
					return;
				}
				System.out.println("Logged in successfully ============");
				
				while(chosen == 'y' || chosen == 'Y') {
					postLogin(1,id);
					System.out.println("Want to continue(y/n):");
					chosen = str.next().charAt(0);
				}
				break;
		
		case 2:	System.out.println("Enter Doctor id : ");
				id = str.next();
				System.out.println("Enter password : ");
				password = str.next();
				
				isValid = user.isDoctor(id, password);
				if(!isValid) {
					System.out.println("Invalid Credentials");
					return;
				}
				System.out.println("Logged in successfully ============");
				
				while(chosen == 'y' || chosen == 'Y') {
					postLogin(2,id);
					System.out.println("Want to continue(y/n):");
					chosen = str.next().charAt(0);
				}
				break;
		
		case 3:	System.out.println("Enter Admin id : ");
				id = str.next();
				System.out.println("Enter password : ");
				password = str.next();
				
				isValid = user.isAdmin(id, password);
				if(!isValid) {
					System.out.println("Invalid Credentials");
					return;
				}
				System.out.println("Logged in successfully ============");
				
				while(chosen == 'y' || chosen == 'Y') {
					postLogin(3,id);
					System.out.println("Want to continue(y/n):");
					chosen = str.next().charAt(0);
				}
				
				break;
		
		case 4: System.exit(0);
		
		default: System.out.println("Wrong Input!!");
		}	
		System.out.println("Thanks for visiting HMS!!");
	}
	

	public void postLogin(int choice,String id) {
		
		int select;
		Date date;
		
		System.out.println("Welcome Onboard!");
		
		switch(choice) {
		
		case 1:	PatientServiceImpl patientService = new PatientServiceImpl();
				AppointmentServiceImpl appointmentServiceImpl = new AppointmentServiceImpl();
			
				System.out.println("1. User profile(Patient)");
				System.out.println("2. Show Appointment Slots");
				System.out.println("3. Request Appointment");
				System.out.println("4. Cancel Appointment Request");
				System.out.println("5. Reschedule appointment ");
				System.out.println("6. Exit.");
				
				select = sc.nextInt();
				
				switch (select) {
				case 1:	patientService.getPatientProfile(id);
						break;

				case 2: System.out.println("Enter Doctor Id : ");
						List<PrevSlots> prevSlots =  appointmentServiceImpl.prevSlots(str.next());
						if(prevSlots == null) {
							System.out.println("No appointments present!!");
							break;
						}
						for(PrevSlots e:prevSlots) {
							System.out.println(e);
						}
						break;
				case 3: System.out.println("Enter date of appointment(yyyy-mm-dd)");
						date = Date.valueOf(str.next());
						LocalDate today = LocalDate.now();
						if(date.toString().compareTo(today.toString()) < 0) {
							System.out.println("Entered date is invalid!!");
							break;
						}
						System.out.println("List of Available Doctors:");
				 		new DoctorServiceImpl().displayAvailableDoctors(date);
						System.out.println("Select Doctor ID for appointment:");
						patientService.requestAppointment(id, str.next(), date); //LocalDate.now() as default
						break;

				case 4: List<String> appointments = patientService.getMyAppointments(id, 1);
						if(appointments.isEmpty()) {
							System.out.println("No appointments requested.");
							break;
						}
						else {
							System.out.println("Displaying all appointments: ");
							for(String appointment: appointments)
								System.out.println(appointment);
						}
						System.out.println("Enter appointment id for cancellation: ");
						if(patientService.cancelAppointmentRequest(sc.nextInt()))
							System.out.println("Appointment Cancelled.");
						else
							System.out.println("No appointment cancelled!!");
						break;

				case 5: List<String> allAppointments = patientService.getMyAppointments(id, 1);
						if(allAppointments.isEmpty()) {
							System.out.println("No appointments requested.");
							break;
						}
						else {
							System.out.println("Displaying all appointments: ");
							for(String appointment: allAppointments)
								System.out.println(appointment);
						}
						System.out.println("Enter appointment id for rescheduling: ");
						int aid = sc.nextInt();
						System.out.println("Enter new date of appointment");
						date = Date.valueOf(str.next());
						LocalDate todays = LocalDate.now();
						if(date.toString().compareTo(todays.toString()) <= 0) {
							System.out.println("Entered date is invalid!!");
							break;
						}
						if(patientService.rescheduleAppointment(aid, date))
							System.out.println("Appointment rescheduled");
						else
							System.out.println("Error occured. Please try again later!!");
						break;
				
				case 6: System.exit(0);
				
				default: System.out.print("Wrong Input!!");
				}
				break;
			
		case 2:	DoctorServiceImpl doctorService = new DoctorServiceImpl();
				PatientServiceImpl patientServiceImpl = new PatientServiceImpl();
			
				System.out.println("1. View Patient Profile ");
				System.out.println("2. View Doctor Schedule");
				System.out.println("3. View My Scheduled Appointments");
				System.out.println("4. Update Doctor Schedule");
				System.out.println("5. Exit");
	
				select = sc.nextInt();
				
				switch (select) {
				case 1:	System.out.println("Enter Patient ID: ");
						patientServiceImpl.getPatientProfile(str.next());
						break;
						
				case 2:	System.out.println("Doctor Schedule:\n"+ doctorService.getDoctorSchedule(id).toString());
						break;
						
				case 3: System.out.println("Your Scheduled Appointments for the Day:");
						List<String> appointmentDoc = doctorService.getMyAppointments(id, 2);
						if(appointmentDoc.isEmpty()) {
							System.out.println("No appointments requested.");
							break;
						}
						else {
							System.out.println("Displaying all appointments: ");
							for(String appointment: appointmentDoc)
								System.out.println(appointment);
						}
						break;
					
				case 4: System.out.println("Enter Schedule details to be updated:");
						
						System.out.println("Enter Doc ID: ");
						String doctor_id = str.next();  
						
						System.out.println("Enter Doc Name:");
						String name_of_doctor= sl.nextLine(); 
						
						System.out.println("Enter Available Day:");
						String available_day= str.next(); 
						
						System.out.println("Enter start slot time:");
						Time slot_start = Time.valueOf(str.next()); 
						
						System.out.println("Enter end slot time:");
						Time slot_end = Time.valueOf(str.next());

						
						if(doctorService.updateDoctorSchedule(id, new Schedule(doctor_id,name_of_doctor,available_day,slot_start,slot_end)))
							System.out.println("Doctor Schedule Updated");
						else
							System.out.println("Unable to update Schedule!!");
						break;
				
				case 5: System.exit(0);
				
				default: System.out.println("Wrong Input!!");
				}
				break;
			
		case 3:	AdminServiceImpl adminService = new AdminServiceImpl();
				System.out.println("1. Register Doctor To Database");
				System.out.println("2. Remove Doctor");
				System.out.println("3. Exit");
				
				select = sc.nextInt();
				
				switch (select) {
						
				case 1:	System.out.println("Register Doctor To Database");
						System.out.println("Enter doctor details:");
						Doctor doc = new Doctor();
						System.out.println("Enter name: "); 		doc.setName(sl.nextLine());
						System.out.println("Experience In Years:");	doc.setExperienceInYears(sc.nextInt());
						System.out.println("Address:"); 			doc.setAddress(sl.nextLine());
						System.out.println("Age: ");				doc.setAge(sc.nextInt());
						System.out.println("Department: ");	 		doc.setDepartment(sl.nextLine());
						System.out.println("Contact Number: "); 	doc.setContactNumber(sl.nextLine());
						System.out.println("Gender: ");				doc.setGender(str.next());
						
						if(adminService.registerDoctorToDatabase(doc))
							System.out.println("Doctor added successfully");
						else
							System.out.println("Doctor can't be added");
						break;
						
				case 2: System.out.println("Enter Doctor Id to be removed: "); 
						String doctorID = str.next();
						if(adminService.removeDoctorFromDatabase(doctorID)) {
							System.out.println(doctorID + " doctor ID is removed");
						}
						else
							System.out.println("Unable to remove doctorID "+ doctorID);
				 		break;
				 
				case 3: System.exit(0);
				 		
				default:System.out.println("Wrong Input!!");
				}
				break;
				
		default:System.out.println("Wrong Input!!");
		}
	}
	
	
	@Override
	public void register() {
		
		ValidateUserServiceImpl user = new ValidateUserServiceImpl();
		Patient patient = new Patient(); 
		PatientServiceImpl impl = new PatientServiceImpl();
		
		patient.setCounter(impl.getLastPatientId());
		
		patient.setPersonId("P" + patient.getCounter());
		System.out.println("Enter Patient Name : ");
		patient.setName(sl.nextLine());
		System.out.println("Enter patient age : ");
		patient.setAge(sc.nextInt());
		System.out.println("Enter patient gender : ");
		patient.setGender(str.next());
		System.out.println("Enter patient contactNumber : ");
		patient.setContactNumber(str.next());
		System.out.println("Enter patient address: ");
		patient.setAddress(sl.nextLine());
		System.out.println("Enter patient symptoms : ");
		patient.setDepartment(sl.nextLine());


		boolean registrationStatus = user.registerPatient(patient);

		if(registrationStatus) { 
			String password;
			System.out.println("User registered Successfully");
			System.out.println("Please note your Id for future references");
			System.out.println("ID: "+ patient.getPersonId());	
			System.out.println("Enter password: ");
			password = str.next();
			// store this password & id in Login database
			if(user.registerUser(patient.getPersonId(), password))
				System.out.println("User registered in system");
			else
				System.out.println("User not registered");
		}else {
			System.out.println("Operation failed");
			System.out.println("Please try again.");
			return;
		}
	}

}
