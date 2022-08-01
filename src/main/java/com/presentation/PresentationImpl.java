package com.presentation;

import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

import com.bean.Patient;
import com.bean.Schedule;
import com.service.AdminServiceImpl;
import com.service.DoctorServiceImpl;
import com.service.PatientServiceImpl;
import com.service.ValidateUserServiceImpl;

public class PresentationImpl implements Presentation {

	Scanner sc = new Scanner(System.in);
	Scanner str = new Scanner(System.in);
	
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
	//			System.out.println("======= List of Doctors and their emergency Contact numbers ===============");
	//			DoctorServiceImpl doctorService = new DoctorServiceImpl();
	//			boolean isDone = doctorService.displayAvailableDoctors();
	//			if(!isDone) {
	//				System.out.println("Operation Failed");
	//			}
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
		
		logIn(choice);		
	}
			
	@Override
	public void logIn(int choice) {
		
		String id;
		String password;
		ValidateUserServiceImpl user = new ValidateUserServiceImpl();
		boolean isValid;
		
		switch(choice) {
		
		case 1:	System.out.println("Enter Patient id : ");
				id = str.nextLine();
				System.out.println("Enter password : ");
				password = str.nextLine();
				
				isValid = user.isPatient(id, password);
				if(!isValid) {
					System.out.println("Invalid Credentials");
					return;
				}
				System.out.println("Logged in successfully ============");
				postLogin(1,id);
				break;
		
		case 2:	System.out.println("Enter Doctor id : ");
				id = str.nextLine();
				System.out.println("Enter password : ");
				password = str.nextLine();
				
				isValid = user.isDoctor(id, password);
				if(!isValid) {
					System.out.println("Invalid Credentials");
					return;
				}
				System.out.println("Logged in successfully ============");
				postLogin(2,id);
				break;
		
		case 3:	System.out.println("Enter Admin id : ");
				id = str.nextLine();
				System.out.println("Enter password : ");
				password = str.nextLine();
				
				isValid = user.isAdmin(id, password);
				if(!isValid) {
					System.out.println("Invalid Credentials");
					return;
				}
				System.out.println("Logged in successfully ============");
				postLogin(3,id);
				break;
		
		case 4: System.exit(0);
		
		default: System.out.println("Wrong Input!!");
		}	
	}
	
//======================================================>
	public void postLogin(int choice,String id) {
		
		int select;
		Date date;
		
		System.out.println("Welcome Onboard!");
		
		switch(choice) {
		
		case 1:	PatientServiceImpl patientService = new PatientServiceImpl();
			
				System.out.println("1. User profile(Patient)");
				System.out.println("2. Request Appointment");
				System.out.println("3. Cancel Appointment Request");
				System.out.println("4. Reschedule appointment ");
				System.out.println("5. Exit.");
				
				select = sc.nextInt();
				
				switch (select) {
				case 1:	patientService.getPatientProfile(id);
						break;
				
				case 2: System.out.println("Enter date of appointment(yyyy-mm-dd)");
						date = new Date(sc.nextLong());
						patientService.requestAppointment(id, date); //LocalDate.now() as default
						break;
						
				case 3: patientService.cancelAppointmentRequest(id); // maybe need to add appointment id and list of appointments
						break; //may require date for more appointments
					
				case 4: System.out.println("Enter new date of appointment");
						date = new Date(sc.nextLong());
						patientService.rescheduleAppointment(id, date); //improvisation required
						break;
				
				case 5: System.exit(0);
				
				default:
				}
				break;
			
		case 2:	DoctorServiceImpl doctorService = new DoctorServiceImpl();
				PatientServiceImpl patientServiceImpl = new PatientServiceImpl();
			
				System.out.println("1. View Patient Profile ");
				System.out.println("2. Update Patient Profile");
				System.out.println("3. View Doctor Schedule");
				System.out.println("4. Update Doctor Schedule");
	
				select = sc.nextInt();
				
				switch (select) {
				case 1:	System.out.println("Enter Patient ID: ");
						patientServiceImpl.getPatientProfile(str.nextLine());
						break;
				
				case 2: System.out.println("To be done");
						break;
						
				case 3: doctorService.getDoctorSchedule(id); // maybe need to add appointment id and list of appointments
						break;
					
				case 4: 
						System.out.println("Enter Schedule details to be updated:");
						
						String doctor_id = str.next();  
						String name_of_doctor= str.nextLine(); 
						String available_day= str.next(); 
						Time slot_start = Time.valueOf(str.next()); 
						Time slot_end = Time.valueOf(str.next());

						
						doctorService.updateDoctorSchedule(id, new Schedule(doctor_id,name_of_doctor,available_day,slot_start,slot_end));
						break;
				
				case 5: System.exit(0);
				
				default: System.out.println("Wrong Input!!");
				}
				break;
			
		case 3:	AdminServiceImpl adminService = new AdminServiceImpl();
				System.out.println("1. Generate Appointment ");
				System.out.println("2. Cancel Appointment ");
				System.out.println("3. Add Patient");
				System.out.println("4. Remove Patient");
				System.out.println("5. Register Doctor To Database");
				System.out.println("6. Remove Doctor");
				
				select = sc.nextInt();
				
				switch (select) {
				case 1:	System.out.println("Generate Appointment");
						break;
				case 2:	System.out.println("Cancel Appointment");
						break;
				case 3:	System.out.println("Add Patient");
						break;
				case 4:	System.out.println("Remove Patient");
						break;
				case 5:	System.out.println("Register Doctor To Database");
						break;
				case 6: System.out.println("Enter Doctor Id to be removed: "); 
						String doctorID = str.next();
						if(adminService.removeDoctorFromDatabase(doctorID)) {
							System.out.println(doctorID + " doctor ID is removed");
						}
						else
							System.out.println("Unable to remove doctorID "+ doctorID);
				 		break;
				default:System.out.println("Wrong Input!!");
				}
				break;
				
		default:System.out.println("Wrong Input!!");
		}
		
	}
	
	
	@Override
	public void register() {
				
		Patient patient = new Patient(); 
		System.out.println("Enter Patient Name : ");
		patient.setName(str.nextLine());
		System.out.println("Enter patient age : ");
		patient.setAge(sc.nextInt());
		System.out.println("Enter patient gender : ");
		patient.setGender(str.next());
		System.out.println("Enter patient contactNumber : ");
		patient.setContactNumber(str.next());
		System.out.println("Enter patient department : ");
		patient.setDepartment(str.next());

		ValidateUserServiceImpl user = new ValidateUserServiceImpl();

		boolean registrationStatus = user.registerPatient(patient);

		if(registrationStatus) {
			String pid = "P" + patient.getCounter(); 
			String password;
			patient.updateCounter();
			System.out.println("User registered Successfully");
			System.out.println("Please note your Id for future references");
			System.out.println("ID: "+ pid);	
			System.out.println("Enter password: ");
			password = str.nextLine();
			// store this password & id in Login database
		}else {
			System.out.println("Operation failed");
			System.out.println("Please try again.");
			return;
		}
	}

}
