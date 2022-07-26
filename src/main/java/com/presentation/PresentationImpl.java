package com.presentation;

import java.util.Scanner;

public class PresentationImpl implements Presentation {

	@Override
	public void showMenu() {
		// TODO Auto-generated method stub
		System.out.println("============================Hospital Management System===================");
		System.out.println("1. Login/Register");
		System.out.println("2. Contact Us");
		System.out.println("3. To exit");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		performMenu(choice);

	}

	@Override
	public void performMenu(int choice) {
		// TODO Auto-generated method stub

	}

	@Override
	public void signIn(int selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logIn(int choice) {
		// TODO Auto-generated method stub

	}

	@Override
	public void register() {
		// TODO Auto-generated method stub

	}

}
